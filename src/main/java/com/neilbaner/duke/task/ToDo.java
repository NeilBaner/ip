package com.neilbaner.duke.task;

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
