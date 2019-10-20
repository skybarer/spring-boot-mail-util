package inkollu.akash.mail.util.json;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;

/*
 * @author : akashdhar
 * @date : 20-10-2019
 * @time : 11:24 AM
 */


public class JsonUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final ObjectWriter writer = objectMapper.writer();

    private static final ObjectWriter prettyWriter = objectMapper.writerWithDefaultPrettyPrinter();

    static {
        objectMapper.findAndRegisterModules();
        objectMapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }

    public static String toJsonPrettyString(Object value) {
        try {
            return prettyWriter.writeValueAsString(value);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static String toJsonWithViewPrettyString(Object value, Class<?> jsonViewClass) {
        try {
            return prettyWriter.withView(jsonViewClass).writeValueAsString(value);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static byte[] toJsonWithViewBytes(Object value, Class<?> jsonViewClass) {
        try {
            return writer.withView(jsonViewClass).writeValueAsBytes(value);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static String toJsonString(Object value) {
        try {
            return writer.writeValueAsString(value);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    /**
     * Returns the deserialize object from the given json string and target
     * class; or null if the given json string is null.
     */
    public static <T> T fromJsonString(String json, Class<T> clazz) {
        if (json == null)
            return null;
        try {
            return objectMapper.readValue(json, clazz);
        } catch (Exception e) {
            throw new IllegalArgumentException("Unable to parse Json String.", e);
        }
    }

    public static <T> T fromJsonStream(InputStream json, Class<T> clazz) {
        if (json == null)
            return null;
        try {
            return objectMapper.readValue(json, clazz);
        } catch (Exception e) {
            throw new IllegalArgumentException("Unable to parse Json String.", e);
        }
    }

    public static <T> T fromJsonBytes(byte[] json, Class<T> clazz) {
        if (json == null)
            return null;
        try {
            return objectMapper.readValue(json, clazz);
        } catch (Exception e) {
            throw new IllegalArgumentException("Unable to parse Json String.", e);
        }
    }

    public static JsonNode jsonNodeOf(String json) {
        return fromJsonString(json, JsonNode.class);
    }

    public static JsonGenerator jsonGeneratorOf(Writer writer) throws IOException {
        return new JsonFactory().createGenerator(writer);
    }

    public static <T> T loadFrom(File file, Class<T> clazz) throws IOException {
        try {
            return objectMapper.readValue(file, clazz);
        } catch (IOException e) {
            throw e;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public static void toJsonFile(String fileName, Object value) {
        try {
            prettyWriter.writeValue(new File(fileName), value);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public static ObjectWriter getWriter() {
        return writer;
    }

    public static ObjectWriter getPrettyWriter() {
        return prettyWriter;
    }

}