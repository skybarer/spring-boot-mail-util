package inkollu.akash.mail.util.http.client;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author : akashdhar
 * @date : 08-10-2019
 * @time : 08:20 PM
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
public class HttpResponse {
    private ResponseHeader header;
    private Object body;
    private String cause;

    public HttpResponse(ResponseHeader header, Object body) {
        this.header = header;
        this.body = body;
    }
}
