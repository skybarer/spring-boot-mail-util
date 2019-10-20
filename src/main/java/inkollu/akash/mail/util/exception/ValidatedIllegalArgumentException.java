package inkollu.akash.mail.util.exception;

import org.springframework.validation.BindingResult;

/**
 * @author : akashdhar
 * @date : 20-10-2019
 * @time : 08:21 AM
 */
public class ValidatedIllegalArgumentException extends RuntimeException {

    private final BindingResult bindingResult;

    public ValidatedIllegalArgumentException(BindingResult bindingResult) {
        super();
        this.bindingResult = bindingResult;
    }

    public ValidatedIllegalArgumentException(String message, BindingResult bindingResult) {
        super(message);
        this.bindingResult = bindingResult;
    }

    public ValidatedIllegalArgumentException(String message, Throwable cause, BindingResult bindingResult) {
        super(message, cause);
        this.bindingResult = bindingResult;
    }

    public ValidatedIllegalArgumentException(Throwable cause, BindingResult bindingResult) {
        super(cause);
        this.bindingResult = bindingResult;
    }

    protected ValidatedIllegalArgumentException(
            String message,
            Throwable cause,
            boolean enableSuppression,
            boolean writableStackTrace,
            BindingResult bindingResult
    ) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.bindingResult = bindingResult;
    }


    public BindingResult getBindingResult() {
        return bindingResult;
    }
}
