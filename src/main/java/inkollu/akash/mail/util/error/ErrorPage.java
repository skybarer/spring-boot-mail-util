package inkollu.akash.mail.util.error;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.http.HttpStatus;

/**
 * @author : akashdhar
 * @date : 20-10-2019
 * @time : 11:53 AM
 */
public class CustomErrorPage implements ErrorPageRegistrar {
    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        registry.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404.html"));
        registry.addErrorPages(new ErrorPage(HttpStatus.UNAUTHORIZED, "/401.html"));
        registry.addErrorPages(new ErrorPage(Throwable.class, "/500.html"));
    }
}
