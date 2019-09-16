public class ToDos extends Tasks {

    /**
     * Public constructor, returns uncompleted task
     * @param description description of the task
     */
    public ToDos(String description) {
        super(description);   // invoke immediate parent class constructor (MarkDone)
    }

    /**
     * Public constructor, returns the uncompleted task
     * @param description description of task
     * @param isDone checks if task has been completed or not
     */
    public ToDos(String description, boolean isDone) {
        super(description, isDone);
    }

    @Override
    /**
     * Returns statement shown in the list as a To Do task
     * @return
     */
    public String toString() {
        return ("[T]" + super.toString());
    }
}
