public class Deadlines extends Tasks {

    private String deadline;

    /**
     * Public constructor, returns uncompleted task with input deadline
     * @param task description of the task
     * @param deadline deadline of the task
     */
    public Deadlines(String task, String deadline) {
        super(task);
        this.deadline = DukeDateFormat.convertStringToDate(deadline);   // by
    }

    /**
     * Public constructor, returns a task with input deadline
     * @param task description of the task
     * @param isDone checks if task is completed
     * @param deadline deadline of the task
     */
    public Deadlines(String task, boolean isDone, String deadline) {
        super(task, isDone);
        this.deadline = deadline;
    }

    /**
     * Getter, gets the deadline of task
     * @return returns deadline of task
     */
    public String getDeadline() {
        return deadline;
    }

    /**
     * @return returns the statement and symbols as shown in Duke's List
     */
    public String toString() {
        return ("[D]" + super.toString() + " (by: " + deadline + ")");
    }
}
