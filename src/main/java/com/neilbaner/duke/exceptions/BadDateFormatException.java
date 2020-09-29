package com.neilbaner.duke.exceptions;

import com.neilbaner.duke.messages.ErrorMessages;

public class BadDateFormatException extends DukeException {
    public BadDateFormatException() {
        super();
    }
    @Override
    public void printErrorMessage(String command) {
        ErrorMessages.printBadDateFormat();
    }
}
