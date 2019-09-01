import java.util.ArrayList;
import java.util.List;

public class ToDoList {
    private List<MarkDone> toDoList;
    public ToDoList() {
        toDoList = new ArrayList<>();
    }

    public void addTask(String description) { // store text created by user
        addTask(description, "todo");
    }

    public void addTask(String description, String type) {
        MarkDone task = MarkDone.taskList(description, type);
        toDoList.add(task);
        System.out.println("Got it. I've added this task: ");
        System.out.println(" " + new ToDos(description).toString());
        System.out.println("Now you have " + toDoList.size() + " tasks in the list");
    }

    public void markasDone(int n) {
        MarkDone task = toDoList.get(n - 1);
        task.markedasDone(); // boolean == true when task is completed
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(" " + task.toString());
    }

    public void listTasks() { // display back when requested
        int count = 1;
        System.out.println("Here are the tasks in your list:");
        for (MarkDone task: toDoList) {
            System.out.println(count + ". " + task.toString());
            count++;
        }
    }
}
