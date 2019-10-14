package inkollu.akash.mail.util.email.api;

import inkollu.akash.mail.util.email.api.model.Email;
import inkollu.akash.mail.util.email.api.model.EmailAttachment;

import java.util.List;

/**
 * @author : akashdhar
 * @date : 14-10-2019
 * @time : 07:50 PM
 */

public interface EmailClient {
    void send(Email email, List<EmailAttachment> emailAttachment);
}
