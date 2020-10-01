package com.neilbaner.duke.exceptions;

import com.neilbaner.duke.messages.ErrorMessages;

/**
 * This exception is thrown when Duke is unable to find a save file to load. The program should recover from this
 * error and continue without loading the tasks.
 */
public class NoSaveFileException extends DukeException {
    public NoSaveFileException() {
        super();
    }

    @Override
    public void printErrorMessage(String command) {
        ErrorMessages.printReadError();
    }
}
