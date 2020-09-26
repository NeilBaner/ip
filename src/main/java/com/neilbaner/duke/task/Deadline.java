package com.neilbaner.duke.task;

public class Deadline extends TaskWithAssociatedDate {

    public Deadline(String title, String dueDate) {
        super(title, dueDate);
        setDateTime(this.associatedDateString);
    }

    public Deadline(String title, String description, String dueDate) {
        super(title, description, dueDate);
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + ", by " + associatedDateString;
    }

}
