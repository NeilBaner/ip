package com.neilbaner.duke.exceptions;

import com.neilbaner.duke.messages.ErrorMessages;

/**
 * @author Neil Banerjee
 * @version 1.0
 * This exception is thrown when the user enters a date that cannot be parsed by the LocalDate.parse() function.
 */
public class BadDateFormatException extends DukeException {
    public BadDateFormatException() {
        super();
    }

    @Override
    public void printErrorMessage(String command) {
        ErrorMessages.printBadDateFormat();
    }
}
