public class Events extends MarkDone{

    String at;
    public Events(String event, String at) {
        super(event);
        this.at = at; // at
    }

    public Events(String event, boolean isDone, String at) {
        super(event, isDone);
        this.at = at;
    }

    public String getVenue() {
        return at;
    }

    public String toString() {
        return ("[E]" + super.toString() + " (at: " + at + ") ");
    }
}
