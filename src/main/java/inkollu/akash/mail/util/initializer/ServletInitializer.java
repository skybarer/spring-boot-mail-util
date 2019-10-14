package inkollu.akash.mail.util.initializer;

import inkollu.akash.mail.SpringBootMailUtilApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author : akashdhar
 * @date : 14-10-2019
 * @time : 07:41 PM
 */

public class ServletInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
        return applicationBuilder.sources(SpringBootMailUtilApplication.class);
    }
}
