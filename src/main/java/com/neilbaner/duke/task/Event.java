package com.neilbaner.duke.task;

public class Event extends Task {
    private String eventTime;

    public Event(String title, String eventTime) {
        super(title);
        this.eventTime = eventTime;
    }

    public Event(String title, String description, String eventTime) {
        super(title, description);
        this.eventTime = eventTime;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + ", at " + eventTime;
    }
}
