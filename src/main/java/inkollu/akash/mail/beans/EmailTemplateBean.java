package inkollu.akash.mail.beans;

import lombok.Data;

/**
 * @author : akashdhar
 * @date : 13-10-2019
 * @time : 01:05 PM
 */
@Data
public class EmailTemplateBean {
    private int id;
    private String productType;
    private String entity;
    private String templateId;
    private String templatePath;
    private String hyperlink;
    private String emailTemplate;
    private String limitCheck;
    private String imexRegNo;
    private String customerName;
    private String goodDescription;
    private String currency;

}
