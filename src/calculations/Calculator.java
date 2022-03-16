package calculations;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * class  defines a calculator to be inherited for its children calculator
 * All methods in this class is extended to its children, as they all carry the same functionality
 * @author Ivan Sy
 * @version 11/20/2021
 */

public class Calculator {

    protected BigDecimal num1;
    protected BigDecimal num2;
    protected BigDecimal result;

    /**
     * adds the two respective values, placing them in a result container of BigDecimal
     * @param value1 string value, converted to a big decimal, to be added with other specified value
     * @param value2 string value, converted to a big decimal, to be added with other specified value
     * @return the String of BigDecimal result of the two values added
     */
    public String add(String value1, String value2) {
        convertStringToDecimal(value1,value2);
        result = num1.add(num2);
        return result.toPlainString();
    }

    /**
     * subtracts the two respective values, placing them in a result container of BigDecimal
     * @param value1 string value, converted to a big decimal, to be subtracted
     * @param value2 string value, converted to a big decimal, to be subtracted from other specified value
     * @return the String of BigDecimal result of value1 subtracted by value2
     */
    public String subtract(String value1, String value2) {
        convertStringToDecimal(value1,value2);
        result = num1.subtract(num2);
        return result.toPlainString();
    }

    /**
     * multiplies the two respective values, placing them in a result container of BigDecimal
     * @param value1 string value, converted to a big decimal, to be multiplied with other specified value
     * @param value2 string value, converted to a big decimal, to be multiplied with other specified value
     * @return the String of BigDecimal result of the two values multiplied
     */
    public String multiply(String value1, String value2) {
        convertStringToDecimal(value1,value2);
        result = num1.multiply(num2);
        return result.toPlainString();
    }

    /**
     * divides the first specified value from the other specified value, placing them in a result container of BigDecimal
     * @param value1 string value, converted to a big decimal, to be divided
     * @param value2 string value, converted to a big decimal, to be the divisor
     * @return the String of BigDecimal result of value1 divided by value2
     */
    public String divide(String value1, String value2) {
        convertStringToDecimal(value1,value2);
        result = num1.divide(num2, RoundingMode.HALF_UP);
        return result.toPlainString();
    }

    /**
     * the remainder of value1 divided by value2 is placed in a result container of BigDecimal and returned in String
     * @param value1 string value, converted to a big decimal, to be divided
     * @param value2 string value, converted to a big decimal, to be the divisor
     * @return the String of BigDecimal result of the remainder of value1 divided by value2
     */
    public String modulus(String value1, String value2) {
        convertStringToDecimal(value1,value2);
        result = num1.remainder(num2);
        return result.toPlainString();
    }

    protected void convertStringToDecimal(String value1, String value2) {
        this.num1 = new BigDecimal(value1);
        this.num2 = new BigDecimal(value2);
    }

}
