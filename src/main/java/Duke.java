import java.util.Scanner;
import java.lang.Integer;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("What can I do for you?");

        Scanner input = new Scanner(System.in);
        boolean isListening = true;
        ToDoList toDoList = new ToDoList(); // create instance of TDL
        while (isListening) {
            String command = input.nextLine(); // take input within the loop to avoid infinite loop
            if (command.equalsIgnoreCase("bye")) { // send good bye message when command == "bye"
                System.out.println("Bye. Hope to see you again soon!");
                isListening = false; // change flag to exit loop
            } else if (command.equalsIgnoreCase("list")) { // list tasks if command == "list"
                toDoList.listTasks();
            } else if (command.substring(0, 4).equalsIgnoreCase("done")) {
                String s[] = command.split(" ");
                int taskno = Integer.parseInt(s[1]);    // parseInt converts string to Int
                toDoList.markasDone(taskno);
            } else {
                toDoList.addTask(command);
            }
        }
    }

}