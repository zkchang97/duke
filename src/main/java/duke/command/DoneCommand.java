package duke.command;

import duke.task.Storage;
import duke.task.TaskList;
import duke.task.Tasks;
import duke.task.Ui;

public class DoneCommand extends Command {
    int checkedTaskNo;

    /**
     * Public constructor, marks the task at checkedTaskNo to be completed
     * @param checkedTaskNo position of the task in the task list
     */
    public DoneCommand(int checkedTaskNo) {
        super(false);
        this.checkedTaskNo = checkedTaskNo;
    }

    /**
     * Executes the command to mark the task at checkedTaskNo as done
     * @param tasks task list in command execution
     * @param ui user interface in command execution
     * @param storage storage in command execution
     */
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Tasks task = tasks.checkTask(checkedTaskNo);
        ui.showDoneMessage(task);
    }
}
