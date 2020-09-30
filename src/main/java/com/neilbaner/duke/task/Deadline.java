package com.neilbaner.duke.task;

import java.time.format.DateTimeFormatter;

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
        if (associatedDate != null) {
            return "[D]" + super.toString() + ", at " + associatedDate.format(DateTimeFormatter.ofPattern("dd/MM" +
                    "/yyyy"));
        }
        return "[D]" + super.toString() + ", at " + associatedDateString;
    }
}
