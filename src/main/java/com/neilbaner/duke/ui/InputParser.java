package com.neilbaner.duke.ui;

import com.neilbaner.duke.exceptions.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 * @author Neil Banerjee
 * @version 1.0
 * A collection of methods to parse the input from the user and get the relevant information from the entered commands.
 */

public class InputParser {
    /**
     * Gets the title of a ToDo to be added, from the entered command.
     * @param input the command that has been input to add a new todo, directly from the user. Precondition: must be
     *              a todo command.
     * @return the title of the ToDo to be added
     * @throws BlankTaskTitleException if the title is blank/has not been entered.
     */
    public static String getTodoTitle(String input) throws BlankTaskTitleException {
        try {
            int commandLength = Commands.ADD_TODO_COMMAND.length();
            String todoTitle = input.substring(commandLength + 1);
            if (todoTitle.equals("")) {
                throw new BlankTaskTitleException();
            }
            return todoTitle;
        } catch (IndexOutOfBoundsException e) {
            throw new BlankTaskTitleException();
        }
    }

    /**
     * Gets the title of an Event to be added, from the entered command.
     * @param input the command that has been input to add a new event, directly from the user. Precondition: must be
     *             an event command
     * @return the title of the Event to be added
     * @throws BlankTaskTitleException if the title is blank/has not been entered
     */
    public static String getEventTitle(String input) throws BlankTaskTitleException {
        try {
            int commandLength = Commands.ADD_EVENT_COMMAND.length();
            int delimiterIndex = input.indexOf(Commands.EVENT_AT_DELIMITER);
            String eventTitle = input.substring(commandLength + 1, delimiterIndex).strip();
            if (eventTitle.equals("")) {
                throw new BlankTaskTitleException();
            }
            return eventTitle;
        } catch (IndexOutOfBoundsException e) {
            throw new BlankTaskTitleException();
        }
    }

    /**
     * Gets the title of a Deadline to be added, from the entered command.
     * @param input the command that has been input to add a new Deadline, stripped user input. Precondition: must be
     *             a deadline command
     * @return the title of the Deadline to be added
     * @throws BlankTaskTitleException if the title is blank/has not been entered
     */
    public static String getDeadlineTitle(String input) throws BlankTaskTitleException {
        try {
            int commandLength = Commands.ADD_DEADLINE_COMMAND.length();
            int delimiterIndex = input.indexOf(Commands.DEADLINE_BY_DELIMITER);
            String deadlineTitle = input.substring(commandLength, delimiterIndex).strip();
            if (deadlineTitle.equals("")) {
                throw new BlankTaskTitleException();
            }
            return deadlineTitle;
        } catch (IndexOutOfBoundsException e) {
            throw new BlankTaskTitleException();
        }
    }

    /**
     * Gets the date of an Event to be added, from the entered command.
     * @param input the command that has been input to add a new Event, stripped user input. Precondition: must be an
     *             event command.
     * @return the part of the command that corresponds to the event time as a String
     * @throws BlankEventTimeException if the event at is blank.
     */
    public static String getEventTime(String input) throws BlankEventTimeException {
        try {
            int delimiterLength = Commands.EVENT_AT_DELIMITER.length();
            int delimiterIndex = input.indexOf(Commands.EVENT_AT_DELIMITER);
            if(delimiterIndex == -1) {
                throw new BlankEventTimeException();
            }
            String eventTimeString = input.substring(delimiterIndex + delimiterLength).strip();
            if (eventTimeString.equals("")) {
                throw new BlankEventTimeException();
            }
            return eventTimeString;
        } catch (IndexOutOfBoundsException e) {
            throw new BlankEventTimeException();
        }
    }

    /**
     * Gets the date of an Deadline to be added, from the entered command.
     * @param input the command that has been input to add a new Deadline, stripped user input. Precondition: must be
     *             a deadline command.
     * @return the part of the command that corresponds to the deadline time as a String
     * @throws BlankEventTimeException if the deadline by is blank.
     */
    public static String getDeadlineDueDate(String input) throws BlankDeadlineDateException {
        try {
            int delimiterLength = Commands.DEADLINE_BY_DELIMITER.length();
            int delimiterIndex = input.indexOf(Commands.DEADLINE_BY_DELIMITER);
            if(delimiterIndex == -1) {
                throw new BlankDeadlineDateException();
            }
            String dueDateString = input.substring(delimiterIndex + delimiterLength + 1).strip();
            if (dueDateString.equals("")) {
                throw new BlankDeadlineDateException();
            }
            return dueDateString;
        } catch (IndexOutOfBoundsException e) {
            throw new BlankDeadlineDateException();
        }
    }

    /**
     * Gets the index of the task to be marked as Done.
     * @param input the command that has been entered by the user, stripped. Precondition: must be a done command.
     * @return the index of the task to be marked as done
     * @throws IncorrectFormattingException if the index is not a number, or some other error.
     * @throws BlankIndexToMarkException if the index is not specified
     */
    public static int getIndexToMark(String input) throws IncorrectFormattingException, BlankIndexToMarkException {
        try {
            int commandLength = Commands.DONE_COMMAND.length();
            String indexAsString = input.substring(commandLength + 1);
            if (indexAsString.equals("")) {
                throw new BlankIndexToMarkException();
            }
            return Integer.parseInt(indexAsString) - 1;
        } catch (NumberFormatException e) {
            throw new IncorrectFormattingException();
        } catch (IndexOutOfBoundsException e) {
            throw new BlankIndexToMarkException();
        }
    }

    /**
     * Gets the index of the task to be deleted.
     * @param input the command that has been entered by the user, stripped. Precondition: must be a delete command.
     * @return the index of the task to be deleted
     * @throws IncorrectFormattingException if the index is not a number, or some other error.
     * @throws BlankIndexToDeleteException if the index is not specified
     */
    public static int getIndexToDelete(String input) throws IncorrectFormattingException, BlankIndexToDeleteException {
        try {
            int commandLength = Commands.DELETE_COMMAND.length();
            String indexAsString = input.substring(commandLength + 1);
            if (indexAsString.equals("")) {
                throw new BlankIndexToDeleteException();
            }
            return Integer.parseInt(indexAsString) - 1;
        } catch (NumberFormatException e) {
            throw new IncorrectFormattingException();
        } catch (IndexOutOfBoundsException e) {
            throw new BlankIndexToDeleteException();
        }
    }

    /**
     * Gets the search key to search for
     * @param input the command that has been entered by the user, stripped. Precondition: must be a find command.
     * @return the key to search for
     * @throws BlankSearchKeyException if the user has not entered a search key.
     */
    public static String getSearchKey(String input) throws BlankSearchKeyException {
        try {
            int beginIndex = Commands.FIND_COMMAND.length() + 1;
            String key = input.substring(beginIndex);
            if (key.equals("")) {
                throw new BlankSearchKeyException();
            }
            return key;
        } catch (IndexOutOfBoundsException e) {
            throw new BlankSearchKeyException();
        }
    }

    /**
     * Gets the date to search for
     * @param input the command that has been entered by the user, stripped.
     * @param command the type of command (before or at) that has been entered.
     * @return the date that has been input
     * @throws IncorrectFormattingException if the command is incorrectly formatted
     * @throws BlankBeforeAtDateException if the date is blank
     * @throws BadDateFormatException if the
     */
    public static LocalDate getDateFromInput(String input, String command) throws IncorrectFormattingException, BlankBeforeAtDateException, BadDateFormatException {
        try {
            String dateString = input.substring(command.length() + 1);
            if (dateString.strip().equals("")) {
                throw new BlankBeforeAtDateException();
            }
            return LocalDate.parse(dateString);
        } catch (IndexOutOfBoundsException e) {
            throw new IncorrectFormattingException();
        } catch (DateTimeParseException e) {
            throw new BadDateFormatException();
        }
    }
}
