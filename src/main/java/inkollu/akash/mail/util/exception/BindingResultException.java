package inkollu.akash.mail.util.exception;

import org.springframework.validation.BindingResult;

/**
 * @author : akashdhar
 * @date : 14-10-2019
 * @time : 07:37 PM
 */

public class BindingResultException extends RuntimeException {
    private BindingResult errors;

    public BindingResultException(BindingResult errors) {
        this.errors = errors;
    }

    public BindingResultException(String message, BindingResult errors) {
        super(message);
        this.errors = errors;
    }

    public BindingResult getErrors() {
        return errors;
    }
}
