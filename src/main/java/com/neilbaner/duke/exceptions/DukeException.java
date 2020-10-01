package com.neilbaner.duke.exceptions;

/**
 * @author Neil Banerjee
 * @version 1.0
 * Superclass for all the types of exceptions Duke can throw.
 */
public abstract class DukeException extends Exception {
    DukeException() {
        super();
    }

    /**
     * Prints the relevant error message for each exception.
     * @param command : the command that was entered by the user to cause the exception. May be used to provide
     *                feedback to the user about what went wrong.
     */
    public abstract void printErrorMessage(String command);
}
