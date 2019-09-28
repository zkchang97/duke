package duke.command;

import duke.task.Storage;
import duke.task.TaskList;
import duke.task.Ui;

public class Command {
    boolean isExit;

    /**
     * Protected constructor, returns a command to the system.
     * @param isExit checks if Duke should terminate after the command.
     */
    public Command(boolean isExit) {
        this.isExit = isExit;
    }

    /**
     * Returns if Duke should terminate after command.
     * @return true if Duke is to terminate, false otherwise.
     */
    public boolean isExit() {
        return isExit;
    }

    /**
     * Does nothing.
     * @param tasks task list system in command execution.
     * @param ui user interface system in command execution.
     * @param storage storage system in command execution.
     */
    public void execute(TaskList tasks, Ui ui, Storage storage) {

    }
}
