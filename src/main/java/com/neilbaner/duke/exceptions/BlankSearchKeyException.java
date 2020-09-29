package com.neilbaner.duke.exceptions;

import com.neilbaner.duke.messages.ErrorMessages;

public class BlankSearchKeyException extends DukeException{
    public BlankSearchKeyException() {
        super();
    }
    @Override
    public void printErrorMessage(String command) {
        ErrorMessages.printBlankSearchKey();
    }
}
