package inkollu.akash.mail.util.email.api.model;

import lombok.Data;
import lombok.ToString;

/**
 * @author : akashdhar
 * @date : 14-10-2019
 * @time : 07:49 PM
 */

@Data
@ToString
public class EmailAttachment {
    private String fileNameWithExtension;
    private String fileAbsolutePath;
}
