import duke.task.Events;

import org.junit.jupiter.api.Test;
import org.w3c.dom.events.Event;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventTest {

    @Test
    public void testStringConvert() {
        assertEquals("[E][✗] study session (at: library)",
                new Events("study session", "library").toString());
        assertEquals("[E][✓] study session (at: library)",
                new Events("study session", true, "library").toString());
    }

    @Test
    public void testGetVenue() {
        assertEquals("tonight",
                new Events("read book", "tonight").getVenue());
        assertEquals("tonight",
                new Events("read book", true, "tonight").getVenue());
    }
}
