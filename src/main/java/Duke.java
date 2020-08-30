import java.util.Scanner;

public class Duke {
    public static TaskList list = new TaskList();

    public static void printHorizontalLine() {
        System.out.println("____________________________________________________________");
    }

    public static void printHello() {
        printHorizontalLine();
        System.out.println("Hello! I'm Duke. ");
        System.out.println("What can I do for you?");
        printHorizontalLine();
    }

    public static void printGoodBye() {
        System.out.println("Bye. Hope to see you again soon!");
    }

    public static void printTaskList() {
        printHorizontalLine();
        if (list.getSize() == 0) {
            System.out.println("No tasks added yet");
        }
        for (Task task: list.getAllTasks()) {
            task.print();
        }
        printHorizontalLine();
    }

    public static void addToDo(String title) {
        list.addTask(new ToDo(title));
        printHorizontalLine();
        System.out.println("Done. I've added the following to-do to your list: " + title);
        printHorizontalLine();
    }

    public static void markDone(int indexToMark) throws NumberFormatException, IndexOutOfBoundsException {
        list.markTaskDone(indexToMark);
        printHorizontalLine();
        System.out.println(list.getTask(indexToMark).getTitle() + " marked as done.");
        printHorizontalLine();
    }

    public static void main(String[] args) {
        Scanner k = new Scanner(System.in);
        String input;
        boolean toContinue = true;
        printHello();
        while (toContinue) {
            input = k.nextLine();
            if (input.toLowerCase().equals("bye")) {
                toContinue = false;
                printHorizontalLine();
                printGoodBye();
                printHorizontalLine();
            } else if (input.toLowerCase().equals("list")) {
                printTaskList();
            } else if (input.toLowerCase().startsWith("done")) {
                try {
                    int indexToMark = Integer.parseInt(input.substring(5)) - 1;
                    markDone(indexToMark);
                } catch (NumberFormatException e) {
                    System.out.println("Incorrectly formatted input");
                    printHorizontalLine();
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Task does not exist in list");
                    printHorizontalLine();
                }
            } else if (input.toLowerCase().startsWith("todo")){
                addToDo(input.substring(5));
            }
        }

    }
}
