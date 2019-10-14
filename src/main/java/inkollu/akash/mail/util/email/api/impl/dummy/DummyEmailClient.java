package inkollu.akash.mail.util.email.api.impl.dummy;

import inkollu.akash.mail.util.email.api.EmailClient;
import inkollu.akash.mail.util.email.api.model.Email;
import inkollu.akash.mail.util.email.api.model.EmailAttachment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author : akashdhar
 * @date : 14-10-2019
 * @time : 07:53 PM
 */
public class DummyEmailClient implements EmailClient {
    private static final Logger logger = LoggerFactory.getLogger(DummyEmailClient.class);

    @Override
    public void send(Email email, List<EmailAttachment> emailAttachment) {
        logger.error("Sending dummy email: {}", email);
    }
}
