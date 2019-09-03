public class Deadlines extends MarkDone {

    protected String deadline;
    public Deadlines(String task, String deadline) {
        super(task);
        this.deadline = DukeDateFormat.convertStringToDate(deadline);   // by
    }

    public String toString() {
        return ("[D]" + super.toString() + " (by: " + deadline + ")");
    }
}
