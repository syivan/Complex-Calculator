package calculations;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Big Number calculator works implementation for operating on large values, whether addition, subtraction
 * multiplication, division, and they will also be able to do extended features such as
 * factorials, getting a square root, getting x to the power of y, getting the greatest common denominator of 2 values,
 * getting the lowest common multiple of 2 values and getting a square of a value
 * @author Ivan Sy
 * @version 11/12/2021
 */
public class BigNumberCalculator extends Calculator {

    /**
     * divides value1 from value2 and returns the result in a String
     * @param value1 divided by value2
     * @param value2 divides value1
     * @return the string result of value1 divided by value2
     */
    public String bigDivide(String value1, String value2) {
        convertStringToDecimal(value1, value2);
        BigDecimal result = num1.divide(num2, 15, RoundingMode.CEILING);
        return result.toPlainString();
    }

    /**
     * gets the result of value1 to the power of value2 and returned in a String
     * @param value1 the value to be implemented powers
     * @param value2 x is applied to this power
     * @return the string result of value1 to the power of value2
     */
    public String power(String value1, String value2)  {
        if (value2 == "0") return "1";
        convertStringToDecimal(value1,value2);
        long counter = num2.longValue();
        BigDecimal result = new BigDecimal(value1);
        for (int i = 1; i < counter; i++) {
            result = result.multiply(num1);
        }
        return result.toPlainString();
    }

    /**
     * returns the square root of value1 as BigDecimal
     * @param value1 the value1 converted to BigDecimal to retrieve its square root
     * @return the string result of square root of value1
     */
    public String squareRoot(String value1) {
        convertStringToDecimal(value1, "0");
        BigDecimal result = num1.sqrt(new MathContext(20));
        return result.toPlainString();
    }

    /**
     * returns the square of value1 as BigDecimal
     * @param value1 the value1 converted to BigDecimal to retrieve its square
     * @return the string result of square of value1
     */
    public String square(String value1) {
        convertStringToDecimal(value1, "0");
        return power(value1, "2");
    }

    /**
     * returns the factorial of value1 as BigDecimal
     * @param value1 the value1 converted to BigDecimal to retrieve its factorial
     * @return the string result of factorial of value1
     */
    public String factorial(String value1) {
        BigDecimal result = new BigDecimal(value1);
        BigDecimal temp = new BigDecimal(value1);
        while (!temp.equals(new BigDecimal(1))) {
            temp = temp.subtract(new BigDecimal(1));
            result =  result.multiply(temp);
        }
        return result.toPlainString();
    }

    /**
     * gets the greatest common denominator of value1 and value2 and returned in a String
     * @param value1 first value to retrieve the GCD
     * @param value2 second value to retrieve the GCD
     * @return the string result of the GCD of value1 and value2
     */
    public String calculateGCD(String value1, String value2) {
        convertStringToDecimal(value1,value2);
        BigDecimal result = new BigDecimal(0);
        long counter1 = num1.longValue();
        long counter2 = num2.longValue();
        for (long i = 1; i <= counter1 && i <= counter2; i++) {
            if (counter1 % i == 0 && counter2 % i == 0)
                result = new BigDecimal(i);
        }
        return result.toPlainString();
    }

    /**
     * gets the least common multiplie of value1 and value2 and returned in a String
     * @param value1 first value to retrieve the LCM
     * @param value2 second value to retrieve the LCM
     * @return the string result of the LCM of value1 and value2
     */
    public String calculateLCM(String value1, String value2) {
        convertStringToDecimal(value1, value2);
        String gcdString = calculateGCD(value1,value2);
        BigDecimal gcdValue = new BigDecimal(gcdString);
        BigDecimal result = num1.multiply(num2).divide(gcdValue);
        return result.toPlainString();
    }


}
