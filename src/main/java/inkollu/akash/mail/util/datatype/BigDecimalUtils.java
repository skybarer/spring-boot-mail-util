package inkollu.akash.mail.util.datatype;

/*
 * @author : akashdhar
 * @date : 20-10-2019
 * @time : 12:44 PM
 */

import org.apache.commons.lang3.math.NumberUtils;

import java.math.BigDecimal;


public abstract class BigDecimalUtils {


    public static BigDecimal setScaleDown(BigDecimal current, int position) {
        return current.setScale(position, BigDecimal.ROUND_DOWN);
    }


    public static boolean isPositiveNumber(BigDecimal bigDecimal) {
        return bigDecimal.compareTo(BigDecimal.ZERO) == 1;
    }


    public static boolean isNotPositiveNumber(BigDecimal bigDecimal) {
        return !isPositiveNumber(bigDecimal);
    }

    public static boolean isEqual(BigDecimal before, BigDecimal after) {
        return before.compareTo(after) == 0;
    }


    public static boolean isEqual(BigDecimal before, String after) {
        return isEqual(before, NumberUtils.createBigDecimal(after));
    }


    public static boolean isNotEqual(BigDecimal before, String after) {
        return isNotEqual(before, NumberUtils.createBigDecimal(after));
    }

    public static boolean isNotEqual(BigDecimal before, BigDecimal after) {
        return !isEqual(before, after);
    }


    public static BigDecimal multiply(BigDecimal before, int after) {
        return before.multiply(NumberUtils.createBigDecimal(String.valueOf(after)));
    }

    public static BigDecimal subtract(BigDecimal before, String after) {
        return before.subtract(NumberUtils.createBigDecimal(after));
    }

    public static BigDecimal subtract(BigDecimal before, BigDecimal after) {
        return before.subtract(after);
    }


    public static BigDecimal add(BigDecimal before, String after) {
        return before.add(NumberUtils.createBigDecimal(after));
    }

    public static BigDecimal add(BigDecimal before, BigDecimal after) {
        return before.add(after);
    }

}
