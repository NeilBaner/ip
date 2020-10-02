package com.neilbaner.duke.messages;

/**
 * @author Neil Banerjee
 * @version 1.0
 * 
 */
public class ErrorMessages extends Messages {

    public static void printBadDateFormat() {
        System.err.println("The date must be formatted as ISO8601, that is, as YYYY-MM-DD. ");
        printHorizontalLine();
    }

    public static void printBlankDeadlineDate() {
        System.err.println("Every deadline needs to have a due date. The syntax for adding a deadline is as follows: ");
        printDeadlineSyntax();
        printHorizontalLine();
    }

    public static void printBlankEventTime() {
        System.err.println("Every event needs to have a time. The syntax for adding an event is as follows: ");
        printEventSyntax();
        printHorizontalLine();
    }

    public static void printBlankIndexToDelete() {
        System.err.println("You need to include the index number of the task to delete. ");
        printDeleteSyntax();
        printHorizontalLine();
    }

    public static void printBlankIndexToMark() {
        System.err.println("You need to include the index number of the task to mark as done. ");
        printDoneSyntax();
        printHorizontalLine();
    }

    public static void printBlankSearchKey() {
        System.err.println("You need to include something to search for. ");
        printFindSyntax();
        printHorizontalLine();
    }

    public static void printBlankBeforeAt() {
        System.err.println("You need to include a date to search. ");
        printBeforeSyntax();
        printAtSyntax();
        printHorizontalLine();
    }

    public static void printBlankTaskTitle() {
        System.err.println("Sorry, you need to add a title for the task. ");
        printHorizontalLine();
    }

    public static void printFormattingError() {
        System.err.println("Incorrectly formatted input");
        printHorizontalLine();
    }

    public static void printNonExistError() {
        System.err.println("Task does not exist in list");
        printHorizontalLine();
    }

    public static void printUnknownCommand(String command) {
        System.err.println("I'm sorry, I'm not sure what " + command + " means. ");
        printHelp();
        printHorizontalLine();
    }

    public static void printTaskIndexOutOfBounds() {
        System.err.println("Please make sure that the task number you enter to mark as done is on the list. ");
        System.out.println("For reference, here's how to mark a task as done: ");
        printDoneSyntax();
        printHorizontalLine();
    }

    public static void printDeserializerError() {
        System.err.println("Some error reading the save file. ");
        System.err.println("Continuing without loading a save file. ");
        printHorizontalLine();
    }

    public static void printSaveError() {
        System.err.println("Some error saving the file. ");
        System.err.println("The content that would be saved to the file is above. ");
        System.err.println("You may copy it and paste it elsewhere as a backup. ");
        printHorizontalLine();
    }

    public static void printReadError() {
        System.err.println("The save file could not be found, continuing without loading. ");
        System.err.println("A new one will be created when you quit. ");
        printHorizontalLine();
    }
}
