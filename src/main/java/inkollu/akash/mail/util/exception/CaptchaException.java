package inkollu.akash.mail.util.exception;

/**
 * @author : akashdhar
 * @date : 20-10-2019
 * @time : 08:20 AM
 */
public class CaptchaException extends RuntimeException {
    public CaptchaException () {
        super();
    }

    public CaptchaException ( String message ) {
        super( message );
    }

    public CaptchaException ( String message, Throwable cause ) {
        super( message, cause );
    }

    public CaptchaException ( Throwable cause ) {
        super( cause );
    }

    protected CaptchaException ( String message,
                                 Throwable cause,
                                 boolean enableSuppression,
                                 boolean writableStackTrace ) {
        super( message, cause, enableSuppression, writableStackTrace );
    }
}
