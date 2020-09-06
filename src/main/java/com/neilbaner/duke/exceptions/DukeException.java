package com.neilbaner.duke.exceptions;

public abstract class DukeException {
    public DukeException() {
        super();
    }
    public abstract void printErrorMessage(String command);
}
