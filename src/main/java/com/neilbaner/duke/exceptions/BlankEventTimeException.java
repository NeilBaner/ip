package com.neilbaner.duke.exceptions;

import com.neilbaner.duke.messages.ErrorMessages;

/**
 * @author Neil Banerjee
 * @version 1.0
 * This exception is thrown when the user doesn't enter a date after <code>/at</code> in the <code>event</code>
 * command.
 */
public class BlankEventTimeException extends DukeException {
    public BlankEventTimeException() {
        super();
    }

    @Override
    public void printErrorMessage(String command) {
        ErrorMessages.printBlankEventTime();
    }
}
