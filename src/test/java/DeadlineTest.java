import duke.task.Deadlines;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeadlineTest {

    @Test
    public void testStringConvert() {
        assertEquals("[D][✗] read book (by: Monday)",
                new Deadlines("read book", "Monday").toString());
        assertEquals("[D][✓] read book (by: Monday)",
                new Deadlines("read book", true, "Monday").toString());
    }

    @Test
    public void testGetDeadline() {
        assertEquals("Sunday",
                new Deadlines("read book", "Sunday").getDeadline());
        assertEquals("Tuesday",
                new Deadlines("read book", true, "Tuesday").getDeadline());
    }
}