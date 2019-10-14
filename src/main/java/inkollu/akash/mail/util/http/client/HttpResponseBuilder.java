package inkollu.akash.mail.util.http.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import inkollu.akash.mail.util.http.ErrorCode;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

/**
 * @author : akashdhar
 * @date : 08-10-2019
 * @time : 07:08 PM
 */

@Data
public class HttpResponseBuilder {
    public static final Logger logger = LoggerFactory.getLogger(HttpResponseBuilder.class.getName());
    public static final String MIME_JSON_UTF = "application/json; charset=utf-8";

    public static HttpResponse success() {
        return error(ErrorCode.SUCCESS);
    }

    public static HttpResponse success(Object responseObj) {
        return build(ErrorCode.SUCCESS, responseObj);
    }

    public static HttpResponse error() {
        return build(ErrorCode.SUCCESS, null);
    }

    public static HttpResponse error(ErrorCode errorCode) {
        return build(ErrorCode.SUCCESS, null);
    }

    public static HttpResponse error(ErrorCode errorCode, Object object) {
        return build(errorCode, object);
    }

    public static void error(HttpServletResponse response, ErrorCode errorCode) {
        sendResponse(response, errorCode, null);
    }

    private static void sendResponse(HttpServletResponse response, ErrorCode errorCode, Object responseObj) {
        try {
            HttpResponse res = build(errorCode, responseObj);
            ServletOutputStream out = response.getOutputStream();
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(out, StandardCharsets.UTF_8));
            ObjectMapper objectMapper = new ObjectMapper();
            response.setContentType(MIME_JSON_UTF);
            writer.write(objectMapper.writeValueAsString(res));
            writer.flush();
        } catch (IOException e) {
            logger.error("Failed to flush the response", e);
        }
    }

    public static HttpResponse build(ErrorCode error, Object responseObj) {
        ResponseHeader header = new ResponseHeader(error);
        HttpResponse res = new HttpResponse(header, responseObj);
        res.setBody(responseObj);
        return res;
    }

    public static ResponseEntity<Object> buildResponse(ErrorCode serverError, String message) {
        HttpResponse response = HttpResponseBuilder.error(serverError);
        response.setBody(message);
        return new ResponseEntity<>(response, new HttpHeaders(), HttpStatus.valueOf(response.getHeader().getStatus()));
    }

    public static ResponseEntity<Object> buildResponse(ErrorCode serverError, Exception e) {
        HttpResponse response = HttpResponseBuilder.error(serverError);
        // TODO stack trace need to enabled from database config
        // if(App.config.getBoolean(ConfigKey.STACKTRACE_ENABLED, false)
        if (true) {
            response.setCause(getStackTrace(e));
        }
        return new ResponseEntity<>(response, new HttpHeaders(), HttpStatus.valueOf(response.getHeader().getStatus()));
    }

    private static String getStackTrace(Exception e) {
        StringWriter stringWriter = new StringWriter();
        e.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static ResponseEntity<Object> buildResponse(ErrorCode serverError) {
        return buildResponse(serverError, (String) null);
    }

    public static ResponseEntity<Object> buildResponse(BindingResult bindingResult) {
        HttpResponse response = error(ErrorCode.BAD_REQUEST);
        return new ResponseEntity<>(response, new HttpHeaders(), HttpStatus.valueOf(response.getHeader().getStatus()));
    }

}
