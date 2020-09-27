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
        for (Task t : tasks) {
            if (t instanceof TaskWithAssociatedDate) {
                TaskWithAssociatedDate tWithAssociatedDate = (TaskWithAssociatedDate) t;
                LocalDate dateOfCurrentTask = tWithAssociatedDate.getAssociatedDate();
                if (dateOfCurrentTask.isBefore(dateBeforeWhich)) {
                    allTasksBeforeList.add(t);
                }
            }
        }
        return allTasksBeforeList;
    }

    public ArrayList<Task> getAllTasksOnList(LocalDate dateBeforeWhich) {
        ArrayList<Task> allTasksOnList = new ArrayList<>();
        for (Task t : tasks) {
            if (t instanceof TaskWithAssociatedDate) {
                TaskWithAssociatedDate tWithAssociatedDate = (TaskWithAssociatedDate) t;
                LocalDate dateOfCurrentTask = tWithAssociatedDate.getAssociatedDate();
                if (dateOfCurrentTask.isEqual(dateBeforeWhich)) {
                    allTasksOnList.add(t);
                }
            }
        }
        return allTasksOnList;
    }

}
