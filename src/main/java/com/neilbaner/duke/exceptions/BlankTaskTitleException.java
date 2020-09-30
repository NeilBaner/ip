package com.neilbaner.duke.exceptions;

import com.neilbaner.duke.messages.ErrorMessages;

/**
 * This exception is thrown when the user does not enter a title for their task.
 */
public class BlankTaskTitleException extends DukeException {
    public BlankTaskTitleException() {
        super();
    }

    @Override
    public void printErrorMessage(String command) {
        ErrorMessages.printBlankTaskTitle();
    }
}
