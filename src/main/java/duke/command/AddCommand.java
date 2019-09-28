package duke.command;

import duke.task.Storage;
import duke.task.TaskList;
import duke.task.Tasks;
import duke.task.Ui;

public class AddCommand extends Command {
    String description;
    String type;

    /**
     * Public constructor, adds a reminder when executed.
     * @param description description of the task.
     * @param type type of the task.
     */
    public AddCommand(String description, String type) {
        super(false);
        this.description = description;
        this.type = type;
    }

    /**
     * Public constructor, adds a To Dgo reminder when executed.
     * @param description description of the task.
     */
    public AddCommand(String description) {
        super(false);
        this.description = description;
    }

    /**
     * Public constructor, executes the command the add the task to the system.
     * @param tasks task list in command execution.
     * @param ui user interface in command execution.
     * @param storage storage in command execution.
     */
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Tasks task;
        if (type != null) {
            task = tasks.addTask(description, type);
        } else {
            task = tasks.addTask(description);
        }
        ui.showAddMessage(task, tasks);
    }
}
