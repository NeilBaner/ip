package com.neilbaner.duke.exceptions;

import com.neilbaner.duke.messages.Messages;

public class BlankDeadlineDateException extends DukeException {
    public BlankDeadlineDateException() {
        super();
    }

    @Override
    public void printErrorMessage(String command) {
        Messages.printBlankDeadlineDate();
    }
}
