package inkollu.akash.mail.util.env;

import org.springframework.context.annotation.Configuration;

/**
 * @author : akashdhar
 * @date : 14-10-2019
 * @time : 07:58 PM
 */

@Configuration
public class SystemEnvironment {

    public void setProperties() {
        if(isPropertyConfigEnabled()) {
            System.setProperty("file.encoding", "UTF-8");
        }
    }

    private boolean isPropertyConfigEnabled() {
        return true;
    }

    public void clearProperties(){
        System.clearProperty("file.encoding");
    }
}
