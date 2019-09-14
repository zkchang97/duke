import com.sun.source.util.TaskListener;

import java.util.List;
import java.util.Scanner;

public class Ui {
    Scanner input;

    public Ui() {
        input = new Scanner(System.in);
    }

    public void showLoadError() {
        System.out.println("No task data found.");
    }

    public void showError(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void showWelcomeMessage() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("What can I do for you?");
    }

    public void showGoodbye() {
        System.out.println("Bye. Hope to see you again soon!");
    }

    public void showTaskList(List<MarkDone> taskList) {
        System.out.println("Here are the tasks in your list:");
        int count = 1;
        for (MarkDone task: taskList) {
            System.out.println(count + "." + task);
            count++;
        }
    }

    public void showDoneMessage(MarkDone task) {
        System.out.println("Nice! I've marked this task as done.");
        System.out.println(task);
    }

    public void showAddMessage(MarkDone task, TaskList taskList) {
        System.out.println("Got it. I've added this task:");
        System.out.println(task);
        System.out.println("Now you have " + taskList.getSize() + " tasks in the list");
    }

    public void showDeleteMessage(MarkDone task, TaskList taskList) {
        System.out.println("Noted. I've removed this task:");
        System.out.println(task);
        System.out.println("Now you have " + taskList.getSize() + " tasks in the list.");
    }

    public String readCommand() {
        return input.nextLine();
    }

    public void showLine() {
        System.out.println("__________________________");
    }

}
