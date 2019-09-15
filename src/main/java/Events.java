public class Events extends Tasks {

    String at;

    /**
     * Public constructor, returns uncompleted event with venue
     * @param event, description of the event
     * @param at, venue of event
     */
    public Events(String event, String at) {
        super(event);
        this.at = at; // at
    }

    /**
     * Public constructor, returns completed event with venue
     * @param event, description of the event
     * @param isDone, checks if event has been completed
     * @param at, venue of the event
     */
    public Events(String event, boolean isDone, String at) {
        super(event, isDone);
        this.at = at;
    }

    /**
     * Getter, gets venue of the event
     * @return returns venue of event
     */
    public String getVenue() {
        return at;
    }

    /**
     * @return returns the statement and symbols as shown in Duke's List
     */
    public String toString() {
        return ("[E]" + super.toString() + " (at: " + at + ") ");
    }
}
