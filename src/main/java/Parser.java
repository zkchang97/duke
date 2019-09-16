public class Parser {

    private Parser() {}

    /**
     * Returns appropriate statements depending on command input by user
     * @param input, input string by the user
     * @return, returns the subsequent action executed by Duke according to the input string by user
     */
    public static Command parse(String input) throws DukeException {
        int taskNo;
        String type;
        String description;
        String[] params = input.split(" ", 2);
        String action = params[0];

        switch(action) {
            case "blah":
                throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
            case "bye":
                return new ByeCommand();
            case "list":
                return new ListCommand();
            case "delete":
                taskNo = Integer.parseInt(params[1]);
                return new DeleteCommand(taskNo);
            case "done":
                taskNo = Integer.parseInt(params[1]);
                return new DoneCommand(taskNo);
            case "find":
                String substring = params[1];
                return new FindCommand(substring);
            case "todo":
            case "deadline":
            case "event":
                type = params[0];
                if (params.length <= 1) {
                    throw new DukeException("☹ OOPS!!! The description of a " + type + " cannot be empty.");
                }
                description = params[1];
                return new AddCommand(description, type);
            default:
                return new AddCommand(input);
        }
    }
}
