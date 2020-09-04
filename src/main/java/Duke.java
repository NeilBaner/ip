import java.util.Scanner;

public class Duke {
    public static TaskList list = new TaskList();


    public static void printTaskList() {
        Messages.printHorizontalLine();
        if (list.getSize() == 0) {
            System.out.println("No tasks added yet");
        }
        for (Task task : list.getAllTasks()) {
            System.out.println(task.toString());
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

    private static String getEventTime(String input) {
        return input.substring(input.indexOf("/at") + 4).strip();
    }

    private static String getEventTitle(String input) {
        return input.substring(6, input.indexOf("/at")).strip();
    }

    private static String getDeadlineDueDate(String input) {
        return input.substring(input.indexOf("/by") + 4).strip();
    }

    private static int getIndexToMark(String input) {
        return Integer.parseInt(input.substring(5)) - 1;
    }

    private static String getDeadlineTitle(String input) {
        return input.substring(9, input.indexOf("/by")).strip();
    }

    private static boolean parseInput(String input) {
        boolean toContinue = true;
        if (input.toLowerCase().equals("bye")) {
            toContinue = false;
            Messages.printGoodBye();
        } else if (input.toLowerCase().equals("list")) {
            printTaskList();
        } else if (input.toLowerCase().startsWith("done")) {
            try {
                int indexToMark = getIndexToMark(input);
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
                String title = getDeadlineTitle(input);
                String dueDate = getDeadlineDueDate(input);
                addDeadline(title, dueDate);
            } catch (IndexOutOfBoundsException e) {
                Messages.printFormattingError();
            }
        } else if (input.startsWith("event")) {
            try {
                String title = getEventTitle(input);
                String eventTime = getEventTime(input);
                addEvent(title, eventTime);
            } catch (IndexOutOfBoundsException e) {
                Messages.printFormattingError();
            }
        }
        return toContinue;
    }

    public static void main(String[] args) {
        Scanner k = new Scanner(System.in);
        String input;
        boolean toContinue = true;
        Messages.printHello();
        while (toContinue) {
            input = k.nextLine();
            toContinue = parseInput(input);
        }
    }
}
