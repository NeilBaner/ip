package com.neilbaner.duke.exceptions;

import com.neilbaner.duke.messages.ErrorMessages;

public class IncorrectFormattingException extends DukeException {
    public IncorrectFormattingException() {
        super();
    }

    @Override
    public void printErrorMessage(String command) {
        ErrorMessages.printFormattingError();
    }
}
