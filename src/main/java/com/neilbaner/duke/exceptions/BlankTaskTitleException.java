package com.neilbaner.duke.exceptions;

import com.neilbaner.duke.messages.ErrorMessages;

public class BlankTaskTitleException extends DukeException {
    public BlankTaskTitleException() {
        super();
    }

    @Override
    public void printErrorMessage(String command) {
        ErrorMessages.printBlankTaskTitle();
    }
}
