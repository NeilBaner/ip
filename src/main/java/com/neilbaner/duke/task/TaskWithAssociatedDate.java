package com.neilbaner.duke.task;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;

public abstract class TaskWithAssociatedDate extends Task {
    protected String associatedDateString;

    public LocalDate getAssociatedDate() {
        return associatedDate;
    }

    public LocalTime getAssociatedTime() {
        return associatedTime;
    }

    public TaskWithAssociatedDate(String title, String associatedDate) {
        super(title);
        this.associatedDateString = associatedDate;
        setDateTime(associatedDate);
    }

    public TaskWithAssociatedDate(String title, String description, String associatedDate) {
        super(title, description);
        this.associatedDateString = associatedDate;
        setDateTime(associatedDate);
    }

    protected void setDateTime(String dateString) {
        setDate(dateString);
        setTime(dateString);
    }

    private void setDate(String dateString) {
        String[] tokens = dateString.split(" ");
        for (String token : tokens) {
            try {
                associatedDate = LocalDate.parse(token);
                return;
            } catch (DateTimeException e) {
                continue;
            }
        }
    }

    private void setTime(String dateString) {
        String[] tokens = dateString.split(" ");
        for (String token : tokens) {
            try {
                associatedTime = LocalTime.parse(token);
                return;
            } catch (DateTimeException e) {
                continue;
            }
        }
    }
    public String getAssociatedDateString() {
        return associatedDateString;
    }
}
