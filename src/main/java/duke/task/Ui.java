package duke.task;

import duke.task.TaskList;

import java.util.List;
import java.util.Scanner;

public class Ui {
    Scanner input;

    /**
     * Public constructor, returns UI to receive inputs
     */
    public Ui() {
        input = new Scanner(System.in);
    }

    /**
     * Prints loading error
     */
    public void showLoadError() {
        System.out.println("No task data found.");
    }

    /**
     * Prints error
     * @param errorMessage error message to be printed
     */
    public void showError(String errorMessage) {
        System.out.println(errorMessage);
    }

    /**
     * Prints welcome message
     */
    public void showWelcomeMessage() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("What can I do for you?");
    }

    /**
     * Prints goodbye message
     */
    public void showGoodbye() {
        System.out.println("Bye. Hope to see you again soon!");
    }

    /**
     * Prints all tasks in the list
     * @param taskList list of tasks to be printed
     */
    public void showTaskList(List<Tasks> taskList) {
        System.out.println("Here are the tasks in your list:");
        int count = 1;
        for (Tasks task: taskList) {
            System.out.println(count + "." + task);
            count++;
        }
    }

    /**
     * Prints message stating the task is completed
     * @param task completed task
     */
    public void showDoneMessage(Tasks task) {
        System.out.println("Nice! I've marked this task as done.");
        System.out.println(task);
    }

    /**
     * Prints message stating a task is added
     * @param task added task
     * @param taskList list the task is added to
     */
    public void showAddMessage(Tasks task, TaskList taskList) {
        System.out.println("Got it. I've added this task:");
        System.out.println(task);
        System.out.println("Now you have " + taskList.getSize() + " tasks in the list");
    }

    /**
     * Prints message stating a task is deleted
     * @param task deleted task
     * @param taskList list the task is delted from
     */
    public void showDeleteMessage(Tasks task, TaskList taskList) {
        System.out.println("Noted. I've removed this task:");
        System.out.println(task);
        System.out.println("Now you have " + taskList.getSize() + " tasks in the list.");
    }

    /**
     * Read next line of input
     * @return returns input as a string
     */
    public String readCommand() {
        return input.nextLine();
    }

    /**
     * Prints line
     */
    public void showLine() {
        System.out.println("__________________________");
    }

}
