package com.neilbaner.duke.exceptions;

import com.neilbaner.duke.messages.ErrorMessages;

public class FileSavingException extends DukeException {
    public FileSavingException() {
        super();
    }
    @Override
    public void printErrorMessage(String command) {
        ErrorMessages.printSaveError();
    }
}
