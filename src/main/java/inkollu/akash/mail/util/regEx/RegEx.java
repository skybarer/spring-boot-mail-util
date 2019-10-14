package inkollu.akash.mail.util.regEx;

/**
 * @author : akashdhar
 * @date : 08-10-2019
 * @time : 09:22 PM
 */


public class RegEx {
    // REFER: https://en.wikipedia.org/wiki/Regular_expression
    public static final String EMAIL = "^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$";
    public static final String TELEPHONE = "^(([+]{1}[0-9]{2}|0)[0-9]{9})$";
    public static final String ALPHA = "[A-Za-z]";
    public static final String UPPERCASE = "[A-Z]";
    public static final String LOWERCASE = "[a-z]";
    public static final String NUMERIC = "^[0-9]*$";
    public static final String ALPHA_NUMERIC = "[A-Za-z0-9]";
    public static final String PAN = "^([a-zA-Z]){5}([0-9]){4}([a-zA-Z]){1}?$";
    public static final String PATH = "^([A-Za-z]:|[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*)((/[A-Za-z0-9_.-]+)+)$";
    public static final String HTML_TAG = "<\\s*a[^>]*>(.*?)<\\s*/\\s*a>";
    public static final String FILE_NAME = "^([a-zA-Z0-9-_ ]{2,30})\\.(3gp|avi|mp4)+$";
    public static final String IP_ADDRESS_V4 = "^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$";
    public static final String IP_ADDRESS_V6 = "(([0-9a-fA-F]{1,4}:){7,7}[0-9a-fA-F]{1,4}|([0-9a-fA-F]{1,4}:){1,7}:|([0-9a-fA-F]{1,4}:){1,6}:[0-9a-fA-F]{1,4}|([0-9a-fA-F]{1,4}:){1,5}(:[0-9a-fA-F]{1,4}){1,2}|([0-9a-fA-F]{1,4}:){1,4}(:[0-9a-fA-F]{1,4}){1,3}|([0-9a-fA-F]{1,4}:){1,3}(:[0-9a-fA-F]{1,4}){1,4}|([0-9a-fA-F]{1,4}:){1,2}(:[0-9a-fA-F]{1,4}){1,5}|[0-9a-fA-F]{1,4}:((:[0-9a-fA-F]{1,4}){1,6})|:((:[0-9a-fA-F]{1,4}){1,7}|:)|fe80:(:[0-9a-fA-F]{0,4}){0,4}%[0-9a-zA-Z]{1,}|::(ffff(:0{1,4}){0,1}:){0,1}((25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])\\.){3,3}(25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])|([0-9a-fA-F]{1,4}:){1,4}:((25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])\\.){3,3}(25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9]))";
}
