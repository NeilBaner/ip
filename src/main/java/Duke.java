import java.util.Scanner;

public class Duke {
    public static TaskList list = new TaskList();



    public static void printTaskList() {
        Messages.printHorizontalLine();
        if (list.getSize() == 0) {
            System.out.println("No tasks added yet");
        }
        for (Task task : list.getAllTasks()) {
            task.print();
        }
        Messages.printHorizontalLine();
    }

    public static void addToDo(String title) {
        list.addTask(new ToDo(title));
        Messages.printAddedToDo(title);
    }

    public static void addEvent(String title, String eventTime) {
        list.addTask(new Event(title, eventTime));
        Messages.printAddedEvent(title);
    }

    public static void addDeadline(String title, String dueDate) {
        list.addTask(new Deadline(title, dueDate));
        Messages.printAddedDeadline(title);
    }

    public static void markDone(int indexToMark) throws NumberFormatException, IndexOutOfBoundsException {
        list.markTaskDone(indexToMark);
        Messages.printMarkedDone(list.getTask(indexToMark).getTitle());
    }

    public static void main(String[] args) {
        Scanner k = new Scanner(System.in);
        String input;
        boolean toContinue = true;
        Messages.printHello();
        while (toContinue) {
            input = k.nextLine();
            if (input.toLowerCase().equals("bye")) {
                toContinue = false;
                Messages.printGoodBye();
            } else if (input.toLowerCase().equals("list")) {
                printTaskList();
            } else if (input.toLowerCase().startsWith("done")) {
                try {
                    int indexToMark = Integer.parseInt(input.substring(5)) - 1;
                    markDone(indexToMark);
                } catch (NumberFormatException e) {
                    Messages.printFormattingError();
                } catch (IndexOutOfBoundsException e) {
                    Messages.printNonExistError();
                }
            } else if (input.toLowerCase().startsWith("todo")) {
                addToDo(input.substring(5));
            } else if (input.toLowerCase().startsWith("deadline")) {
                try {
                    String title = input.substring(9, input.indexOf("/by")).strip();
                    String dueDate = input.substring(input.indexOf("/by") + 4).strip();
                    addDeadline(title, dueDate);
                } catch (IndexOutOfBoundsException e) {
                    Messages.printFormattingError();
                }
            } else if (input.startsWith("event")) {
                try {
                    String title = input.substring(6, input.indexOf("/at")).strip();
                    String eventTime = input.substring(input.indexOf("/at") + 4).strip();
                    addEvent(title, eventTime);
                } catch (IndexOutOfBoundsException e) {
                    Messages.printFormattingError();
                }
            }
        }
    }
}
