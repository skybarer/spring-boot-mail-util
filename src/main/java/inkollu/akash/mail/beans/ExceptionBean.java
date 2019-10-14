package inkollu.akash.mail.beans;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author : akashdhar
 * @date : 13-10-2019
 * @time : 01:02 PM
 */

@Data
public class ExceptionBean {
    private String initiatedBy;
    private Timestamp initiatedOn;
    private String status;
    private String action;
    private String remarks;
    private String actionBy;
    private Timestamp actionDate;
    private String exceptionType;
}
