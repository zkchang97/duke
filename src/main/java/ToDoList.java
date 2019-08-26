import java.util.ArrayList;
import java.util.List;

public class ToDoList {
    private List<MarkDone> toDoList;
    public ToDoList() {
        toDoList = new ArrayList<>();
    }

    public void addTask(String s) { // store text created by user
        System.out.println("added: " + s);
        MarkDone task = new MarkDone(s);
        toDoList.add(task);
    }

    public void markasDone(int n) {
        MarkDone task = toDoList.get(n - 1);
        task.markedasDone(); // boolean == true when task is completed
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(" " + task.printStatement());
    }

    public void listTasks() { // display back when requested
        int count = 1;
        System.out.println("Here are the tasks in your list:");
        for (MarkDone task: toDoList) {
            System.out.println(count + ". " + task.printStatement());
            count++;
        }
    }
}
