package com.neilbaner.duke;

import com.neilbaner.duke.exceptions.*;
import com.neilbaner.duke.messages.Messages;
import com.neilbaner.duke.serialize.Serializer;
import com.neilbaner.duke.task.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Duke {
    public static TaskList list = new TaskList();

    private static void loadTasks() {
        File saveFile = new File("dukesave.txt");
        try {
            Scanner fs = new Scanner(saveFile);
            while(fs.hasNext()) {
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

    private static String getEventTime(String input) {
        return input.substring(input.indexOf("/at") + 4).strip();
    }

    private static String getEventTitle(String input) {
        return input.substring(6, input.indexOf("/at")).strip();
    }

    private static String getDeadlineDueDate(String input) {
        return input.substring(input.indexOf("/by") + 4).strip();
    }

    private static int getIndexToMark(String input) {
        return Integer.parseInt(input.substring(5)) - 1;
    }

    private static int getIndexToDelete(String input) {
        return Integer.parseInt(input.substring(7)) - 1;
    }

    private static String getDeadlineTitle(String input) {
        return input.substring(9, input.indexOf("/by")).strip();
    }

    private static void saveState() throws IOException {
        FileWriter fw = new FileWriter("dukesave.txt", false);
        fw.write(Serializer.serializeTaskList(list));
        fw.close();
    }

    private static boolean parseInput(String input) throws DukeException {
        String lowerCaseInput = input.toLowerCase();
        if (lowerCaseInput.equals("bye")) {
            Messages.printGoodBye();
            try{
                saveState();
            }catch (IOException e) {
                System.err.println("Error saving the state. Your data was not saved.");
            }
            return false;
        } else if (lowerCaseInput.equals("list")) {
            printTaskList();
        } else if (lowerCaseInput.startsWith("done")) {
            try {
                int indexToMark = getIndexToMark(input);
                markAsDone(indexToMark);
            } catch (NumberFormatException e) {
                Messages.printFormattingError();
            } catch (IndexOutOfBoundsException e) {
                throw new TaskIndexOutOfBoundsException();
            }
        } else if (lowerCaseInput.startsWith("delete")) {
            try {
                int indexToDelete = getIndexToDelete(input);
                deleteTask(indexToDelete);
            } catch (NumberFormatException e) {
                Messages.printFormattingError();
            } catch (IndexOutOfBoundsException e) {
                throw new TaskIndexOutOfBoundsException();
            }
        } else if (lowerCaseInput.startsWith("todo")) {
            addToDo(input.substring(5));
        } else if (lowerCaseInput.startsWith("deadline")) {
            try {
                String title = getDeadlineTitle(input);
                String dueDate = getDeadlineDueDate(input);
                if (dueDate.equals("")) {
                    throw new BlankDeadlineDateException();
                }
                addDeadline(title, dueDate);
            } catch (IndexOutOfBoundsException e) {
                Messages.printFormattingError();
            }
        } else if (input.startsWith("event")) {
            try {
                String title = getEventTitle(input);
                String eventTime = getEventTime(input);
                if (eventTime.equals("")) {
                    throw new BlankEventTimeException();
                }
                addEvent(title, eventTime);
            } catch (IndexOutOfBoundsException e) {
                Messages.printFormattingError();
            }
        } else {
            throw new UnknownCommandException();
        }
        return true;
    }

    public static void main(String[] args) {
        loadTasks();
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
    }
}
