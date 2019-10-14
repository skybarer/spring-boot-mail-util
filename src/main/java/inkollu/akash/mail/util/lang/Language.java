package inkollu.akash.mail.util.lang;

/**
 * @author : akashdhar
 * @date : 13-10-2019
 * @time : 04:37 PM
 */
public enum Language {

    ENGLISH("en"),
    CHINESE("zh-hans");

    private String languageCode;

    Language(String languageCode) {
        this.languageCode = languageCode;
    }

    public String getLanguageCode() {
        return languageCode;
    }
}
