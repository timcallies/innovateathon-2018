public class InvalidWeightException extends Exception {

    /**
     * Creates a new instance of <code>InvalidWeightException</code> without
     * detail message.
     */
    public InvalidWeightException() {
    }

    /**
     * Constructs an instance of <code>InvalidWeightException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public InvalidWeightException(String msg) {
        super(msg);
    }
}
