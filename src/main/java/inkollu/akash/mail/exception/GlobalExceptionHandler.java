package inkollu.akash.mail.exception;

import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import inkollu.akash.mail.util.exception.ApplicationException;
import inkollu.akash.mail.util.http.ErrorCode;
import inkollu.akash.mail.util.http.client.HttpResponseBuilder;
import inkollu.akash.mail.util.http.exception.BindingResultException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.xml.bind.ValidationException;

/**
 * @author : akashdhar
 * @date : 13-10-2019
 * @time : 03:26 PM
 */

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler({Throwable.class})
    public ResponseEntity<Object> handleException(Exception e, ServletWebRequest request) {
        ErrorCode error = null;
        String message = "";
        if (e instanceof ApplicationException) {
            error = ((ApplicationException) e).getErrorCode();
        } else if (e instanceof ValidationException
                || e instanceof IllegalStateException
                || e instanceof IllegalArgumentException
                || e instanceof HttpMessageNotReadableException
                || e instanceof MethodArgumentNotValidException
                || e instanceof ServletRequestBindingException
                || e instanceof UnrecognizedPropertyException
        ) {
            message = "Invalid Input";
            error = ErrorCode.BAD_REQUEST;
        } else if (e instanceof BindingResultException) {
            message = ((BindingResultException) e).getErrors().toString();
            error = ErrorCode.BAD_REQUEST;
        } else {
            message = "Exception Occurred";
            error = ErrorCode.SERVER_ERROR;
        }
        logger.error("Session Exception : " + message, e);
        return HttpResponseBuilder.buildResponse(error, e);
    }
}
