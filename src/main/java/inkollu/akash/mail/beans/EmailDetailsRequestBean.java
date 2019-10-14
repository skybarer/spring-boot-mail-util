package inkollu.akash.mail.beans;

import lombok.Data;

import java.util.Map;

/**
 * @author : akashdhar
 * @date : 13-10-2019
 * @time : 01:17 PM
 */

@Data
public class EmailDetailsRequestBean extends UserBean {
    private Map<String, String> mailData;
}
