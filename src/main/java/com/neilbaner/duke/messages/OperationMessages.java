package com.neilbaner.duke.messages;

public class OperationMessages extends Messages {


    public static void printGoodBye() {
        printHorizontalLine();
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("Shutting down...");
        printHorizontalLine();
    }

    public static void printAddedToDo(String title) {
        String confirmation = MessageGenerator.generateConfirmationMessage();
        printHorizontalLine();
        System.out.print(confirmation);
        System.out.println("I've added the following to-do to your list: " + title);
        printHorizontalLine();
    }

    public static void printAddedEvent(String title) {
        String confirmation = MessageGenerator.generateConfirmationMessage();
        printHorizontalLine();
        System.out.print(confirmation);
        System.out.println("I've added this event to your list: " + title);
        printHorizontalLine();
    }

    public static void printAddedDeadline(String title) {
        String confirmation = MessageGenerator.generateConfirmationMessage();
        printHorizontalLine();
        System.out.print(confirmation);
        System.out.println("Added a new deadline to your list, titled : " + title);
        printHorizontalLine();
    }

    public static void printMarkedDone(String title) {
        String confirmation = MessageGenerator.generateConfirmationMessage();
        printHorizontalLine();
        System.out.print(confirmation);
        System.out.println(title + " marked as done.");
        printHorizontalLine();
    }

    public static void printDeleted(String title) {
        String confirmation = MessageGenerator.generateConfirmationMessage();
        printHorizontalLine();
        System.out.print(confirmation);
        System.out.println(title + " deleted. ");
        printHorizontalLine();
    }


    public static void printHello() {
        printHorizontalLine();
        System.out.println("Hello! I'm Duke. ");
        System.out.println("What can I do for you?");
        printHorizontalLine();
    }
}
