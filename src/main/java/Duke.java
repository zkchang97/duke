import duke.command.Command;
import duke.command.Parser;
import duke.task.DukeException;
import duke.task.Storage;
import duke.task.TaskList;
import duke.task.Ui;

public class Duke {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    /**
     * Public constructor, returns Duke with a storage filepath for saving.
     * @param filePath file path to store the task data after "bye" command.
     */
    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (DukeException e) {
            ui.showLoadError();
            tasks = new TaskList();
        }
    }

    /**
     * Initiates Duke system, parses commands to update list.
     */
    public void run() {
        ui.showWelcomeMessage();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine();
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
            } catch (DukeException e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
    }

    /**
     * Main class, initiates and drives Duke with .run().
     * @param args received from command line.
     */
    public static void main(String[] args) {
        String filePath = "C:\\Users\\chang\\Desktop\\cs2113\\duke\\src\\main\\java\\duke.txt";
        new Duke(filePath).run();
    }
}