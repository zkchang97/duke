public class ToDos extends MarkDone {
    public ToDos(String s) {
        super(s);   // invoke immediate parent class constructor (MarkDone)
    }

    public String toString() {
        return ("[T]" + super.toString());
    }
}
