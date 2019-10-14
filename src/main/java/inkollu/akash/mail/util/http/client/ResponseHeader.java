package inkollu.akash.mail.util.http.client;

import com.fasterxml.jackson.annotation.JsonInclude;
import inkollu.akash.mail.util.http.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author : akashdhar
 * @date : 08-10-2019
 * @time : 08:22 PM
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
public class ResponseHeader {
    private String status;
    private String description;

    public ResponseHeader(ErrorCode code) {
        this.status = code.name();
        this.description = code.getMessage();
    }
}
