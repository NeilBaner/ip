package com.neilbaner.duke.exceptions;

import com.neilbaner.duke.messages.ErrorMessages;

public class DeserializerException extends DukeException {
    public DeserializerException() {
        super();
    }

    @Override
    public void printErrorMessage(String command) {
        ErrorMessages.printDeserializerError();
    }
}
