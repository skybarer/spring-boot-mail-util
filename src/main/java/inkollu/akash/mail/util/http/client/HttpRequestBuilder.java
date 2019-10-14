package inkollu.akash.mail.util.http.client;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : akashdhar
 * @date : 08-10-2019
 * @time : 08:56 PM
 */
public class HttpRequestBuilder {

    private HttpRequest request;

    private HttpRequestBuilder() {
        request = new HttpRequest();
        request.setHeaders(new HashMap<>());
        request.setRequestParameters(new HashMap<>());
        request.setConnectionTimeout(1000 * 60);
        request.getHeaders().put("User-Agent", "HttpRequest");
        request.getHeaders().put("Accept-Language", "en-US,en;q=0.5");
        request.getHeaders().put("Content-Type", "application/json");
    }

    public static HttpRequestBuilder newInstance() {
        return new HttpRequestBuilder();
    }

    public HttpRequestBuilder url(String url) {
        request.setUrl(url);
        return this;
    }

    public HttpRequestBuilder header(String name, String value) {
        request.getHeaders().put(name, value);
        return this;
    }

    public HttpRequestBuilder parameter(String name, String value) {
        request.getRequestParameters().put(name, value);
        return this;
    }

    public HttpRequestBuilder method(String method) {
        request.setMethod(method);
        return this;
    }

    public HttpRequestBuilder connectionTimeout(long timeout) {
        request.setConnectionTimeout(timeout);
        return this;
    }

    public HttpRequestBuilder readTimeout(long timeout) {
        request.setReadTimeout(timeout);
        return this;
    }

    public HttpRequestBuilder headers(Map<String, String> headers) {
        request.getHeaders().putAll(headers);
        return this;
    }

    public HttpRequestBuilder body(byte[] body) {
        request.setRequestBody(body);
        return this;
    }

    public HttpRequest build() {
        return request;
    }

}
