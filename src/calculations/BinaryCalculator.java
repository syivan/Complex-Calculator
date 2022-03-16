package calculations;

/**
 * Binary calculator works implementation for converting binary to decimal values
 * and converts decimal values to binary
 * implements the Calculator interface, marking the Binary Calculator as a general calculator
 * @author Ivan Sy
 * @version 11/06/2021
 */
public class BinaryCalculator extends Calculator {

    /**
     * converts the specified binary value into a decimal value
     * then returns that decimal value
     * influenced https://www.javatpoint.com/java-binary-to-decimal
     * @param binaryValue the binary value to be converted
     * @return the decimal value of the specified binary value in String
     */
    public String convertBinaryToDecimal(String binaryValue) {
        long decimalResult = Long.parseLong(binaryValue, 2);
        return String.valueOf(decimalResult);
    }

    /**
     * converts the specified decimal value into a binary value
     * then returns that binary value
     * influenced https://www.javatpoint.com/java-decimal-to-binary
     * @param decimal the decimal value to be converted
     * @return the binary value of the specified decimal value in String
     */
    public String convertDecimalToBinary(String decimal) {
        long binaryResult = Long.parseLong(decimal);
        return Long.toBinaryString(binaryResult);
    }
}
