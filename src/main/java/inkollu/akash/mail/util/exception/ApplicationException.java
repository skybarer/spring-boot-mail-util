package inkollu.akash.mail.util.exception;

import inkollu.akash.mail.util.http.ErrorCode;

/**
 * @author : akashdhar
 * @date : 08-10-2019
 * @time : 07:56 PM
 */
public class ApplicationException extends RuntimeException {
    private ErrorCode errorCode;

    public ApplicationException(String message, ErrorCode errorCode) {
        super("errorCode" + ":" + errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ApplicationException(String message, Throwable cause, ErrorCode errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public ApplicationException(Throwable cause, ErrorCode errorCode) {
        super("Exception:" + cause);
        this.errorCode = errorCode;
    }

    public ApplicationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, ErrorCode errorCode) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
