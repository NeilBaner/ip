package com.neilbaner.duke.messages;

public class Messages {
    public static void printHorizontalLine() {
        System.out.println("____________________________________________________________");
    }

    public static void printHello() {
        printHorizontalLine();
        System.out.println("Hello! I'm Duke. ");
        System.out.println("What can I do for you?");
        printHorizontalLine();
    }

    public static void printHelp() {
        System.out.println("Here are all the commands I know. ");
        System.out.println("Adding a new to-do task: ");
        printTodoSyntax();
        System.out.println("Adding a new event: ");
        printEventSyntax();
        System.out.println("Adding a new deadline: ");
        printDeadlineSyntax();
        System.out.println("Marking a task as done: ");
        printDoneSyntax();
        System.out.println("Accessing help: ");
        printHelpSyntax();
    }

    public static void printTodoSyntax() {
        System.out.println("todo <todoname>");
    }

    public static void printEventSyntax() {
        System.out.println("event <eventname> /at <eventtime>");
    }

    public static void printDeadlineSyntax() {
        System.out.println("deadline <deadlinename> /by <deadlineduedate>");
    }

    public static void printDoneSyntax() {
        System.out.println("done <tasknumber>");
        System.out.println("<tasknumber> represents the number associated with the task, as seen on screen. ");
    }

    public static void printHelpSyntax() {
        System.out.println("help");
    }

    public static void printGoodBye() {
        printHorizontalLine();
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("Shutting down...");
        printHorizontalLine();
    }

    public static void printAddedToDo(String title) {
        printHorizontalLine();
        System.out.println("Done. I've added the following to-do to your list: " + title);
        printHorizontalLine();
    }

    public static void printAddedEvent(String title) {
        printHorizontalLine();
        System.out.println("Roger dodger chief. I've added this event to your list: " + title);
        printHorizontalLine();
    }

    public static void printAddedDeadline(String title) {
        printHorizontalLine();
        System.out.println("You got it. Added a new deadline to your list, titled : " + title);
        printHorizontalLine();
    }

    public static void printMarkedDone(String title) {
        printHorizontalLine();
        System.out.println(title + " marked as done.");
        printHorizontalLine();
    }

    public static void printFormattingError() {
        System.out.println("Incorrectly formatted input");
        printHorizontalLine();
    }

    public static void printNonExistError() {
        System.out.println("Task does not exist in list");
        printHorizontalLine();
    }

    public static void printUnknownCommand(String command) {
        System.out.println("I'm sorry, I'm not sure what " + command + " means. ");
        printHelp();
        printHorizontalLine();
    }

    public static void printBlankTaskTitle() {
        System.out.println("Sorry, you need to add a title for the task. ");
        printHorizontalLine();
    }

    public static void printBlankEventTime() {
        System.out.println("Every event needs to have a time. The syntax for adding an event is as follows: ");
        printEventSyntax();
        printHorizontalLine();
    }

    public static void printBlankDeadlineDate() {
        System.out.println("Every deadline needs to have a due date. The syntax for adding a deadline is as follows: ");
        printDeadlineSyntax();
        printHorizontalLine();
    }

    public static void printTaskIndexOutOfBounds() {
        System.out.println("Please make sure that the task number you enter to mark as done is on the list. ");
        System.out.println("For reference, here's how to mark a task as done: ");
        printDoneSyntax();
        printHorizontalLine();
    }
}
