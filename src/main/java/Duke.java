import java.util.Scanner;

public class Duke {
    public static TaskList list = new TaskList();
    
    public static void printHorizontalLine(){
        System.out.println("____________________________________________________________");
    }
    public static void printHello(){
        printHorizontalLine();
        System.out.println("Hello! I'm Duke. ");
        System.out.println("What can I do for you?");
        printHorizontalLine();
    }
    public static void printGoodBye(){
        System.out.println("Bye. Hope to see you again soon!");
    }
    
    public static void printTaskList(){
        for (int i = 0; i < list.getSize(); i++) {
            Task t = list.getTask(i);
            System.out.print((i + 1) + ". [");
            if(t.getDone()){
                System.out.print("*");
            }else{
                System.out.print(" ");
            }
            System.out.println("] " + t.getTitle());
        }
    }

    public static void addTask(String title){
        list.addTask(new Task(title));
    }

    public static void main(String[] args) {
        Scanner k = new Scanner(System.in);
        String input;
        printHello();
        while(true){
            input = k.nextLine();
            if(input.toLowerCase().equals("bye")){
                break;
            } else if(input.toLowerCase().equals("list")){
                printTaskList();
                continue;
            }else if (input.toLowerCase().startsWith("done")){
                try {
                    int indexToMark = Integer.parseInt(input.substring(5)) - 1;
                    list.markTaskDone(indexToMark);
                }catch (NumberFormatException e){
                    System.out.println("Incorrectly formatted input");
                }catch (IndexOutOfBoundsException e){
                    System.out.println("Task does not exist in list");
                }
            }else {
                addTask(input);
                System.out.println("Added task: " + input);
                continue;
            }
        }
        printHorizontalLine();
        printGoodBye();
        printHorizontalLine();
    }
}
