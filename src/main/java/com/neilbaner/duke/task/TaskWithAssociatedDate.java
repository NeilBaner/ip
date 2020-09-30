package com.neilbaner.duke.task;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;

public abstract class TaskWithAssociatedDate extends Task {
    String associatedDateString;
    LocalDate associatedDate;
    private LocalTime associatedTime;

    TaskWithAssociatedDate(String title, String associatedDate) {
        super(title);
        this.associatedDateString = associatedDate;
        setDateTime(associatedDate);
    }
    TaskWithAssociatedDate(String title, String description, String associatedDate) {
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

    void setDateTime(String dateString) {
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

            }
        }
    }

    public String getAssociatedDateString() {
        return associatedDateString;
    }
}
