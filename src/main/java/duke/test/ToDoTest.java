package duke.test;
import duke.task.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToDoTest {

    @Test
    public void testStringConvert() {
        assertEquals("[T][✗] read book",
                new ToDos("read book").toString());
        assertEquals("[T][✓] read book",
                new ToDos("read book", true).toString());
    }
}