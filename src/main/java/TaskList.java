import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;

    public TaskList(){
        tasks = new ArrayList<Task>();
    }

    public ArrayList<Task> getAllTasks(){
        return tasks;
    }

    public void addTask(Task t){
        tasks.add(t);
    }

    public int deleteTask(int index){
        try {
            tasks.remove(index);
            return 0;
        } catch(IndexOutOfBoundsException e){
            return 1;
        }
    }
}
