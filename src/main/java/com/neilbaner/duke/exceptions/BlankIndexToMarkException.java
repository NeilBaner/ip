package com.neilbaner.duke.exceptions;

import com.neilbaner.duke.messages.ErrorMessages;

public class BlankIndexToMarkException extends DukeException {
    public BlankIndexToMarkException() {
        super();
    }
    @Override
    public void printErrorMessage(String command) {
        ErrorMessages.printBlankIndexToMark();
    }
}
