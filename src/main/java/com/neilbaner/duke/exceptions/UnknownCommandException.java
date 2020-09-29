package com.neilbaner.duke.exceptions;

import com.neilbaner.duke.messages.ErrorMessages;

public class UnknownCommandException extends DukeException {
    public UnknownCommandException() {
        super();
    }

    @Override
    public void printErrorMessage(String command) {
        ErrorMessages.printUnknownCommand(command);
    }
}
