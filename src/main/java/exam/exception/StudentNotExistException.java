package exam.exception;

/**
 * Created by Administrator on 2016/8/21.
 */
public class StudentNotExistException extends Exception {

    public StudentNotExistException() {
    }

    public StudentNotExistException(String message) {
        super(message);
    }

    public StudentNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentNotExistException(Throwable cause) {
        super(cause);
    }

    public StudentNotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
