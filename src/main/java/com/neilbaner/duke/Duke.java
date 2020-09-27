package com.neilbaner.duke;

import com.neilbaner.duke.exceptions.*;
import com.neilbaner.duke.files.Storage;
import com.neilbaner.duke.messages.Messages;
import com.neilbaner.duke.serialize.Serializer;
import com.neilbaner.duke.task.*;
import com.neilbaner.duke.ui.Commands;
import com.neilbaner.duke.ui.InputParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static TaskList list = new TaskList();

    public static final String SAVE_FILE_PATH = "dukesave.txt";

    private static void loadTasks() {
        File saveFile = new File("dukesave.txt");
        try {
            Scanner fs = new Scanner(saveFile);
            while (fs.hasNext()) {
                String currentLine = fs.nextLine();
                Task currentTask = Serializer.deserializeTask(currentLine);
                list.addTask(currentTask);
            }
            fs.close();
        } catch (FileNotFoundException e) {
            System.err.println("Couldn't load the save file. Proceeding without loading.");
        } catch (DeserializerException e) {
            System.err.println("Some error trying to parse the save file. Proceeding without loading. ");
        }
    }

    public static void printTaskList() {
        Messages.printHorizontalLine();
        if (list.getSize() == 0) {
            System.out.println("No tasks added yet");
        }
        for (Task task : list.getAllTasksList()) {
            System.out.println(task.toString());
        }
        Messages.printHorizontalLine();
    }

    public static void printTaskList(ArrayList<Task> taskListToPrint) {
        Messages.printHorizontalLine();
        if (taskListToPrint.size() == 0) {
            System.out.println("No tasks that match. ");
        }
        for (Task task : taskListToPrint) {
            System.out.println(task.toString());
        }
        Messages.printHorizontalLine();
    }

    public static void addToDo(String title) {
        list.addTask(new ToDo(title));
        Messages.printAddedToDo(title);
    }

    public static void addEvent(String title, String eventTime) {
        list.addTask(new Event(title, eventTime));
        Messages.printAddedEvent(title);
    }

    public static void addDeadline(String title, String dueDate) {
        list.addTask(new Deadline(title, dueDate));
        Messages.printAddedDeadline(title);
    }

    public static void markAsDone(int indexToMark) throws NumberFormatException, IndexOutOfBoundsException {
        list.markTaskDone(indexToMark);
        Messages.printMarkedDone(list.getTask(indexToMark).getTitle());
    }

    public static void deleteTask(int indexToDelete) {
        String deletedTitle = list.getTask(indexToDelete).toString();
        list.deleteTask(indexToDelete);
        Messages.printDeleted(deletedTitle);
    }

    private static LocalDate getDateFromInput(String input, String command) throws IncorrectFormattingException {
        try {
            String dateString = input.substring(command.length() + 1);
            LocalDate inputDate = LocalDate.parse(dateString);
            return inputDate;
        } catch (IndexOutOfBoundsException e) {
            throw new IncorrectFormattingException();
        }
    }

    private static boolean parseInput(String input) throws DukeException {
        String lowerCaseInput = input.toLowerCase();
        if (lowerCaseInput.equals(Commands.EXIT_COMMAND)) {
            Messages.printGoodBye();
            return false;
        } else if (lowerCaseInput.equals("list")) {
            printTaskList();
        } else if (lowerCaseInput.startsWith(Commands.DONE_COMMAND)) {
            try {
                int indexToMark = InputParser.getIndexToMark(input);
                markAsDone(indexToMark);
            } catch (NumberFormatException e) {
                Messages.printFormattingError();
            } catch (IndexOutOfBoundsException e) {
                throw new TaskIndexOutOfBoundsException();
            }
        } else if (lowerCaseInput.startsWith(Commands.DELETE_COMMAND)) {
            try {
                int indexToDelete = InputParser.getIndexToDelete(input);
                deleteTask(indexToDelete);
            } catch (NumberFormatException e) {
                Messages.printFormattingError();
            } catch (IndexOutOfBoundsException e) {
                throw new TaskIndexOutOfBoundsException();
            }
        } else if (lowerCaseInput.startsWith(Commands.ADD_TODO_COMMAND)) {
            addToDo(input.substring(5));
        } else if (lowerCaseInput.startsWith(Commands.ADD_DEADLINE_COMMAND)) {
            try {
                String title = InputParser.getDeadlineTitle(input);
                String dueDate = InputParser.getDeadlineDueDate(input);
                if (dueDate.equals("")) {
                    throw new BlankDeadlineDateException();
                }
                addDeadline(title, dueDate);
            } catch (IndexOutOfBoundsException e) {
                Messages.printFormattingError();
            }
        } else if (lowerCaseInput.startsWith(Commands.ADD_EVENT_COMMAND)) {
            try {
                String title = InputParser.getEventTitle(input);
                String eventTime = InputParser.getEventTime(input);
                if (eventTime.equals("")) {
                    throw new BlankEventTimeException();
                }
                addEvent(title, eventTime);
            } catch (IndexOutOfBoundsException e) {
                Messages.printFormattingError();
            }
        } else if (lowerCaseInput.startsWith(Commands.BEFORE_COMMAND)) {
            try {
                LocalDate dateInput = getDateFromInput(input, Commands.BEFORE_COMMAND);
                ArrayList<Task> tasksBeforeDateList = list.getAllTasksBeforeList(dateInput);
                printTaskList(tasksBeforeDateList);
            } catch (DukeException e) {
                e.printErrorMessage(input);
            }
        } else if (lowerCaseInput.startsWith(Commands.AT_COMMAND)) {
            try {
                LocalDate dateInput = getDateFromInput(input, Commands.AT_COMMAND);
                ArrayList<Task> tasksBeforeDateList = list.getAllTasksOnList(dateInput);
                printTaskList(tasksBeforeDateList);
            } catch (DukeException e) {
                e.printErrorMessage(input);
            }
        } else if (lowerCaseInput.startsWith(Commands.FIND_COMMAND)) {
            try {
                String searchKey = InputParser.getSearchKey(input);
                ArrayList<Task> searchResults = list.searchTasksResults(searchKey);
                printTaskList(searchResults);
            }catch (IndexOutOfBoundsException e) {
                Messages.printFormattingError();
            }
        }

        else {
            throw new UnknownCommandException();
        }
        return true;
    }

    public static void main(String[] args) {
        try{
            Storage storage = new Storage(SAVE_FILE_PATH);
            storage.loadState(list);
            Scanner k = new Scanner(System.in);
            String input;
            boolean toContinue = true;
            Messages.printHello();
            while (toContinue) {
                input = k.nextLine();
                try {
                    toContinue = parseInput(input);
                } catch (DukeException e) {
                    e.printErrorMessage(input);
                }
            }
            storage.saveState(list);
        } catch (DukeException e) {
            e.printErrorMessage("");
        }

    }
}
