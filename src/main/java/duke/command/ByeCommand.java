package duke.command;

import duke.task.Storage;
import duke.task.TaskList;
import duke.task.Ui;

public class ByeCommand extends Command {

    /**
     * Public constructor, terminates Duke when executed.
     */
    public ByeCommand() {
        super(true);
    }

    /**
     * Terminates the system when executed.
     * @param tasks task list in command execution.
     * @param ui user interface in command execution.
     * @param storage storage in command execution.
     */
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        storage.saveTasks((tasks.getTaskList()));
        ui.showGoodbye();
    }
}
