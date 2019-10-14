package inkollu.akash.mail.util.session;

import inkollu.akash.mail.util.lang.Language;
import lombok.Data;

/**
 * @author : akashdhar
 * @date : 13-10-2019
 * @time : 04:34 PM
 */

@Data
public class Session {
    private static ThreadLocal<Long> idLocal = new ThreadLocal<>();
    private static ThreadLocal<String> refIdLocal = new ThreadLocal<>();
    private static ThreadLocal<String> languageLocal = new ThreadLocal<>();
    private static ThreadLocal<String> fileUploadCountLocal = new ThreadLocal<>();

    {
        setLang(Language.ENGLISH.getLanguageCode());
    }

    public static Long getId() {
        return idLocal.get();
    }

    public static void setId(Long value) {
        idLocal.set(value);
    }

    public static String getLang() {
        return languageLocal.get();
    }

    public static void setLang(String value) {
        languageLocal.set(value);
    }

    public static String getCustomerRefId() {
        return refIdLocal.get();
    }

    public static void setCustomerRefId(String value) {
        refIdLocal.set(value);
    }


}
