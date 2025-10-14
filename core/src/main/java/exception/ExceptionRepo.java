package exception;

public class ExceptionRepo extends RuntimeException {
    public ExceptionRepo(String message) {
        super(message);
    }
}
