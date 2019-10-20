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
    public static final String NUMBER = "^(-?[1-9]\\d*\\.?\\d*)|(-?0\\.\\d*[1-9])|(-?[0])|(-?[0]\\.\\d*)$";
    public static final String SQUARE_ROOT_IN_NUMBER = "(^\\d+(.[0-9]*)?[0-9]$)|(^\\d+(.[0-9]*)?[1-9]$)|^\\d$";
    public static final String AGE = "^(?:[1-9][0-9]?|1[01][0-9]|120)$";
    public static final String EMAIL1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
    public static final String CHINESE = "^[\u4e00-\u9fa5],{0,}$";
    public static final String PAD_TERMINAL_REGEX = "\\b(ipad|tablet|(Nexus 7)|up.browser" + "|[1-4][0-9]{2}x[1-4][0-9]{2})\\b";
    public static final String PHONE_TERMINAL_REGEX = "\\b(ip(hone|od)|android|opera m(ob|in)i"
            + "|windows (phone|ce)|blackberry"
            + "|s(ymbian|eries60|amsung)|p(laybook|alm|rofile/midp"
            + "|laystation portable)|nokia|fennec|htc[-_]"
            + "|mobile|up.browser|[1-4][0-9]{2}x[1-4][0-9]{2})\\b";
    /**
     * 2016-12-19 15:59:45
     */
    private static final String DATE_YYYY_MM_DD_HH_MM_SS = "(((19|20)[0-9]{2})-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01]) ([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9])";
    /**
     * 2016-12-19
     */
    private static final String DATE_YYYY_MM_DD = "(((19|20)[0-9]{2})-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01]))";
    /**
     * 2016/12/19 15:59:45
     */
    private static final String DATE_YYYY_MM_DD_HH_MM_SS_2 = "(((19|20)[0-9]{2})/(0?[1-9]|1[012])/(0?[1-9]|[12][0-9]|3[01]) ([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9])";
    /**
     * 20161219155945
     */
    private static final String DATE_YYYY_MM_DD_HH_MM_SS_3 = "(((19|20)[0-9]{2})(0?[1-9]|1[012])(0?[1-9]|[12][0-9]|3[01])([01]?[0-9]|2[0-3])[0-5][0-9][0-5][0-9])";
    /**
     * 2016/12/19
     */
    private static final String DATE_YYYY_MM_2 = "(((19|20)[0-9]{2})/(0?[1-9]|1[012])/(0?[1-9]|[12][0-9]|3[01]))";
    /**
     * 20161219
     */
    private static final String DATE_YYYY_MM_3 = "(((19|20)[0-9]{2})(0?[1-9]|1[012])(0?[1-9]|[12][0-9]|3[01]))";
    /**
     * 基本日期
     * <p>yyyy-MM-dd</p>
     * <p>yyyy-MM-dd hh:mm:ss</p>
     * <p>yyyy/MM/dd</p>
     * <p>yyyy/MM/dd hh:mm:ss</p>
     * <p>yyyyMMdd</p>
     * <p>yyyyMMddhh:mm:ss</p>
     */
    public static final String DATE_BASIC = DATE_YYYY_MM_DD_HH_MM_SS + "|" +
            DATE_YYYY_MM_DD + "|" +
            DATE_YYYY_MM_DD_HH_MM_SS_2 + "|" +
            DATE_YYYY_MM_2 + "|" +
            DATE_YYYY_MM_DD_HH_MM_SS_3 + "|" +
            DATE_YYYY_MM_3;
}
