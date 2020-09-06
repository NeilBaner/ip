package com.neilbaner.duke.exceptions;

import com.neilbaner.duke.messages.Messages;

public class UnknownCommandException extends DukeException {
    public UnknownCommandException() {
        super();
    }

    @Override
    public void printErrorMessage(String command) {
        Messages.printUnknownCommand(command);
    }
}
