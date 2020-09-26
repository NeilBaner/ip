package com.neilbaner.duke.task;

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
        return "[E]" + super.toString() + ", at " + associatedDateString;
    }

    public String getEventTime() {
        return associatedDateString;
    }
}
