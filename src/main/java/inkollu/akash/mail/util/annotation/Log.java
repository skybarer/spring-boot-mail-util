package inkollu.akash.mail.util.annotation;

import lombok.Getter;

import java.lang.annotation.*;

/**
 * @author : akashdhar
 * @date : 20-10-2019
 * @time : 08:25 AM
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {

    boolean warn() default false;


    String description() default "";

    NoticeType noticeType() default NoticeType.MAIL;

    @Getter
    enum NoticeType {
        SMS("SMS", "SMS notification"),
        MAIL("MAIL", "Mailbox notification");

        private String value;
        private String comment;

        NoticeType(String value, String comment) {
            this.value = value;
            this.comment = comment;
        }
    }

}
