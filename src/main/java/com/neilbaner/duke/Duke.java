package com.neilbaner.duke;

import com.neilbaner.duke.exceptions.*;
import com.neilbaner.duke.files.Storage;
import com.neilbaner.duke.messages.Messages;
import com.neilbaner.duke.task.*;
import com.neilbaner.duke.ui.Commands;
import com.neilbaner.duke.ui.InputParser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static TaskList list = new TaskList();

    public static final String SAVE_FILE_PATH = "dukesave.txt";

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

    public static void deleteTask(int indexToDelete) {
        String deletedTitle = list.getTask(indexToDelete).toString();
        list.deleteTask(indexToDelete);
        Messages.printDeleted(deletedTitle);
    }

    public static void main(String[] args) {
        try {
            Storage storage = new Storage(SAVE_FILE_PATH);
            storage.loadState(list);
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
            storage.saveState(list);
        } catch (DukeException e) {
            e.printErrorMessage("");
        }
    }
}
