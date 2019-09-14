import java.util.List;
import java.util.ArrayList;

public class TaskList {

    private List<MarkDone> taskList;
    private static final String INDENT = "  ";

    public TaskList(List<MarkDone> taskList) {
        this.taskList = taskList;
    }

    public TaskList() {
        this.taskList = new ArrayList<>();
    }

    public List<MarkDone> getTaskList() {
        return taskList;
    }

    public int getSize() {
        return taskList.size();
    }

    public MarkDone addTask(String description) {
        return addTask(description, "todo");
    }

    public MarkDone addTask(String description, String taskType) {
        MarkDone task = MarkDone.taskList(description, taskType);
        taskList.add(task);
        return task;
    }

    public MarkDone removeTask(int taskNo) {
        return taskList.remove(taskNo - 1);
    }

    public MarkDone markDone (int taskNo) {
        MarkDone task = taskList.get(taskNo - 1);
        task.isitDone();
        return task;
    }
}