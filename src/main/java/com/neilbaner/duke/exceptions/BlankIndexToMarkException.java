package com.neilbaner.duke.exceptions;

import com.neilbaner.duke.messages.ErrorMessages;

/**
 * @author Neil Banerjee
 * @version 1.0
 * This exception is thrown when the user does not enter an index to delete after the <code>done</code> command.
 */
public class BlankIndexToMarkException extends DukeException {
    public BlankIndexToMarkException() {
        super();
    }

    @Override
    public void printErrorMessage(String command) {
        ErrorMessages.printBlankIndexToMark();
    }
}
