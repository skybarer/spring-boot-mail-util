package inkollu.akash.mail.beans;

import lombok.Data;

import java.util.List;

/**
 * @author : akashdhar
 * @date : 13-10-2019
 * @time : 01:08 PM
 */

@Data
public class EmailRequestBean {
    private String wfRefNo;
    private String toAddress;
    private String fromAddress;
    private String ccAddress;
    private String entity;
    private String productType;
    private String uniqueIdentifier;
    private String settlementAmount;
    private String emailTemplate;
    private String emailTemplateId;
    private String emailSubject;
    private String productCode;
    private String facilityCode;
    private String userComments;
    private String description;
    private String templateId;
    private String username;
    private String transactionId;
    private String comment;
    private List<EmailExceptionBean> emailDetails;
    private List<EmailAttachmentFileBean> attachmentList;
}
