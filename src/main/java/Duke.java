
public class Duke {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    /**
     * Public constructor, returns Duke with a storage filepath for saving
     * @param filePath file path to store the task data after "bye" command
     */
    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (DukeException e) {
            ui.showLoadError();
            tasks = new TaskList();
        }
    }

    /**
     * Initiates Duke system, parses commands to update list
     */
    public void run() {
        ui.showWelcomeMessage();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine();
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
            } catch (DukeException e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
    }

    /**
     * Main class, initiates and drives Duke with .run()
     * @param args received from command line
     */
    public static void main(String[] args) {
        String filePath = "C:\\Users\\chang\\Desktop\\cs2113\\duke\\src\\main\\java\\duke.txt";
        new Duke(filePath).run();
    }
}
/*
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
        String filePath = "C:\\Users\\chang\\Desktop\\cs2113\\duke\\src\\main\\java\\duke.txt";
        ToDoList toDoList = new ToDoList(filePath);
        while (isListening) {
            String command = input.nextLine(); // take input within the loop to avoid infinite loop
            String[] s = command.split(" ", 2); // split command into action and description
            String action = s[0];   // captures the action word
            try {
                if (action.equals("bye")) { // send good bye message when command == "bye"
                    System.out.println("Bye. Hope to see you again soon!");
                    toDoList.saveTasks();
                    isListening = false; // change flag to exit loop
                } else if (action.equals("list")) { // list tasks if command == "list"
                    toDoList.listTasks();
                } else if (action.equals("blah")) {
                    throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                } else if (action.equals("delete")) {
                    int taskno = Integer.parseInt(s[1]);
                    toDoList.removeTask(taskno);
                } else if (action.equals("done")) {
                    int taskno = Integer.parseInt(s[1]);    // parseInt converts string to Int
                    toDoList.markasDone(taskno);
                } else if (action.equals("todo") || action.equals("deadline") || action.equals("event")) {
                    String type = s[0];
                    if (s.length <= 1) {
                        throw new DukeException("☹ OOPS!!! The description of a " + type + " cannot be empty");
                    }
                    String description = s[1];
                    toDoList.addTask(description, type);
                } else {
                    toDoList.addTask(command);
                }
            } catch (DukeException dukeException) {
                System.out.println(dukeException.getMessage());
            }
        }
    }
}

 */