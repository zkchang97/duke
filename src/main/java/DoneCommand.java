public class DoneCommand extends Command {
    int checkedTaskNo;

    public DoneCommand(int checkedTaskNo) {
        super(false);
        this.checkedTaskNo = checkedTaskNo;
    }

    public void execute(TaskList tasks, Ui ui, Storage storage) {
        MarkDone task = tasks.markDone(checkedTaskNo);
        ui.showDoneMessage(task);
    }
}
