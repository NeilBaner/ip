package com.neilbaner.duke;

import com.neilbaner.duke.exceptions.*;
import com.neilbaner.duke.messages.Messages;
import com.neilbaner.duke.task.*;

import java.util.Scanner;

public class Duke {
    public static TaskList list = new TaskList();

    public static void printTaskList() {
        Messages.printHorizontalLine();
        if (list.getSize() == 0) {
            System.out.println("No tasks added yet");
        }
        for (Task task : list.getAllTasksList()) {
            System.out.println(task.toString());
        }
        Messages.printHorizontalLine();
    }

    public static void addToDo(String title) {
        list.addTask(new ToDo(title));
        Messages.printAddedToDo(title);
    }

    public static void addEvent(String title, String eventTime) {
        list.addTask(new Event(title, eventTime));
        Messages.printAddedEvent(title);
    }

    public static void addDeadline(String title, String dueDate) {
        list.addTask(new Deadline(title, dueDate));
        Messages.printAddedDeadline(title);
    }

    public static void markAsDone(int indexToMark) throws NumberFormatException, IndexOutOfBoundsException {
        list.markTaskDone(indexToMark);
        Messages.printMarkedDone(list.getTask(indexToMark).getTitle());
    }

    private static String getEventTime(String input) {
        return input.substring(input.indexOf("/at") + 4).strip();
    }

    private static String getEventTitle(String input) {
        return input.substring(6, input.indexOf("/at")).strip();
    }

    private static String getDeadlineDueDate(String input) {
        return input.substring(input.indexOf("/by") + 4).strip();
    }

    private static int getIndexToMark(String input) {
        return Integer.parseInt(input.substring(5)) - 1;
    }

    private static String getDeadlineTitle(String input) {
        return input.substring(9, input.indexOf("/by")).strip();
    }

    private static boolean parseInput(String input) throws DukeException {
        String lowerCaseInput = input.toLowerCase();
        if (lowerCaseInput.equals("bye")) {
            Messages.printGoodBye();
            return false;
        } else if (lowerCaseInput.equals("list")) {
            printTaskList();
        } else if (lowerCaseInput.startsWith("done")) {
            try {
                int indexToMark = getIndexToMark(input);
                markAsDone(indexToMark);
            } catch (NumberFormatException e) {
                Messages.printFormattingError();
            } catch (IndexOutOfBoundsException e) {
                throw new TaskIndexOutOfBoundsException();
            }
        } else if (lowerCaseInput.startsWith("todo")) {
            addToDo(input.substring(5));
        } else if (lowerCaseInput.startsWith("deadline")) {
            try {
                String title = getDeadlineTitle(input);
                String dueDate = getDeadlineDueDate(input);
                if (dueDate == "") {
                    throw new BlankDeadlineDateException();
                }
                addDeadline(title, dueDate);
            } catch (IndexOutOfBoundsException e) {
                Messages.printFormattingError();
            }
        } else if (input.startsWith("event")) {
            try {
                String title = getEventTitle(input);
                String eventTime = getEventTime(input);
                if (eventTime == "") {
                    throw new BlankEventTimeException();
                }
                addEvent(title, eventTime);
            } catch (IndexOutOfBoundsException e) {
                Messages.printFormattingError();
            }
        } else {
            throw new UnknownCommandException();
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner k = new Scanner(System.in);
        String input;
        boolean toContinue = true;
        Messages.printHello();
        while (toContinue) {
            input = k.nextLine();
            try {
                toContinue = parseInput(input);
            } catch (DukeException e) {
                e.printErrorMessage(input);
            }
        }
    }
}
