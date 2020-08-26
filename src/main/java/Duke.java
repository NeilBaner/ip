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
            System.out.println((i + 1) + ". " + t.getTitle());
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
