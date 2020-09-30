package com.neilbaner.duke.exceptions;

import com.neilbaner.duke.messages.ErrorMessages;

/**
 * This exception is thrown when the user enters a command that Duke doesn't know how to perform (yet!). 
 */
public class UnknownCommandException extends DukeException {
    public UnknownCommandException() {
        super();
    }

    @Override
    public void printErrorMessage(String command) {
        ErrorMessages.printUnknownCommand(command);
    }
}
