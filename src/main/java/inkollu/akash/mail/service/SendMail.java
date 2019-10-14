package inkollu.akash.mail.service;

import inkollu.akash.mail.beans.EmailAttachmentFileBean;
import inkollu.akash.mail.beans.EmailRequestBean;
import inkollu.akash.mail.beans.EmailTemplateBean;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : akashdhar
 * @date : 13-10-2019
 * @time : 01:25 PM
 */
@Service("sendMail")
public class SendMail {
    private static final Logger logger = LoggerFactory.getLogger(SendMail.class);

    public void SendEmail(EmailTemplateBean emailBean, EmailRequestBean request, Map<String, String> attachmentsMap) throws Exception {
    }

    private Properties loadProperties(ConcurrentHashMap<String, String> configData) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", false);
        props.put("mail.smtp.starttls.enable", false);
        props.put("mail.smtp.host", configData.get("MAIL_SMTP_HOST"));
        props.put("mail.smtp.port", configData.get("MAIL_SMTP_PORT"));
        return props;
    }

    public void SendEmailWithSMTP(EmailRequestBean request, String smtpHost, String smtpPort) throws Exception {
        logger.info("comes into send email method");

        Properties props = new Properties();
        props.put("mail.smtp.auth", false);
        props.put("mail.smtp.starttls.enable", false);
        props.put("mail.smtp.host", smtpHost);
        props.put("mail.smtp.port", smtpPort);

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("", "");
            }
        });

        MimeMessage message = new MimeMessage(session);
        Multipart multipart = new MimeMultipart();
        BodyPart msgBodyPart = new MimeBodyPart();
        msgBodyPart.setContent(request.getEmailTemplate(), "text/html; charset=utf-8");
        multipart.addBodyPart(msgBodyPart);
        msgBodyPart = new MimeBodyPart();

        List<EmailAttachmentFileBean> attachmentInfo = request.getAttachmentList();
        Map<String, String> attachmentsMap = new HashMap<>();

        if (attachmentInfo != null && !attachmentInfo.isEmpty()) {
            for (EmailAttachmentFileBean fileBean : attachmentInfo) {
                logger.info("FileName : " + fileBean.getAttachmentName());
                logger.info("FilePath : " + fileBean.getFilePath());

                String extension = FilenameUtils.getExtension(fileBean.getFilePath());
                logger.info("FileType : " + extension);
                if (!fileBean.getAttachmentName().contains(".")) {
                    attachmentsMap.put(fileBean.getAttachmentName() + "." + extension, fileBean.getFilePath());
                } else {
                    attachmentsMap.put(fileBean.getAttachmentName(), fileBean.getFilePath());
                }
            }
        }
        if (!attachmentsMap.isEmpty()) {
            for (Map.Entry<String, String> entry : attachmentsMap.entrySet()) {
                addAttachment(multipart, entry);
            }
        }

        String formAddress = request.getFromAddress();
        message.setFrom(new InternetAddress(formAddress));
        String toAddress = request.getToAddress();
        String ccAddress = request.getCcAddress();
        if (toAddress.contains(";")) {
            toAddress = toAddress.replace(";", ",");
        }
        if (ccAddress != null && !ccAddress.equals("")) {
            if (ccAddress.contains(";")) {
                ccAddress = ccAddress.replace(";", ",");
            }
        }
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toAddress));
//        message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(toAddress));
        message.setSubject(request.getEmailSubject());
        message.setContent(multipart, "text/html; charset=utf-8");
        Transport.send(message);
    }

    private void addAttachment(Multipart multipart, Map.Entry<String, String> entry) throws MessagingException {
        DataSource source = new FileDataSource(entry.getValue());
        BodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setDataHandler(new DataHandler(source));
        messageBodyPart.setFileName(entry.getKey());
        multipart.addBodyPart(messageBodyPart);
    }
}
