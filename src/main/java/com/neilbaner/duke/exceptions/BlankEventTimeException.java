package com.neilbaner.duke.exceptions;

import com.neilbaner.duke.messages.Messages;

public class BlankEventTimeException extends DukeException{
    public BlankEventTimeException() {
        super();
    }

    @Override
    public void printErrorMessage(String command) {
        Messages.printBlankEventTime();
    }
}
