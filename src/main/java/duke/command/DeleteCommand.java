package duke.command;

import duke.task.Storage;
import duke.task.TaskList;
import duke.task.Tasks;
import duke.task.Ui;

public class DeleteCommand extends Command {
    int removeTaskNo;

    /**
     * Public constructor, deletes the task at given position.
     * @param removeTaskNo the given position for deletion of task.
     */
    public DeleteCommand(int removeTaskNo) {
        super(false);
        this.removeTaskNo = removeTaskNo;
    }

    /**
     * Executes the command to delete the task at the given position.
     * @param tasks task list in command execution.
     * @param ui user interface in command execution.
     * @param storage storage in command execution.
     */
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Tasks task = tasks.removeTask(removeTaskNo);
        ui.showDeleteMessage(task, tasks);
    }
}
