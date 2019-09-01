public class Deadlines extends MarkDone {

    String deadline;
    public Deadlines(String task, String deadline) {
        super(task);
        this.deadline = deadline;   // by
    }

    public String toString() {
        return ("[D]" + super.toString() + " (by: " + deadline + ")");
    }
}
