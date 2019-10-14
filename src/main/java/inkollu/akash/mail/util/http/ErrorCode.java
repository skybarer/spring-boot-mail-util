package inkollu.akash.mail.util.http;

import org.springframework.http.HttpStatus;

/**
 * @author : akashdhar
 * @date : 08-10-2019
 * @time : 07:23 PM
 */
public enum ErrorCode {

    UNAUTHORIZED("Authentication token missing", HttpStatus.UNAUTHORIZED.value()),
    BAD_REQUEST("Invalid input", HttpStatus.BAD_REQUEST.value()),
    SERVER_ERROR("Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value()),
    FORBIDDEN("Invalid Token", HttpStatus.FORBIDDEN.value()),
    SUCCESS(null),
    ACCESS_DENIED("AccessDenied"),
    INAPPROPRIATE_JSON("InappropriateJSON"),
    INTERNAL_ERROR("InternalError"),
    INVALID_ACCESS_KEY_ID("InvalidAccessKeyId"),
    INVALID_HTTP_AUTH_HEADER("InvalidHTTPAuthHeader"),
    INVALID_HTTP_REQUEST("InvalidHTTPRequest"),
    INVALID_URI("InvalidURI"),
    MALFORMED_JSON("MalformedJSON"),
    INVALID_VERSION("InvalidVersion"),
    OPT_IN_REQUIRED("OptInRequired"),
    PRECONDITION_FAILED("PreconditionFailed"),
    REQUEST_EXPIRED("RequestExpired"),
    SIGNATURE_DOES_NOT_MATCH("SignatureDoesNotMatch");


    private final int httpStatus;
    private String message;

    ErrorCode(String message) {
        this.message = message;
        this.httpStatus = HttpStatus.OK.value();
    }

    ErrorCode(String message, int httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage() {
        this.message = message;
    }

    public int getHttpStatus() {
        return httpStatus;
    }


}
