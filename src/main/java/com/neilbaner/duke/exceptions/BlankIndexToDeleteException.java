package com.neilbaner.duke.exceptions;

import com.neilbaner.duke.messages.ErrorMessages;

public class BlankIndexToDeleteException extends DukeException {
    public BlankBeforeAtDateException() {
        super();
    }

    @Override
    public void printErrorMessage(String command) {
        ErrorMessages.printBlankIndexToDelete();
    }
}