import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class Storage {
    private String filePath;
    public static String DIVIDER = " | ";

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public List<MarkDone> load() throws DukeException {
        List<MarkDone> taskList = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = br.readLine()) != null) {
                String[] taskParams = line.split(Storage.DIVIDER);
                MarkDone task = MarkDone.taskList(taskParams);
                taskList.add(task);
            }
        } catch (IOException ioException) {
            throw new DukeException();
        }
        return taskList;
    }

    public void saveTasks(List<MarkDone> taskList) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (MarkDone task : taskList) {
                if (task instanceof ToDos) {
                    writer.write("T");
                } else if(task instanceof  Deadlines){
                    writer.write("D");
                } else if(task instanceof  Events){
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