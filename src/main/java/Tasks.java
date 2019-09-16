public class Tasks {
    protected boolean isDone;
    protected String description; // protected: only class and subclass can access

    /**
     * Creates the appropriate task according to parameters
     * @param task description of task
     * @param type type of task
     * @return returns an uncompleted task according to task and type
     */
    public static Tasks taskList(String task, String type) {
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

    /**
     * Creates a task according to taskParams
     * @param taskParams array of parameters of the task to be created
     * @return returns uncompleted task according to taskParams
     */
    public static Tasks taskList(String[] taskParams) {
        String type = taskParams[0];
        boolean isDone = taskParams[1].equals("true");
        String description = taskParams[2];
        if (type.equals("T")) {
            return new ToDos(description, isDone);
        } else if (type.equals("D")) {
            String by = taskParams[3];
            return new Deadlines(description, isDone, by);
        } else if (type.equals("E")) {
            String at = taskParams[3];
            return new Events(description, isDone, at);
        } else {
            return null;
        }
    }

    /**
     * Public constructor of a task
     * @param description
     */
    public Tasks(String description) {
        this.description = description;
        this.isDone = false;
    }

    public Tasks(String description, boolean isDone) {
        this.description = description;
        this.isDone = isDone;
    }

    public String getDescription() {
        return description;
    }

    public Boolean isitDone() {
        return isDone;
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

    public boolean isContainingSubstring(String substring) {
        return description.contains((substring));
    }

    @Override
    public String toString() {
        return "[" + markTask() + "] " + description;
    }
}

