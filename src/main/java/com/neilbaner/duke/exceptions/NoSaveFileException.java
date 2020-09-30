package com.neilbaner.duke.exceptions;

import com.neilbaner.duke.messages.ErrorMessages;

public class NoSaveFileException extends DukeException {
    public NoSaveFileException() {
        super();
    }

    @Override
    public void printErrorMessage(String command) {
        ErrorMessages.printSaveError();
    }
}
