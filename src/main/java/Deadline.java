public class Deadline extends Task {
    private String dueDate;

    public Deadline(String title, String dueDate) {
        super(title);
        this.dueDate = dueDate;
    }

    public Deadline(String title, String description, String dueDate) {
        super(title, description);
        this.dueDate = dueDate;
    }
}
