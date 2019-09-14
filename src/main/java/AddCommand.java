public class AddCommand extends Command {
    String description;
    String type;

    public AddCommand(String description, String type) {
        super(false);
        this.description = description;
        this.type = type;
    }

    public AddCommand(String description) {
        super(false);
        this.description = description;
    }

    public void execute(TaskList tasks, Ui ui, Storage storage) {
        MarkDone task;
        if (type != null) {
            task = tasks.addTask(description, type);
        } else {
            task = tasks.addTask(description);
        }
        ui.showAddMessage(task, tasks);
    }
}
