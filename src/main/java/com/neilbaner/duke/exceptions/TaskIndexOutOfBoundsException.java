package com.neilbaner.duke.exceptions;

import com.neilbaner.duke.messages.ErrorMessages;

/**
 * This exception is thrown when the user attempts to delete, or mark done, a task index that does not exist (eg. a
 * negative number or greater than the length of the task list).
 */
public class TaskIndexOutOfBoundsException extends DukeException {
    public TaskIndexOutOfBoundsException() {
        super();
    }

    @Override
    public void printErrorMessage(String command) {
        ErrorMessages.printTaskIndexOutOfBounds();
    }
}
