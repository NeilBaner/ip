package com.neilbaner.duke.exceptions;

import com.neilbaner.duke.messages.ErrorMessages;

public class BlankBeforeAtDateException extends DukeException {
    public BlankBeforeAtDateException() {
        super();
    }

    @Override
    public void printErrorMessage(String command) {
        ErrorMessages.printBlankBeforeAt();
    }
}
