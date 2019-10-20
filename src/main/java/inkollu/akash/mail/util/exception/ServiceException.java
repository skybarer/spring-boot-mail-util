package inkollu.akash.mail.util.exception;

/**
 * @author : akashdhar
 * @date : 20-10-2019
 * @time : 08:21 AM
 */
public class ServiceException extends RuntimeException {

    public ServiceException () {
        super();
    }

    public ServiceException ( String message ) {
        super( message );
    }

    public ServiceException ( String message, Throwable cause ) {
        super( message, cause );
    }

    public ServiceException ( Throwable cause ) {
        super( cause );
    }

    protected ServiceException ( String message,
                                 Throwable cause,
                                 boolean enableSuppression,
                                 boolean writableStackTrace ) {
        super( message, cause, enableSuppression, writableStackTrace );
    }
}
