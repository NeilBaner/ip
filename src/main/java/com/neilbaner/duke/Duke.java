package com.neilbaner.duke;

import com.neilbaner.duke.exceptions.DukeException;
import com.neilbaner.duke.files.Storage;
import com.neilbaner.duke.task.TaskList;
import com.neilbaner.duke.ui.UserInterface;

import java.util.Scanner;

import static com.neilbaner.duke.ui.Commands.EXIT_COMMAND;

class Duke {
    private static final String SAVE_FILE_PATH = "dukesave.txt";
    private static final TaskList list = new TaskList();

    public static void main(String[] args) {
        String input = "";
        Storage storage = new Storage(SAVE_FILE_PATH);
        UserInterface ui = new UserInterface(list);
        Scanner k = new Scanner(System.in);
        try {
            storage.loadState(list);
        } catch (DukeException e) {
            e.printErrorMessage("");
        }
        ui.startUI();
        while (!input.equals(EXIT_COMMAND)) {
            input = k.nextLine();
            try {
                ui.executeCommand(input);
            } catch (DukeException e) {
                e.printErrorMessage(input);
            }
        }
        try {
            storage.saveState(list);
        } catch (DukeException e) {
            e.printErrorMessage("");
        }
    }
}

