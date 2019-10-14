package inkollu.akash.mail.util.http.exception;

import lombok.Data;
import lombok.ToString;
import org.springframework.http.HttpRequest;

/**
 * @author : akashdhar
 * @date : 08-10-2019
 * @time : 08:46 PM
 */

@Data
@ToString
public class NoSuccessResponseException extends Exception {

    private final int responseCode;
    private final String response;
    private final HttpRequest request;


    public NoSuccessResponseException(String message, int responseCode, String response, HttpRequest request) {
        super(message);
        this.responseCode = responseCode;
        this.response = response;
        this.request = request;
    }

}
