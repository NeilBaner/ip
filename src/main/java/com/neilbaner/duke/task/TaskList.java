package com.neilbaner.duke.task;

import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;

    public TaskList() {
        tasks = new ArrayList<Task>();
    }

    public ArrayList<Task> getAllTasksList() {
        return tasks;
    }

    public void addTask(Task t) {
        tasks.add(t);
    }

    public void deleteTask(int index) throws IndexOutOfBoundsException {
        tasks.remove(index);
    }

    public void markTaskDone(int index) throws IndexOutOfBoundsException {
        tasks.get(index).setDone();
    }

    public int getSize() {
        return tasks.size();
    }

    public Task getTask(int index) {
        return tasks.get(index);
    }
}
