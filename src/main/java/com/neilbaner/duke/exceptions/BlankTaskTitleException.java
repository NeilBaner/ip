package com.neilbaner.duke.exceptions;

import com.neilbaner.duke.messages.Messages;

public class BlankTaskTitleException extends DukeException{
    public BlankTaskTitleException() {
        super();
    }

    @Override
    public void printErrorMessage(String command) {
        Messages.printBlankTaskTitle();
    }
}
