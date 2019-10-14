package inkollu.akash.mail.util.http.client;

import lombok.Data;

import java.util.Map;

/**
 * @author : akashdhar
 * @date : 08-10-2019
 * @time : 08:51 PM
 */

@Data
public class HttpRequest {
    private String method;
    private String url;
    private long connectionTimeout;
    private long readTimeout;
    private byte[] requestBody;
    private Map<String, String> requestParameters;
    private Map<String, String> headers;
}
