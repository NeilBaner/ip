package com.neilbaner.duke.task;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;

public class TaskWithAssociatedDate extends Task {
    protected String associatedDateString;
    private LocalDate associatedDate;
    private LocalTime associatedTime;

    public TaskWithAssociatedDate(String title, String associatedDate) {
        super(title);
        this.associatedDateString = associatedDate;
    }

    public TaskWithAssociatedDate(String title, String description, String associatedDate) {
        super(title, description);
        this.associatedDateString = associatedDate;
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
