package inkollu.akash.mail.beans;

import lombok.Data;

import java.io.Serializable;

/**
 * @author : akashdhar
 * @date : 13-10-2019
 * @time : 01:18 PM
 */

@Data
public class EmailAttachmentFileBean extends ResponseBean {
    private int id;
    private String attachmentName;
    private double fileSize;
    private String filePath;
    private int isSystemFile;
    private int isDeleted;
    private String emailRef;
    private String wfRef;
    private String groupId;
}
