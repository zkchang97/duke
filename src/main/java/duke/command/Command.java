package duke.command;

import duke.task.Storage;
import duke.task.TaskList;
import duke.task.Ui;

public class Command {
    boolean isExit;

    /**
     * Protected constructor, returns a command to the system
     * @param isExit checks if Duke should terminate after the command
     */
    public Command(boolean isExit) {
        this.isExit = isExit;
    }

    /**
     * @return if Duke should terminate after the command
     */
    public boolean isExit() {
        return isExit;
    }

    public void execute(TaskList tasks, Ui ui, Storage storage) {

    }
}
