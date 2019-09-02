public class ToDos extends MarkDone {
    public ToDos(String s) {
        super(s);   // invoke immediate parent class constructor (MarkDone)
    }

    public ToDos(String description, boolean isDone) {
        super(description, isDone);
    }

    public String toString() {
        return ("[T]" + super.toString());
    }
}
