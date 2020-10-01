package com.neilbaner.duke.exceptions;

import com.neilbaner.duke.messages.ErrorMessages;

/**
 * @author Neil Banerjee
 * @version 1.0
 * This exception is thrown when the command entered by the user is not formatted correctly.
 */
public class IncorrectFormattingException extends DukeException {
    public IncorrectFormattingException() {
        super();
    }

    @Override
    public void printErrorMessage(String command) {
        ErrorMessages.printFormattingError();
    }
}
