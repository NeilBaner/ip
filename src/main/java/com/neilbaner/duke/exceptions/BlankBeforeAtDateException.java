package com.neilbaner.duke.exceptions;

import com.neilbaner.duke.messages.ErrorMessages;


/**
 * This exception is thrown when the user doesn't enter a date after using the <code>before</code> or <code>at</code>
 * commands.
 */
public class BlankBeforeAtDateException extends DukeException {
    public BlankBeforeAtDateException() {
        super();
    }

    @Override
    public void printErrorMessage(String command) {
        ErrorMessages.printBlankBeforeAt();
    }
}
