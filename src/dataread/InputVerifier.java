package dataread;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * All input verification and error checks are built into this class
 * where the program ensures that the input entered by the user is valid and if not, returned to proper
 * checks
 * @author Ivan Sy
 * @version 11/20/2021
 */
public class InputVerifier {

    /**
     * verifies that the String value passed can pass as a binary value and returns true if so
     *
     * @param binary the string value checked if it can pass as a binary values
     * @return true if string passed can pass as binary value
     */
    public boolean verifyBinary(String binary) {
        if (binary.isEmpty()) return false;
        if (binary.startsWith("-")) binary = binary.substring(1);
        for (int i = 0; i < binary.length(); i++) {
            if (!(binary.charAt(i) == '0' || binary.charAt(i) == '1'))
                return false;
        }
        return true;
    }

    /**
     * verifies that the String value passed can pass as a hexadecimal value and returns true if so
     *
     * @param hex the string value checked if it can pass as a hexadecimal values
     * @return true if string passed can pass as hexadecimal value, false otherwise
     */
    public boolean verifyHex(String hex) {
        if (hex.isEmpty()) return false;
        Character[] charArray = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'A', 'B', 'C', 'D', 'E', 'F'};
        List<Character> charList = Arrays.asList(charArray);
        for (int i = 0; i < hex.length(); i++) {
            if (!charList.contains(hex.charAt(i)))
                return false;
        }
        return true;
    }

    /**
     * verifies that the String value passed can pass as a decimal value and returns true if so
     *
     * @param decimal the string value checked if it can pass as a decimal value
     * @return true if string passed can pass as decimal value, false otherwise
     */
    public boolean verifyDecimal(String decimal) {
        if (decimal.startsWith("-")) decimal = decimal.substring(1);
        try {
            Long.parseLong(decimal);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * verifies that the String value passed can pass as a big Decimal value and returns true if so
     *
     * @param decimal the string value checked if it can pass as a Big Decimal value
     * @return true if string passed can pass as Big Decimal value, false otherwise
     */
    public boolean verifyBigDecimal(String decimal) {
        try {
            new BigDecimal(decimal);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * checks to see if the String passed has a decimal point, returns true if so
     *
     * @param decimal the string value checked if it has a decimal point
     * @return true if string passed has a decimal point, false otherwise
     */
    public boolean checkDecimal(String decimal) {
        return decimal.contains(".");
    }

    /**
     * checks to see if the String passed starts with a negative, returns true if so
     *
     * @param decimal the string value checked if it starts with a negative
     * @return true if string passed has a decimal point, false otherwise
     */
    public boolean checkNegative(String decimal) {
        return decimal.startsWith("-");
    }

}