package com.neilbaner.duke.task;

public abstract class Task {
    private String title;
    private String description;
    private boolean isDone;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.isDone = false;
    }

    public Task(String title) {
        this.title = title;
        this.description = "";
        this.isDone = false;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean getDone() {
        return isDone;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
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
