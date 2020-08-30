public class ToDo extends Task{
    public ToDo (String title) {
        super(title);
    }
    public ToDo (String title, String description) {
        super(title, description);
    }

    @Override
    public void print() {
        System.out.print("[T]");
        super.print();
        System.out.println();
    }
}
