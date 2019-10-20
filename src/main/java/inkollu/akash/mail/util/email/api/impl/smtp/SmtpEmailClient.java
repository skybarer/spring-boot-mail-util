package inkollu.akash.mail.util.email.api.impl.smtp;

import inkollu.akash.mail.util.email.api.EmailClient;
import inkollu.akash.mail.util.email.api.model.Email;
import inkollu.akash.mail.util.email.api.model.EmailAttachment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author : akashdhar
 * @date : 14-10-2019
 * @time : 07:56 PM
 */

public class SmtpEmailClient implements EmailClient {
    private static final Logger logger = LoggerFactory.getLogger(SmtpEmailClient.class);

    @Override
    public void send(Email email, List<EmailAttachment> emailAttachment) {

    }
}
