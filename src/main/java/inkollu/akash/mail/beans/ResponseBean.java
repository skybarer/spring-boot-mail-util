package inkollu.akash.mail.beans;

import lombok.Data;

import java.util.List;

/**
 * @author : akashdhar
 * @date : 13-10-2019
 * @time : 01:00 PM
 */
@Data
public class ResponseBean {
    private String status;
    private String errorMessage;
    private List dataObject;
}
