package duke.task;

public class DukeException extends Exception {

    /**
     * Public constructor, returns a Duke exception message
     * @param msg error message
     */
    public DukeException(String msg)  {
        super(msg);
    }

    /**
     * Public constructor, returns Duke exception
     */
    public DukeException() {
        super();
    }
}

