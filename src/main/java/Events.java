public class Events extends MarkDone{

    String place;
    public Events(String event, String place) {
        super(event);
        this.place = place; // at
    }

    public String toString() {
        return ("[E]" + super.toString() + " (at: " + place + ") ");
    }
}
