package com.neilbaner.duke.messages;

public class Messages {
    public static void printHorizontalLine() {
        System.out.println("____________________________________________________________");
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

    public static void printDeleteSyntax() {
        System.out.println("delete <tasknumber>");
        System.out.println("<tasknumber> represents the number associated with the task, as seen on screen. ");
    }

    public static void printFindSyntax() {
        System.out.println("find <key>");
        System.out.println("<key> represents whatever you want to search for. ");
    }

    public static void printBeforeSyntax() {
        System.out.println("before YYYY-MM-DD");
        System.out.println("YYYY-MM-DD is the date before which you want to find tasks.");
    }

    public static void printAtSyntax() {
        System.out.println("at YYYY-MM-DD");
        System.out.println("YYYY-MM-DD is the date at which you want to find tasks.");
    }

    public static void printHelpSyntax() {
        System.out.println("help");
    }
}
