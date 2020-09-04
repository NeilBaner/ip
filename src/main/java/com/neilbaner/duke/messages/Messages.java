package com.neilbaner.duke;

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
        Messages.printHorizontalLine();
        System.out.println("Roger dodger chief. I've added this event to your list: " + title);
        Messages.printHorizontalLine();
    }

    public static void printAddedDeadline(String title) {
        Messages.printHorizontalLine();
        System.out.println("You got it. Added a new deadline to your list, titled : " + title);
        Messages.printHorizontalLine();
    }

    public static void printMarkedDone(String title) {
        Messages.printHorizontalLine();
        System.out.println(title + " marked as done.");
        Messages.printHorizontalLine();
    }

    public static void printFormattingError() {
        System.out.println("Incorrectly formatted input");
        Messages.printHorizontalLine();
    }

    public static void printNonExistError() {
        System.out.println("com.neilbaner.duke.task.Task does not exist in list");
        Messages.printHorizontalLine();
    }
}
