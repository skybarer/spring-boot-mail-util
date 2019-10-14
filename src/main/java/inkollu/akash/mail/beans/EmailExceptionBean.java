package inkollu.akash.mail.beans;

import lombok.Data;

import java.io.Serializable;

/**
 * @author : akashdhar
 * @date : 13-10-2019
 * @time : 01:14 PM
 */

@Data
public class EmailExceptionBean {
    private String id;
    private String checkName;
    private String remarks;
    private String status;
    private String executedBy;
    private String checkCode;
}
