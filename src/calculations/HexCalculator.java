package calculations;

/**
 * Hex calculator works implementation for converting hexadecimal values to decimal values
 * and converts decimal values to hexadecimal values
 * implements the Calculator interface, marking the Hex Calculator as a general calculator
 * @author Ivan Sy
 * @version 11/06/2021
 */
public class HexCalculator extends Calculator {

    /**
     * converts the specified hexadecimal value into a decimal value
     * then returns that decimal value
     * influenced https://www.javatpoint.com/java-hex-to-decimal
     * @param hex the hexadecimal value to be converted
     * @return the decimal value of the specified hexadecimal value in String
     */
    public String convertHexToDecimal(String hex) {
        long decimalResult = Long.parseLong(hex,16);
        return String.valueOf(decimalResult);
    }

    /**
     * converts the specified decimal value into a hexadecimal value
     * then returns that decimal value
     * influenced https://www.javatpoint.com/java-decimal-to-hex
     * @param decimal the decimal value to be converted
     * @return the hexadecimal value of the specified decimal value in String
     */
    public String convertDecimalToHex(String decimal) {
        long hexResult = Long.parseLong(decimal);
        return Long.toHexString(hexResult);
    }

}
