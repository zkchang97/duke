package duke.command;

import duke.task.Storage;
import duke.task.TaskList;
import duke.task.Ui;

public class FindCommand extends Command {

    String substring;

    /**
     * Public constructor, returns command to find task with description using String substring.
     * @param substring substring to be searched.
     */
    public FindCommand(String substring) {
        super(false);
        this.substring = substring;
    }

    /**
     * Prints list of tasks containing substring.
     * @param tasks task list in command execution.
     * @param ui user interface in command execution.
     * @param storage storage in command execution.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showTaskList(tasks.findTask(substring));
    }
}
