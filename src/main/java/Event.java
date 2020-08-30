public class Event extends Task {
    private String eventTime;

    public Event(String title, String eventTime) {
        super(title);
        this.eventTime = eventTime;
    }

    public Event(String title, String description, String eventTime) {
        super(title, description);
        this.eventTime = eventTime;
    }

    @Override
    public void print() {
        System.out.print("[E]");
        super.print();
        System.out.print(", at " + eventTime);
        System.out.println();
    }
}
