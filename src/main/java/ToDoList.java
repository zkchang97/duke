import java.util.ArrayList;
import java.util.List;

public class ToDoList {
    private List<String> toDoList;
    public ToDoList() {
        toDoList = new ArrayList<>();
    }

    public void addTask(String s) { // store text created by user
        toDoList.add(s);
        System.out.println("added: " + s);
    }

    public void listTasks() { // display back when requested
        int count = 1;
        for (String s: toDoList) {
            System.out.println(count + ". " + s);
            count++;
        }
    }
}
