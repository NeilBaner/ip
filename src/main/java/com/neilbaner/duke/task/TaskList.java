package com.neilbaner.duke.task;

import com.neilbaner.duke.exceptions.TaskIndexOutOfBoundsException;

import java.time.LocalDate;
import java.util.ArrayList;

public class TaskList {
    private final ArrayList<Task> tasks;

    public TaskList() {
        tasks = new ArrayList<Task>();
    }

    public ArrayList<Task> getAllTasksList() {
        return tasks;
    }

    public void addTask(Task t) {
        tasks.add(t);
    }

    public void deleteTask(int index) throws TaskIndexOutOfBoundsException {
        try {
            tasks.remove(index);
        } catch (IndexOutOfBoundsException e) {
            throw new TaskIndexOutOfBoundsException();
        }
    }

    public void markTaskDone(int index) throws TaskIndexOutOfBoundsException {
        try {
            tasks.get(index).setDone();
        } catch (IndexOutOfBoundsException e) {
            throw new TaskIndexOutOfBoundsException();
        }
    }

    public int getSize() {
        return tasks.size();
    }

    public Task getTask(int index) throws TaskIndexOutOfBoundsException {
        try {
            return tasks.get(index);
        } catch (IndexOutOfBoundsException e) {
            throw new TaskIndexOutOfBoundsException();
        }
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

    public ArrayList<Task> searchTasksResults(String searchKey) {
        ArrayList<Task> results = new ArrayList<Task>();
        for (Task t : tasks) {
            if (t.getTitle().contains(searchKey)) {
                results.add(t);
            }
        }
        return results;
    }

}
