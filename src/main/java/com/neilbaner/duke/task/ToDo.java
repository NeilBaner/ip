package com.neilbaner.duke.task;

/**
 * @author Neil Banerjee
 * @version 1.0
 * Represents a todo task. Contains the task title, and whether or not the task is done (false by default).
 */
public class ToDo extends Task {
    public ToDo(String title) {
        super(title);
    }

    public ToDo(String title, String description) {
        super(title, description);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

}
