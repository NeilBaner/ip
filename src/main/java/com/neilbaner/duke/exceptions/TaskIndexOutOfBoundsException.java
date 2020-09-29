package com.neilbaner.duke.exceptions;

import com.neilbaner.duke.messages.ErrorMessages;

public class TaskIndexOutOfBoundsException extends DukeException {
    public TaskIndexOutOfBoundsException() {
        super();
    }

    @Override
    public void printErrorMessage(String command) {
        ErrorMessages.printTaskIndexOutOfBounds();
    }
}
