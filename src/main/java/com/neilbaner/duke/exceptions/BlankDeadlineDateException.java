package com.neilbaner.duke.exceptions;

import com.neilbaner.duke.messages.ErrorMessages;

/**
 * This exception is thrown when the user doesn't enter a date after <code>/by</code> in the <code>deadline</code>
 * command.
 */
public class BlankDeadlineDateException extends DukeException {
    public BlankDeadlineDateException() {
        super();
    }

    @Override
    public void printErrorMessage(String command) {
        ErrorMessages.printBlankDeadlineDate();
    }
}
