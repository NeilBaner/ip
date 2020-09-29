package com.neilbaner.duke.ui;

import com.neilbaner.duke.exceptions.*;

import java.time.LocalDate;

public class InputParser {

    public static String getTodoTitle(String input) throws BlankTaskTitleException {
        try {
            int commandLength = Commands.ADD_TODO_COMMAND.length();
            String todoTitle = input.substring(commandLength + 1);
            if(todoTitle.equals("")){
                throw new BlankTaskTitleException();
            }
            return todoTitle;
        } catch (IndexOutOfBoundsException e){
            throw new BlankTaskTitleException();
        }
    }

    public static String getEventTitle(String input) throws BlankTaskTitleException{
        try {
            int commandLength = Commands.ADD_EVENT_COMMAND.length();
            int delimiterIndex = input.indexOf(Commands.EVENT_AT_DELIMITER);
            String eventTitle = input.substring(commandLength + 1, delimiterIndex).strip();
            if(eventTitle.equals("")) {
                throw new BlankTaskTitleException();
            }
            return eventTitle;
        } catch (IndexOutOfBoundsException e) {
            throw new BlankTaskTitleException();
        }
    }

    public static String getDeadlineTitle(String input) throws BlankTaskTitleException {
        try {
            int commandLength = Commands.ADD_DEADLINE_COMMAND.length();
            int delimiterIndex = input.indexOf(Commands.DEADLINE_BY_DELIMITER);
            String deadlineTitle = input.substring(commandLength, delimiterIndex).strip();
            if(deadlineTitle.equals("")) {
                throw new BlankTaskTitleException();
            }
            return deadlineTitle;
        } catch (IndexOutOfBoundsException e) {
            throw new BlankTaskTitleException();
        }
    }

    public static String getEventTime(String input) throws BlankEventTimeException {
        try {
            int delimiterLength = Commands.EVENT_AT_DELIMITER.length();
            int delimiterIndex = input.indexOf(Commands.EVENT_AT_DELIMITER);
            String eventTimeString = input.substring(delimiterIndex + delimiterLength).strip();
            if(eventTimeString.equals("")) {
                throw new BlankEventTimeException();
            }
            return eventTimeString;
        } catch (IndexOutOfBoundsException e) {
            throw new BlankEventTimeException();
        }
    }

    public static String getDeadlineDueDate(String input) throws BlankDeadlineDateException {
        try {
            int delimiterLength = Commands.DEADLINE_BY_DELIMITER.length();
            int delimiterIndex = input.indexOf(Commands.DEADLINE_BY_DELIMITER);
            String dueDateString = input.substring(delimiterIndex + delimiterLength + 1).strip();
            if(dueDateString.equals("")) {
                throw new BlankDeadlineDateException();
            }
            return dueDateString;
        }catch (IndexOutOfBoundsException e) {
            throw new BlankDeadlineDateException();
        }
    }

    public static int getIndexToMark(String input) throws IncorrectFormattingException, BlankIndexToMarkException {
        try{
            int commandLength = Commands.DONE_COMMAND.length();
            String indexAsString = input.substring(commandLength + 1);
            if(indexAsString.equals("")) {
                throw new BlankIndexToMarkException();
            }
            return Integer.parseInt(indexAsString) - 1;
        } catch (NumberFormatException e) {
            throw new IncorrectFormattingException();
        } catch (IndexOutOfBoundsException e) {
            throw new BlankIndexToMarkException();
        }
    }

    public static int getIndexToDelete(String input) throws IncorrectFormattingException, BlankIndexToDeleteException {
        try {
            int commandLength = Commands.DELETE_COMMAND.length();
            String indexAsString = input.substring(commandLength + 1);
            if(indexAsString.equals("")) {
                throw new BlankIndexToDeleteException();
            }
            return Integer.parseInt(indexAsString) - 1;
        } catch (NumberFormatException e) {
            throw new IncorrectFormattingException();
        } catch (IndexOutOfBoundsException e) {
            throw new BlankIndexToDeleteException();
        }
    }

    public static String getSearchKey(String input) throws BlankSearchKeyException {
        try {
            int beginIndex = Commands.FIND_COMMAND.length() + 1;
            String key = input.substring(beginIndex);
            if(key.equals("")){
                throw new BlankSearchKeyException();
            }
            return key;
        }catch (IndexOutOfBoundsException e) {
            throw new BlankSearchKeyException();
        }
    }

    public static LocalDate getDateFromInput(String input, String command) throws IncorrectFormattingException, BlankBeforeAtDateException {
        try {
            String dateString = input.substring(command.length() + 1);
            if(dateString.strip().equals("")) {
                throw new BlankBeforeAtDateException();
            }
            return LocalDate.parse(dateString);
        } catch (IndexOutOfBoundsException e) {
            throw new IncorrectFormattingException();
        }
    }
}
