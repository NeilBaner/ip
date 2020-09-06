package com.neilbaner.duke.exceptions;

import com.neilbaner.duke.messages.Messages;

public class TaskIndexOutOfBoundsException extends Exception{
    public TaskIndexOutOfBoundsException() {
        super();
        Messages.printTaskIndexOutOfBounds();
    }
}
