package com.neilbaner.duke.ui;

public class InputParser {
    public static String getEventTime(String input) {
        return input.substring(input.indexOf(Commands.EVENT_AT_DELIMITER) + 4).strip();
    }

    public static String getEventTitle(String input) {
        return input.substring(6, input.indexOf(Commands.EVENT_AT_DELIMITER)).strip();
    }

    public static String getDeadlineDueDate(String input) {
        int delimiterLength = Commands.DEADLINE_BY_DELIMITER.length() + 1;
        return input.substring(input.indexOf(Commands.DEADLINE_BY_DELIMITER) + delimiterLength).strip();
    }

    public static int getIndexToMark(String input) {
        int beginIndex = Commands.DONE_COMMAND.length() + 1;
        return Integer.parseInt(input.substring(beginIndex)) - 1;
    }

    public static int getIndexToDelete(String input) {
        return Integer.parseInt(input.substring(Commands.DELETE_COMMAND.length() + 1)) - 1;
    }

    public static String getDeadlineTitle(String input) {
        return input.substring(9, input.indexOf(Commands.DEADLINE_BY_DELIMITER)).strip();
    }

    public static String getSearchKey(String input) {
        int beginIndex = Commands.FIND_COMMAND.length() + 1;
        return input.substring(beginIndex);
    }
}