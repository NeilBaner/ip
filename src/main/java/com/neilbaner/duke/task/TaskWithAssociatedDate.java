package com.neilbaner.duke.task;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;

public abstract class TaskWithAssociatedDate extends Task {
    protected String associatedDateString;
    protected LocalDate associatedDate;
    protected LocalTime associatedTime;

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

    public LocalDate getAssociatedDate() {
        return associatedDate;
    }

    public LocalTime getAssociatedTime() {
        return associatedTime;
    }

    protected void setDateTime(String dateString) {
        setDate(dateString);
        setTime(dateString);
    }

    protected void setDate(String dateString) {
        String[] tokens = dateString.split(" ");
        for (String token : tokens) {
            try {
                associatedDate = LocalDate.parse(token);
                return;
            } catch (DateTimeException e) {

            }
        }
    }

    protected void setTime(String dateString) {
        String[] tokens = dateString.split(" ");
        for (String token : tokens) {
            try {
                associatedTime = LocalTime.parse(token);
                return;
            } catch (DateTimeException e) {

            }
        }
    }

    public String getAssociatedDateString() {
        return associatedDateString;
    }
}
