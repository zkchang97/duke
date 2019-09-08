import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class ToDoList {
    private String filePath;
    private List<MarkDone> toDoList;
    private static String divider = " DIVIDER ";
    public ToDoList(String filePath) {
        this.filePath = filePath;
        toDoList = new ArrayList<>();
        readTasks();
    }

    private void readTasks() {
        try {
            BufferedReader bufferedreader = new BufferedReader(new FileReader(filePath));
            String s;
            while ((s = bufferedreader.readLine()) != null) {
                String[] taskParams = s.split(divider);
                MarkDone task = MarkDone.taskList(taskParams);
                toDoList.add(task);
            }
        } catch (IOException ioException) {

        }
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

    public void removeTask(int n) {
        MarkDone task = toDoList.remove(n - 1);
        System.out.println("Noted. I've removed this task: ");
        System.out.println(" " + task.toString());
        System.out.println("Now you have " + toDoList.size() + " tasks in the list");
    }

    public void listTasks() { // display back when requested
        int count = 1;
        System.out.println("Here are the tasks in your list:");
        for (MarkDone task: toDoList) {
            System.out.println(count + ". " + task.toString());
            count++;
        }
    }

    public void saveTasks() {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (MarkDone task: toDoList) {
                if (task instanceof ToDos) {    // to test if the object is an instant of the ToDos, returns true/false
                    writer.write("T");
                } else if (task instanceof Deadlines) {
                    writer.write("D");
                } else if (task instanceof Events) {
                    writer.write("E");
                }
                writer.write(divider + task.isitDone() + divider + task.getDescription());
                if (task instanceof Deadlines) {
                    writer.write(divider + ((Deadlines) task).getDeadline());
                } else if (task instanceof Events) {
                    writer.write(divider + ((Events) task).getVenue());
                }
                writer.write("\n");
            }
        } catch (IOException ioException) {

        }
    }
}
