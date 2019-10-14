package inkollu.akash.mail.util.http.exception;

import org.springframework.validation.BindingResult;

/**
 * @author : akashdhar
 * @date : 13-10-2019
 * @time : 04:11 PM
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
