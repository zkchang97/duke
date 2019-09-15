import java.util.List;
import java.util.ArrayList;

public class TaskList {

    private List<Tasks> taskList;
    private static final String INDENT = "  ";

    /**
     * Public constructor, returns list of tasks
     * @param taskList  list of tasks in the system
     */
    public TaskList(List<Tasks> taskList) {
        this.taskList = taskList;
    }

    /**
     * Public constructor, returns empty list of tasks
     */
    public TaskList() {
        this.taskList = new ArrayList<>();
    }

    /**
     * Getter, gets list of tasks
     * @return returns list of tasks
     */
    public List<Tasks> getTaskList() {
        return taskList;
    }

    /**
     * Getter, gets size of list
     * @return returns size of list
     */
    public int getSize() {
        return taskList.size();
    }

    /**
     * Adds a "to do" task into the list
     * @param description description of the task to be added
     * @return returns "to do" task added
     */
    public Tasks addTask(String description) {
        return addTask(description, "todo");
    }

    /**
     * Adds task of type according to input
     * @param description description of the task to be added
     * @param type type of the task to be added
     * @return returns the task
     */
    public Tasks addTask(String description, String type) {
        Tasks task = Tasks.taskList(description, type);
        taskList.add(task);
        return task;
    }

    /**
     * Removes a task of position taskNo from the list
     * @param taskNo one-based index of the task to be removed
     * @return returns the task removed from the list
     */
    public Tasks removeTask(int taskNo) {
        return taskList.remove(taskNo - 1);
    }

    /**
     * Marks a task as completed at the position taskNo
     * @param taskNo one-based index position of the task in the list
     * @return returns the task marked as done from the list
     */
    public Tasks checkTask (int taskNo) {
        Tasks task = taskList.get(taskNo - 1);
        task.markedasDone();
        return task;
    }
}