public class MarkDone {
    protected boolean isDone;
    protected String statement; // protected: only class and subclass can access

    public static MarkDone taskList(String task, String type) {
        if (type.equals("todo")) {
            return new ToDos(task);     // pass into ToDos
        } else if (type.equals("deadline")) {
            String[] s = task.split(" /by ", 2);
            String taskDescription = s[0];    // task description always the first element in the String[]
            String by = s[1];
            return new Deadlines(taskDescription, by);      // pass into Deadlines
        } else if (type.equals("event")) {
            String[] s = task.split(" /at", 2);
            String taskDescription = s[0];
            String at = s[1];
            return new Events(taskDescription, at);     // pass into Events
        } else {
            return null;
        }
    }

    public MarkDone(String task) {
        this.statement = task;
        this.isDone = false;
    }

    public String markTask() {
        if (isDone) {
            return "✓";    // tick
        } else {
            return "✗";    // cross
        }
    }

    public void markedasDone() {
        this.isDone = true;
    }

    public String toString() {
        return "[" + markTask() + "] " + statement;
    }
}
