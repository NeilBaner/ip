package com.neilbaner.duke.exceptions;

import com.neilbaner.duke.messages.ErrorMessages;

/**
 * @author Neil Banerjee
 * @version 1.0
 * This exception is thrown when the user does not specify an index to delete after the <code>delete</code> command.
 */
public class BlankIndexToDeleteException extends DukeException {
    public BlankIndexToDeleteException() {
        super();
    }

    @Override
    public void printErrorMessage(String command) {
        ErrorMessages.printBlankIndexToDelete();
    }
}
