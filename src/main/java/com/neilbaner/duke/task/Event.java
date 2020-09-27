package com.neilbaner.duke.task;

import java.time.format.DateTimeFormatter;

public class Event extends TaskWithAssociatedDate {

    public Event(String title, String eventTime) {
        super(title, eventTime);
        this.associatedDateString = eventTime;
    }

    public Event(String title, String description, String eventTime) {
        super(title, description, eventTime);
        this.associatedDateString = eventTime;
    }

    @Override
    public String toString() {
        if(associatedDate != null) {
            return "[E]" + super.toString() + ", at " + associatedDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }
        return "[E]" + super.toString() + ", at " + associatedDateString;
    }
}
