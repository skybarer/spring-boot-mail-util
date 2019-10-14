package inkollu.akash.mail.util.email.api.model;

import lombok.Data;

import java.util.List;

/**
 * @author : akashdhar
 * @date : 14-10-2019
 * @time : 07:47 PM
 */

@Data
public class Email {
    private String from;
    private List<String> to;
    private List<String> cc;
    private List<String> bcc;
    private String body;
    private String subject;
}
