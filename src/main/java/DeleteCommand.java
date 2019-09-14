public class DeleteCommand extends Command {
    int removeTaskNo;

    public DeleteCommand(int removeTaskNo) {
        super(false);
        this.removeTaskNo = removeTaskNo;
    }

    public void execute(TaskList tasks, Ui ui, Storage storage) {
        MarkDone task = tasks.removeTask(removeTaskNo);
        ui.showDeleteMessage(task, tasks);
    }
}
