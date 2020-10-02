package com.neilbaner.duke.task;

/**
 * @author Neil Banerjee
 * @version 1.0
 * A class to represent any sort of Task. Any task will contain a title and whether or not the task is done.
 */
public abstract class Task {
    private String title;
    private String description;
    private boolean isDone;

    Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.isDone = false;
    }

    Task(String title) {
        this.title = title;
        this.description = "";
        this.isDone = false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getDone() {
        return isDone;
    }

    public void setDone() {
        isDone = true;
    }

    public void setNotDone() {
        isDone = false;
    }

    @Override
    public String toString() {
        return "[" + (isDone ? "*" : " ") + "] " + title;
    }
}
