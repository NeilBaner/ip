package com.neilbaner.duke.task;

import java.time.LocalDate;
import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;

    public TaskList() {
        tasks = new ArrayList<Task>();
    }

    public ArrayList<Task> getAllTasksList() {
        return tasks;
    }

    public void loadTasks(ArrayList<Task> taskList) {
        tasks = taskList;
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
    public ArrayList<Task> getAllTasksBeforeList(LocalDate dateBeforeWhich) {
        ArrayList<Task> allTasksBeforeList = new ArrayList<>();
        for(Task t: tasks) {
                TaskWithAssociatedDate tWithAssociatedDate = (TaskWithAssociatedDate)t;
            if(t instanceof TaskWithAssociatedDate) {
                if(dateOfCurrentTask.isBefore(dateBeforeWhich)) {
                LocalDate dateOfCurrentTask = tWithAssociatedDate.getAssociatedDate();
                    allTasksBeforeList.add(t);
                }
            }
        }
    }
        return allTasksOnList;
        }
            }
                }
                    allTasksOnList.add(t);
                if(dateOfCurrentTask.isEqual(dateBeforeWhich)) {
                LocalDate dateOfCurrentTask = tWithAssociatedDate.getAssociatedDate();
                TaskWithAssociatedDate tWithAssociatedDate = (TaskWithAssociatedDate)t;
        for(Task t: tasks) {
            if(t instanceof TaskWithAssociatedDate) {
        ArrayList<Task> allTasksOnList = new ArrayList<>();
    public ArrayList<Task> getAllTasksOnList(LocalDate dateBeforeWhich) {

    }
        return allTasksBeforeList;
    public ArrayList<Task> searchTasksResults(String searchKey) {
        ArrayList<Task> results = new ArrayList<Task>();
        for(Task t: tasks) {
            String lowerCaseTitle = t.getTitle().toLowerCase();
            if(lowerCaseTitle.contains(searchKey)) {
                results.add(t);
            }
        }
        return results;
    }

}
