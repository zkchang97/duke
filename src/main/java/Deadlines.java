public class Deadlines extends MarkDone {

    protected String deadline;
    public Deadlines(String task, String deadline) {
        super(task);
        this.deadline = DukeDateFormat.convertStringToDate(deadline);   // by
    }

    public Deadlines(String task, boolean isDone, String deadline) {
        super(task, isDone);
        this.deadline = deadline;
    }

    public String getDeadline() {
        return deadline;
    }

    public String toString() {
        return ("[D]" + super.toString() + " (by: " + deadline + ")");
    }
}
