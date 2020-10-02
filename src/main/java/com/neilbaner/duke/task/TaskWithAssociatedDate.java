package com.neilbaner.duke.task;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author Neil Banerjee
 * @version 1.0
 * An abstract class for any type of task that has a date, such as a deadline. Currently, Event and Deadline extend
 * this class.
 */

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

    /**
     * Sets the date of the task based on a string that has been input by the user. If a properly formatted date has
     * not been entered by the user, then the LocalDate object is simply not set and the string is used directly
     * instead.
     * @param dateString the string input by the user which may or may not contain a properly formatted date.
     */
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

    /**
     * Sets the time of the task based on a string that has been input by the user. If a properly formatted time has
     * not been entered by the user, then the LocalTime object is simply not set and the string is used directly
     * instead.
     * @param dateString the string input by the user which may or may not contain a properly formatted time.
     */
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

    /**
     * Gets the associated date of the task as a String instead of as a LocalDate
     * @return the date of the task as a String
     */
    public String getAssociatedDateString() {
        return associatedDateString;
    }
}
