package com.neilbaner.duke.exceptions;

public abstract class DukeException extends Exception {
    DukeException() {
        super();
    }

    public abstract void printErrorMessage(String command);
}
