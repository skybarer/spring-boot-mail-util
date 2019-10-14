package inkollu.akash.mail.util.masking;

/**
 * @author : akashdhar
 * @date : 13-10-2019
 * @time : 04:21 PM
 */
public class MobileNumberMasker {

    public static String maskMobile(String mobileNumber) {
        if (mobileNumber != null && !mobileNumber.isEmpty()) {
            StringBuilder mobNum = new StringBuilder(mobileNumber.replaceAll("[0-9]", "X"));
            int maskLen = mobileNumber.length() - 4;
            mobNum.replace(maskLen, mobileNumber.length(), mobileNumber.substring(maskLen));
            mobileNumber = mobNum.toString();
        }
        return mobileNumber;
    }

    public static String maskCCNumber(String ccNum) {
        int total = ccNum.length();
        int startLen = 4, endLen = 4;
        int maskLen = total - (startLen + endLen);
        StringBuffer maskedBuff = new StringBuffer(ccNum.substring(0, startLen));
        for (int i = 0; i < maskLen; i++) {
            maskedBuff.append('X');
        }
        maskedBuff.append(ccNum.substring(startLen + maskLen, total));
        String masked = maskedBuff.toString();
        return masked;
    }

    public static String maskCardNumber(String cardNumber, String mask) {
        int index = 0;
        StringBuilder maskedNumber = new StringBuilder();
        for (int i = 0; i < mask.length(); i++) {
            char c = mask.charAt(i);
            if (c == '#') {
                maskedNumber.append(cardNumber.charAt(index));
                index++;
            } else if (c == 'x') {
                maskedNumber.append(c);
                index++;
            } else {
                maskedNumber.append(c);
            }
        }
        return maskedNumber.toString();
    }

    public static String maskThreeFourth(String input) {
        int length = input.length() - input.length() / 4;
        String s = input.substring(0, length);
        return s.replaceAll("[A-Za-z0-9]", "X") + input.substring(length);
    }
}
