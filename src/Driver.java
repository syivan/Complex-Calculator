import graphics.*;

/**
 * Driver file/class to boot a complex calculator with operations on binary values, hexadecimal
 * and big number (big decimal) values
 * Binary - values ranging with 1 and 0
 * Hex - values ranging from 0-9 and A-F
 * Big Number - large values that also contain scientific notation
 * Big Decimal - large float decimal values
 * @author Ivan Sy
 * @version 11/06/2021
 */
public class Driver {
    /**
     * main method ---> user is led to the main window
     * @param args String[] args
     */
    public static void main(String[] args) {
        new MainWindow();
    }
}
