package com.neilbaner.duke.exceptions;

import com.neilbaner.duke.messages.ErrorMessages;

/**
 * This exception is thrown when the user does not enter a search key/term after using the <code>find</code> command.
 */
public class BlankSearchKeyException extends DukeException {
    public BlankSearchKeyException() {
        super();
    }

    @Override
    public void printErrorMessage(String command) {
        ErrorMessages.printBlankSearchKey();
    }
}
