public class MarkDone {
    protected boolean isDone;
    protected String statement;

    public MarkDone(String s) {
        this.statement = s;
        this.isDone = false;
    }

    public String markTask() {
        if (isDone) {
            return "✓";    // tick
        } else {
            return "✗";    // cross
        }
    }

    public void markedasDone() {
        this.isDone = true;
    }

    public String printStatement() {
        return "[" + markTask() + "]" + statement;
    }
}
