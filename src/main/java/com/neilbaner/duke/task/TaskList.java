package com.neilbaner.duke.task;

import com.neilbaner.duke.exceptions.TaskIndexOutOfBoundsException;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @author Neil Banerjee
 * @version 1.0
 * A class to store the tasks that have been added by the user, and manage and manipulate them in various ways.
 */
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

    /**
     * Deletes the task at an index specified.
     * @param index the index of the task to be deleted, precondition: 0-indexed.
     * @throws TaskIndexOutOfBoundsException if the index does not exist in the list.
     */
    public void deleteTask(int index) throws TaskIndexOutOfBoundsException {
        try {
            tasks.remove(index);
        } catch (IndexOutOfBoundsException e) {
            throw new TaskIndexOutOfBoundsException();
        }
    }

    /**
     * Marks the task at an index as done.
     * @param index the index of the task to be marked as done, precondition: 0-indexed.
     * @throws TaskIndexOutOfBoundsException if the index does not exist in the list.
     */
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

    /**
     * Gets the task at a specified index
     * @param index the index of the task to get, precondition: 0-indexed
     * @return the Task at that index
     * @throws TaskIndexOutOfBoundsException if the index does not exist in the list
     */
    public Task getTask(int index) throws TaskIndexOutOfBoundsException {
        try {
            return tasks.get(index);
        } catch (IndexOutOfBoundsException e) {
            throw new TaskIndexOutOfBoundsException();
        }
    }

    /**
     * Gets all the tasks in the list that have a date before the one specified.
     * @param dateBeforeWhich the specified date before which we want to get tasks.
     * @return all the tasks before that date, as an ArrayList of tasks.
     */
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

    /**
     * Gets all the tasks in the list that have a date the same as the one specified.
     * @param dateBeforeWhich the specified date on which we want to get tasks.
     * @return all the tasks on that date, as an ArrayList of tasks.
     */
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

    /**
     * Gets all the tasks in the list whose titles contain a certain string, the search key.
     * @param searchKey the string to search for.
     * @return all the tasks containing that string, as an ArrayList of tasks. 
     */
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
