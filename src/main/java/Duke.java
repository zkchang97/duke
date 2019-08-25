import java.util.Scanner;

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
        while (isListening) {
            String command = input.nextLine(); // take input within the loop to avoid infinite loop
            if (command.equalsIgnoreCase("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                isListening = false; // change flag to exit loop
            } else {
                System.out.println(command);
            }
        }
    }

}