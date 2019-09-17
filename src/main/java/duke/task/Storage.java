package duke.task;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class Storage {
    private String filePath;
    public static String DIVIDER = " | ";

    /**
     * Public constructor, returns Save system
     * @param filePath file path to save tasks to
     */
    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Loads task data from file at file path
     * @return list of tasks loaded from duke.txt at filepath
     */
    public List<Tasks> load() throws DukeException {
        List<Tasks> taskList = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = br.readLine()) != null) {
                String[] taskParams = line.split(Storage.DIVIDER);
                Tasks task = Tasks.taskList(taskParams);
                taskList.add(task);
            }
        } catch (IOException ioException) {
            throw new DukeException("File could not be found");
        }
        return taskList;
    }

    /**
     * Saves tasks list to file path
     * @param taskList list of tasks to be saved to duke.txt
     */
    public void saveTasks(List<Tasks> taskList) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Tasks task : taskList) {
                if (task instanceof ToDos) {
                    writer.write("T");
                } else if(task instanceof  Deadlines){
                    writer.write("D");
                } else if(task instanceof Events){
                    writer.write("E");
                }
                writer.write(DIVIDER + task.isitDone() + DIVIDER + task.getDescription());
                if (task instanceof Deadlines) {
                    writer.write(DIVIDER + ((Deadlines) task).getDeadline());
                } else if(task instanceof Events) {
                    writer.write(DIVIDER + ((Events) task).getVenue());
                }
                writer.write("\n");
            }
        } catch (IOException ioException) {

        }
    }
}