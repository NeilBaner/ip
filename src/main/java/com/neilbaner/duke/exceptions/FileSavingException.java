package com.neilbaner.duke.exceptions;

import com.neilbaner.duke.messages.ErrorMessages;

/**
 * This exception is thrown when there is an error saving the save file for Duke. It should not usually be thrown in
 * normal operation.
 */
public class FileSavingException extends DukeException {
    public FileSavingException() {
        super();
    }

    @Override
    public void printErrorMessage(String command) {
        ErrorMessages.printSaveError();
    }
}
