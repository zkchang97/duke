public class ListCommand extends Command {

    /**
     * Public constructor, lists all tasks in Duke
     */
    public ListCommand() {
        super(false);
    }

    /**
     * Executes command to list all tasks in the system
     * @param tasks task list in command execution
     * @param ui user interface in command execution
     * @param storage storage in command execution
     */
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showTaskList(tasks.getTaskList());
    }
}
