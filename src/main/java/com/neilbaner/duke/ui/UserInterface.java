package com.neilbaner.duke.ui;

import com.neilbaner.duke.exceptions.*;
import com.neilbaner.duke.messages.OperationMessages;
import com.neilbaner.duke.task.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class UserInterface {
    final TaskList taskList;

    public UserInterface(TaskList taskList) {
        this.taskList = taskList;
    }

    private void printTaskList() {
        OperationMessages.printHorizontalLine();
        if (taskList.getSize() == 0) {
            System.out.println("No tasks added yet");
        }
        for (Task task : taskList.getAllTasksList()) {
            System.out.println(task.toString());
        }
        OperationMessages.printHorizontalLine();
    }

    private void printTaskList(ArrayList<Task> taskListToPrint) {
        OperationMessages.printHorizontalLine();
        if (taskListToPrint.size() == 0) {
            System.out.println("No tasks that match. ");
        }
        for (Task task : taskListToPrint) {
            System.out.println(task.toString());
        }
        OperationMessages.printHorizontalLine();
    }

    private void printHelp() {
        OperationMessages.printHelp();
    }

    private void addToDo(String title) {
        taskList.addTask(new ToDo(title));
        OperationMessages.printAddedToDo(title);
    }

    private void addEvent(String title, String eventTime) {
        taskList.addTask(new Event(title, eventTime));
        OperationMessages.printAddedEvent(title);
    }

    private void addDeadline(String title, String dueDate) {
        taskList.addTask(new Deadline(title, dueDate));
        OperationMessages.printAddedDeadline(title);
    }

    private void markAsDone(int indexToMark) throws NumberFormatException, IndexOutOfBoundsException, TaskIndexOutOfBoundsException {
        taskList.markTaskDone(indexToMark);
        OperationMessages.printMarkedDone(taskList.getTask(indexToMark).getTitle());
    }

    private void deleteTask(int indexToDelete) throws TaskIndexOutOfBoundsException {
        String deletedTitle = taskList.getTask(indexToDelete).toString();
        taskList.deleteTask(indexToDelete);
        OperationMessages.printDeleted(deletedTitle);
    }

    public void executeCommand(String command) throws DukeException {
        String lowerCaseCleanInput = command.toLowerCase().strip();
        if (lowerCaseCleanInput.equals(Commands.EXIT_COMMAND)) {
            OperationMessages.printGoodBye();
        } else if (lowerCaseCleanInput.equals(Commands.LIST_COMMAND)) {
            printTaskList();
        } else if (lowerCaseCleanInput.startsWith(Commands.DONE_COMMAND)) {
            int indexToMark = InputParser.getIndexToMark(command);
            markAsDone(indexToMark);
        } else if (lowerCaseCleanInput.startsWith(Commands.DELETE_COMMAND)) {
            int indexToDelete = InputParser.getIndexToDelete(command);
            deleteTask(indexToDelete);
        } else if (lowerCaseCleanInput.startsWith(Commands.ADD_TODO_COMMAND)) {
            addToDo(InputParser.getTodoTitle(command));
        } else if (lowerCaseCleanInput.startsWith(Commands.ADD_DEADLINE_COMMAND)) {
            String title = InputParser.getDeadlineTitle(command);
            String dueDate = InputParser.getDeadlineDueDate(command);
            if (dueDate.equals("")) {
                throw new BlankDeadlineDateException();
            }
            addDeadline(title, dueDate);
        } else if (lowerCaseCleanInput.startsWith(Commands.ADD_EVENT_COMMAND)) {
            String title = InputParser.getEventTitle(command);
            String eventTime = InputParser.getEventTime(command);
            if (eventTime.equals("")) {
                throw new BlankEventTimeException();
            }
            addEvent(title, eventTime);
        } else if (lowerCaseCleanInput.startsWith(Commands.BEFORE_COMMAND)) {
            LocalDate dateInput = InputParser.getDateFromInput(command, Commands.BEFORE_COMMAND);
            ArrayList<Task> tasksBeforeDateList = taskList.getAllTasksBeforeList(dateInput);
            printTaskList(tasksBeforeDateList);
        } else if (lowerCaseCleanInput.startsWith(Commands.AT_COMMAND)) {
            LocalDate dateInput = InputParser.getDateFromInput(command, Commands.AT_COMMAND);
            ArrayList<Task> tasksBeforeDateList = taskList.getAllTasksOnList(dateInput);
            printTaskList(tasksBeforeDateList);
        } else if (lowerCaseCleanInput.startsWith(Commands.FIND_COMMAND)) {
            String searchKey = InputParser.getSearchKey(command);
            ArrayList<Task> searchResults = taskList.searchTasksResults(searchKey);
            printTaskList(searchResults);
        } else if (lowerCaseCleanInput.equals(Commands.HELP_COMMAND)) {
            printHelp();
        } else {
            throw new UnknownCommandException();
        }
    }

    public void startUI() {
        OperationMessages.printHello();
    }
}
