package wanted.preonboarding.backend.common.exception;

public class BusinessExceeption extends RuntimeException {

    public BusinessExceeption() {
    }

    public BusinessExceeption(String message) {
        super(message);
    }

    public BusinessExceeption(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessExceeption(Throwable cause) {
        super(cause);
    }

    public BusinessExceeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
