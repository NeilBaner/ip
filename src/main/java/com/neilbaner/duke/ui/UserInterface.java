package com.neilbaner.duke.ui;

import com.neilbaner.duke.exceptions.BlankDeadlineDateException;
import com.neilbaner.duke.exceptions.BlankEventTimeException;
import com.neilbaner.duke.exceptions.DukeException;
import com.neilbaner.duke.exceptions.UnknownCommandException;
import com.neilbaner.duke.messages.Messages;
import com.neilbaner.duke.task.Task;
import com.neilbaner.duke.task.TaskList;

import java.time.LocalDate;
import java.util.ArrayList;

public class UserInterface {
    TaskList taskList;

    public UserInterface(TaskList taskList) {
        this.taskList = taskList;
    }

    private void printTaskList() {
        Messages.printHorizontalLine();
        if (taskList.getSize() == 0) {
            System.out.println("No tasks added yet");
        }
        for (Task task : taskList.getAllTasksList()) {
            System.out.println(task.toString());
        }
        Messages.printHorizontalLine();
    }

    private void printTaskList(ArrayList<Task> taskListToPrint) {
        Messages.printHorizontalLine();
        if (taskListToPrint.size() == 0) {
            System.out.println("No tasks that match. ");
        }
        for (Task task : taskListToPrint) {
            System.out.println(task.toString());
        }
        Messages.printHorizontalLine();
    }

    public void executeCommand(String command) throws DukeException {
        String lowerCaseInput = command.toLowerCase();
        if (lowerCaseInput.equals(Commands.EXIT_COMMAND)) {
            Messages.printGoodBye();
        } else if (lowerCaseInput.equals(Commands.LIST_COMMAND)) {
            printTaskList();
        } else if (lowerCaseInput.startsWith(Commands.DONE_COMMAND)) {
            int indexToMark = InputParser.getIndexToMark(command);
            markAsDone(indexToMark);
        } else if (lowerCaseInput.startsWith(Commands.DELETE_COMMAND)) {
            int indexToDelete = InputParser.getIndexToDelete(command);
            deleteTask(indexToDelete);
        } else if (lowerCaseInput.startsWith(Commands.ADD_TODO_COMMAND)) {
            addToDo(command.substring(5));
        } else if (lowerCaseInput.startsWith(Commands.ADD_DEADLINE_COMMAND)) {
            String title = InputParser.getDeadlineTitle(command);
            String dueDate = InputParser.getDeadlineDueDate(command);
            if (dueDate.equals("")) {
                throw new BlankDeadlineDateException();
            }
            addDeadline(title, dueDate);
        } else if (lowerCaseInput.startsWith(Commands.ADD_EVENT_COMMAND)) {
            String title = InputParser.getEventTitle(command);
            String eventTime = InputParser.getEventTime(command);
            if (eventTime.equals("")) {
                throw new BlankEventTimeException();
            }
            addEvent(title, eventTime);
        } else if (lowerCaseInput.startsWith(Commands.BEFORE_COMMAND)) {
            LocalDate dateInput = InputParser.getDateFromInput(command, Commands.BEFORE_COMMAND);
            ArrayList<Task> tasksBeforeDateList = list.getAllTasksBeforeList(dateInput);
            printTaskList(tasksBeforeDateList);
        } else if (lowerCaseInput.startsWith(Commands.AT_COMMAND)) {
            LocalDate dateInput = InputParser.getDateFromInput(command, Commands.AT_COMMAND);
            ArrayList<Task> tasksBeforeDateList = list.getAllTasksOnList(dateInput);
            printTaskList(tasksBeforeDateList);
        } else if (lowerCaseInput.startsWith(Commands.FIND_COMMAND)) {
            String searchKey = InputParser.getSearchKey(command);
            ArrayList<Task> searchResults = list.searchTasksResults(searchKey);
            printTaskList(searchResults);
        } else {
            throw new UnknownCommandException();
        }
    }
}
