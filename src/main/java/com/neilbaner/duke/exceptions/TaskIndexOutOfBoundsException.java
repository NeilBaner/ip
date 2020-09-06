package com.neilbaner.duke.exceptions;

import com.neilbaner.duke.messages.Messages;

public class TaskIndexOutOfBoundsException extends DukeException{
    public TaskIndexOutOfBoundsException() {
        super();
    }

    @Override
    public void printErrorMessage(String command) {
        Messages.printTaskIndexOutOfBounds();
    }
}
