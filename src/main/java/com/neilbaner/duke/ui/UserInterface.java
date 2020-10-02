package com.neilbaner.duke.ui;

import com.neilbaner.duke.exceptions.*;
import com.neilbaner.duke.messages.OperationMessages;
import com.neilbaner.duke.task.*;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @author Neil Banerjee
 * @version 1.0
 * Class for the user interface of Duke.
 */
public class UserInterface {
    // The task list we are working with
    private final TaskList taskList;

    /**
     * Constructor
     * @param taskList the TaskList object with the tasks from the current instance.
     */
    public UserInterface(TaskList taskList) {
        this.taskList = taskList;
    }

    /**
     * Prints all the tasks in the current working TaskList
     */
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

    /**
     * Prints an ArrayList of tasks, to be used when printing the results of a search/before/at command
     * @param taskListToPrint the ArrayList of Tasks to be printed
     */
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

    /**
     * Prints the help for Duke.
     */
    private void printHelp() {
        OperationMessages.printHelp();
    }

    /**
     * Add a new todo task to the TaskList with a given title
     * @param title the title of the task to be added.
     */
    private void addToDo(String title) {
        taskList.addTask(new ToDo(title));
        OperationMessages.printAddedToDo(title);
    }

    /**
     * Add a new event task to the TaskList with a given title and event at time.
     * @param title the title of the event to be added
     * @param eventTime the time of the event to be added
     */
    private void addEvent(String title, String eventTime) {
        taskList.addTask(new Event(title, eventTime));
        OperationMessages.printAddedEvent(title);
    }

    /**
     * Add a new Deadline task to the TaskList with a given title and a deadline by date.
     * @param title the title of the Deadline to be added
     * @param dueDate the due date of the Deadline to be added
     */
    private void addDeadline(String title, String dueDate) {
        taskList.addTask(new Deadline(title, dueDate));
        OperationMessages.printAddedDeadline(title);
    }

    /**
     * Marks a task in the TaskList as Done.
     * @param indexToMark the index to be marked as done.
     * @throws TaskIndexOutOfBoundsException if the index to be marked as done doesn't exist in the TaskList ArrayList.
     */
    private void markAsDone(int indexToMark) throws  TaskIndexOutOfBoundsException {
        taskList.markTaskDone(indexToMark);
        OperationMessages.printMarkedDone(taskList.getTask(indexToMark).getTitle());
    }

    /**
     * Deletes a task in the TaskList.
     * @param indexToDelete the index of the task to be deleted.
     * @throws TaskIndexOutOfBoundsException if the index to be deleted doesn't exist in the TaskList ArrayList.
     */
    private void deleteTask(int indexToDelete) throws TaskIndexOutOfBoundsException {
        String deletedTitle = taskList.getTask(indexToDelete).toString();
        taskList.deleteTask(indexToDelete);
        OperationMessages.printDeleted(deletedTitle);
    }

    /**
     * Executes a command entered by a user
     * @param command the input directly from the user, unprocessed.
     * @throws DukeException if there is some error executing the command.
     */
    public void executeCommand(String command) throws DukeException {
        // removes leading and trailing spaces
        String cleanInput = command.strip();
        // accounts for different cases
        String lowerCaseCleanInput = cleanInput.toLowerCase();
        // for each command:
        if (lowerCaseCleanInput.equals(Commands.EXIT_COMMAND)) { // to exit
            OperationMessages.printGoodBye();
        } else if (lowerCaseCleanInput.equals(Commands.LIST_COMMAND)) { // to list all Tasks
            printTaskList();
        } else if (lowerCaseCleanInput.startsWith(Commands.DONE_COMMAND)) { // to mark a task as done
            int indexToMark = InputParser.getIndexToMark(cleanInput);
            markAsDone(indexToMark);
        } else if (lowerCaseCleanInput.startsWith(Commands.DELETE_COMMAND)) { // to delete a task
            int indexToDelete = InputParser.getIndexToDelete(cleanInput);
            deleteTask(indexToDelete);
        } else if (lowerCaseCleanInput.startsWith(Commands.ADD_TODO_COMMAND)) { // to add a new todo
            addToDo(InputParser.getTodoTitle(cleanInput));
        } else if (lowerCaseCleanInput.startsWith(Commands.ADD_DEADLINE_COMMAND)) { // to add a new deadline
            String title = InputParser.getDeadlineTitle(cleanInput);
            String dueDate = InputParser.getDeadlineDueDate(cleanInput);
            if (dueDate.equals("")) {
                throw new BlankDeadlineDateException();
            }
            addDeadline(title, dueDate);
        } else if (lowerCaseCleanInput.startsWith(Commands.ADD_EVENT_COMMAND)) { // to add a new event
            String title = InputParser.getEventTitle(cleanInput);
            String eventTime = InputParser.getEventTime(cleanInput);
            if (eventTime.equals("")) {
                throw new BlankEventTimeException();
            }
            addEvent(title, eventTime);
        } else if (lowerCaseCleanInput.startsWith(Commands.BEFORE_COMMAND)) { // to get all tasks before a date
            LocalDate dateInput = InputParser.getDateFromInput(cleanInput, Commands.BEFORE_COMMAND);
            ArrayList<Task> tasksBeforeDateList = taskList.getAllTasksBeforeList(dateInput);
            printTaskList(tasksBeforeDateList);
        } else if (lowerCaseCleanInput.startsWith(Commands.AT_COMMAND)) { // to get all tasks at a date
            LocalDate dateInput = InputParser.getDateFromInput(cleanInput, Commands.AT_COMMAND);
            ArrayList<Task> tasksBeforeDateList = taskList.getAllTasksOnList(dateInput);
            printTaskList(tasksBeforeDateList);
        } else if (lowerCaseCleanInput.startsWith(Commands.FIND_COMMAND)) { // to search for tasks with a key
            String searchKey = InputParser.getSearchKey(cleanInput);
            ArrayList<Task> searchResults = taskList.searchTasksResults(searchKey);
            printTaskList(searchResults);
        } else if (lowerCaseCleanInput.equals(Commands.HELP_COMMAND)) { // to print the help command
            printHelp();
        } else { // if the command is not one of the known ones
            throw new UnknownCommandException();
        }
    }

    public void startUI() {
        OperationMessages.printHello();
    }
}
