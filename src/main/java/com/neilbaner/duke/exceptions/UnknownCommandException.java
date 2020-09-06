package com.neilbaner.duke.exceptions;

import com.neilbaner.duke.messages.Messages;

public class UnknownCommandException extends Exception {
    public UnknownCommandException(String command) {
        super();
        Messages.printUnknownCommand(command);
    }
}
