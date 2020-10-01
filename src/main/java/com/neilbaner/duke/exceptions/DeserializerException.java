package com.neilbaner.duke.exceptions;

import com.neilbaner.duke.messages.ErrorMessages;

/**
 * @author Neil Banerjee
 * @version 1.0
 * This exception is thrown when there is an error deserializing the save file. It should not ever occur unless the
 * save file has been corrupted or tampered with.
 */
public class DeserializerException extends DukeException {
    public DeserializerException() {
        super();
    }

    @Override
    public void printErrorMessage(String command) {
        ErrorMessages.printDeserializerError();
    }
}
