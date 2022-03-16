package graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import calculations.BinaryCalculator;
import dataread.InputVerifier;

/**
 * The Binary calculator section is built here where the user is able to add, subtract, multiply
 * and divide binary values
 * The user will also be able to convert a decimal value to a binary value and vice versa and the user
 * will do all those in this section
 * @author Ivan Sy
 * @version 11/20/2021
 */
public class BinaryWindow implements ActionListener {

    private JFrame frame;
    private JPanel displayPanel;
    private JLabel introLabel;
    private JLabel numLabel1;
    private JLabel numLabel2;
    private JLabel resultLabel;
    private JLabel xCheck;
    private JLabel yCheck;
    private JLabel remainderCheck;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField resultField;
    private JButton toDecimalButton;
    private JButton toBinaryButton;
    private JButton addButton;
    private JButton subtractButton;
    private JButton multiplyButton;
    private JButton divideButton;
    private JLabel binaryResult;

    /**
     * The Binary section interface is built here, along with the respective labels, buttons and text fields
     * the user will be able to interact with
     * @param frame the frame where all components and panels will be built
     */
    public BinaryWindow(JFrame frame) {
        initializeFrame(frame);
        initializeDisplay();
        initializeLabels();
        initializeTextFields();
        initializeButtons();
        addComponentsToDisplay();
        initializeComponentBounds();
        setTextFieldSize();
        addComponentListeners();
        frame.setVisible(true);
    }

    private void initializeFrame(JFrame frame) {
        frame.getContentPane().removeAll();
        this.frame = frame;
        frame.setTitle("Binary Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initializeDisplay() {
        displayPanel = new JPanel();
        displayPanel.setLayout(null);
        frame.add(displayPanel);
        displayPanel.setBackground(new Color(229,224,255));
    }

    private void initializeButtons() {
        toDecimalButton = new JButton("X to Decimal");
        toBinaryButton = new JButton("X to Binary");
        addButton = new JButton("Add");
        subtractButton = new JButton("Subtract");
        multiplyButton = new JButton("Multiply");
        divideButton = new JButton("Divide");
    }

    private void initializeLabels() {
        introLabel = new JLabel("Behold Binary Calculator");
        numLabel1 = new JLabel("First Value:");
        numLabel2 = new JLabel("Second Value:");
        xCheck = new JLabel();
        yCheck = new JLabel();
        remainderCheck = new JLabel();
        binaryResult = new JLabel();
        resultLabel = new JLabel("Result: ");
        introLabel.setFont(new Font("Serif", Font.BOLD+Font.ITALIC, 20));
        numLabel1.setFont(new Font("Serif", Font.BOLD, 12));
        numLabel2.setFont(new Font("Serif", Font.BOLD, 12));
        resultLabel.setFont(new Font("Serif", Font.BOLD, 12));
    }

    private void initializeTextFields() {
        textField1 = new JTextField();
        textField2 = new JTextField();
        resultField = new JTextField();
        resultField.setEditable(false);
    }

    private void setTextFieldSize() {
        textField1.setSize(300,25);
        textField2.setSize(300, 25);
        resultField.setSize(300,25);
    }

    private void addComponentsToDisplay() {
        displayPanel.add(numLabel1);
        displayPanel.add(numLabel2);
        displayPanel.add(resultLabel);
        displayPanel.add(textField1);
        displayPanel.add(textField2);
        displayPanel.add(resultField);
        displayPanel.add(toDecimalButton);
        displayPanel.add(toBinaryButton);
        displayPanel.add(addButton);
        displayPanel.add(subtractButton);
        displayPanel.add(multiplyButton);
        displayPanel.add(divideButton);
        displayPanel.add(introLabel);
        displayPanel.add(xCheck);
        displayPanel.add(yCheck);
        displayPanel.add(remainderCheck);
        displayPanel.add(binaryResult);
    }

    //sets the location of the components on the frame
    private void initializeComponentBounds() {
        numLabel1.setBounds(50, 102, 100,20);
        numLabel2.setBounds(50, 142,100, 20);
        resultLabel.setBounds(50, 200,100,20);
        textField1.setBounds(200, 100,100,20);
        textField2.setBounds(200,140,100,20);
        resultField.setBounds(200,195,100,20);
        toDecimalButton.setBounds(100,250,150,40);
        toBinaryButton.setBounds(370,250,150,40);
        addButton.setBounds(60,300,75,40);
        subtractButton.setBounds(210,300,75,40);
        multiplyButton.setBounds(330,300,75,40);
        divideButton.setBounds(480, 300, 75, 40);
        introLabel.setBounds(165, 20,400,60);
        xCheck.setBounds(60,360,350,30);
        yCheck.setBounds(60, 390, 350, 30);
        remainderCheck.setBounds(60, 450, 400, 30);
        binaryResult.setBounds(60, 420,400, 30);
    }

    private void addComponentListeners() {
        toDecimalButton.addActionListener(this);
        toBinaryButton.addActionListener(this);
        addButton.addActionListener(this);
        subtractButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);
    }

    private void resetAlerts() {
        xCheck.setText("");
        yCheck.setText("");
        remainderCheck.setText("");
    }

    /**
     * When a user clicks one of the buttons to choose desired function, they will be
     * prompted with the desired result of the operation they choose, displayed in the result menu
     * @param e encompasses the button items to declare action on desired functionality
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == toDecimalButton)
            toDecimalOperation();
        else if (e.getSource() == toBinaryButton)
            toBinaryOperation();
        else if (e.getSource() == addButton)
            addOperation();
        else if (e.getSource() == subtractButton)
            subtractOperation();
        else if (e.getSource() == multiplyButton)
            multiplyOperation();
        else if (e.getSource() == divideButton)
            divideOperation();
    }

    private void toDecimalOperation() {
        String xValue = textField1.getText().trim();
        boolean isBinary = new InputVerifier().verifyBinary(xValue);
        if (isBinary) {
            binaryResult.setText("");
            String decimalValue = new BinaryCalculator().convertBinaryToDecimal(xValue);
            setToResult(decimalValue);
            resetAlerts();
        } else {
            binaryResult.setText("");
            resultField.setText("");
            displayToChecks("X Alert: Binary must contain 1 and 0 only", "");
        }
    }

    private void toBinaryOperation() {
        String xValue = textField1.getText().trim();
        boolean isDecimal = new InputVerifier().verifyDecimal(xValue);
        boolean isNegative = xValue.startsWith("-");
        if (isDecimal) {
            binaryResult.setText("");
            if (isNegative) xValue = xValue.substring(1);
            String binaryValue = new BinaryCalculator().convertDecimalToBinary(xValue);
            if (isNegative) binaryValue = "-" + binaryValue;
            setToResult(binaryValue);
            resetAlerts();
        } else {
            binaryResult.setText("");
            resultField.setText("");
            displayToChecks("X Alert: Decimal must contain real numbers only", "");
        }
    }

    private void addOperation() {
        String xValue = textField1.getText().trim();
        String yValue = textField2.getText().trim();
        boolean isXBinary = new InputVerifier().verifyBinary(xValue);
        boolean isYBinary = new InputVerifier().verifyBinary(yValue);
        if (isXBinary && isYBinary) {
            String xDecimal = new BinaryCalculator().convertBinaryToDecimal(xValue);
            String yDecimal = new BinaryCalculator().convertBinaryToDecimal(yValue);
            String result = new BinaryCalculator().add(xDecimal, yDecimal);
            String binaryResult = new BinaryCalculator().convertDecimalToBinary(result);
            displayBinaryResult(binaryResult);
            setToResult(result);
            displayToChecks("X value: " + xDecimal,"Y value: " + yDecimal);
        } else {
            binaryResult.setText("");
            resultField.setText("");
            setAlerts(isXBinary,isYBinary);
        }
    }

    private void subtractOperation() {
        String xValue = textField1.getText().trim();
        String yValue = textField2.getText().trim();
        boolean isXBinary = new InputVerifier().verifyBinary(xValue);
        boolean isYBinary = new InputVerifier().verifyBinary(yValue);
        if (isXBinary && isYBinary) {
            String xDecimal = new BinaryCalculator().convertBinaryToDecimal(xValue);
            String yDecimal = new BinaryCalculator().convertBinaryToDecimal(yValue);
            String result = new BinaryCalculator().subtract(xDecimal, yDecimal);
            String binaryResult = new BinaryCalculator().convertDecimalToBinary(result);
            displayBinaryResult(binaryResult);
            setToResult(result);
            displayToChecks("X value: " + xDecimal,"Y value: " + yDecimal);
        } else {
            binaryResult.setText("");
            resultField.setText("");
            setAlerts(isXBinary, isYBinary);
        }
    }

    private void multiplyOperation() {
        String xValue = textField1.getText().trim();
        String yValue = textField2.getText().trim();
        boolean isXBinary = new InputVerifier().verifyBinary(xValue);
        boolean isYBinary = new InputVerifier().verifyBinary(yValue);
        if (isXBinary && isYBinary) {
            String xDecimal = new BinaryCalculator().convertBinaryToDecimal(xValue);
            String yDecimal = new BinaryCalculator().convertBinaryToDecimal(yValue);
            String result = new BinaryCalculator().multiply(xDecimal, yDecimal);
            String binaryResult = new BinaryCalculator().convertDecimalToBinary(result);
            displayBinaryResult(binaryResult);
            setToResult(result);
            displayToChecks("X value: " + xDecimal,"Y value: " + yDecimal);
        } else {
            binaryResult.setText("");
            resultField.setText("");
            setAlerts(isXBinary, isYBinary);
        }
    }

    private void divideOperation() {
        String xValue = textField1.getText().trim();
        String yValue = textField2.getText().trim();
        boolean isXBinary = new InputVerifier().verifyBinary(xValue);
        boolean isYBinary = new InputVerifier().verifyBinary(yValue);
        if (isXBinary && isYBinary) {
            String xDecimal = new BinaryCalculator().convertBinaryToDecimal(xValue);
            String yDecimal = new BinaryCalculator().convertBinaryToDecimal(yValue);
            if (yDecimal.equals("0")) { //CANNOT DIVIDE BY ZERO
                displayToChecks("", "Y Alert: Do not divide by 0");
                return;
            }
            String result = new BinaryCalculator().divide(xDecimal, yDecimal);
            String binaryResult = new BinaryCalculator().convertDecimalToBinary(result);
            displayBinaryResult(binaryResult);
            setToResult(result);
            displayToChecks("X value: " + xDecimal,"Y value: " + yDecimal);
            displayRemainder(xDecimal, yDecimal);
        } else {
            binaryResult.setText("");
            resultField.setText("");
            setAlerts(isXBinary, isYBinary);
        }
    }

    private void setToResult(String result) {
        resultField.setText(result);
        resultField.setFont(new Font("Serif", Font.BOLD, 13));
    }

    private void setAlerts(boolean isXBinary, boolean isYBinary) {
        String xAlert = "X Alert: Binary must contain 1 and 0 only";
        String yAlert = "Y Alert: Binary must contain 1 and 0 only";
        if (!isXBinary && !isYBinary)   displayToChecks(xAlert, yAlert);
        else if (!isXBinary)            displayToChecks(xAlert, "");
        else if (!isYBinary)            displayToChecks("", yAlert);
    }

    private void displayToChecks(String xValue, String yValue) {
        xCheck.setText(xValue);
        yCheck.setText(yValue);
    }

    private void displayRemainder(String xDecimal, String yDecimal) {
        String remainder = new BinaryCalculator().modulus(xDecimal, yDecimal);
        remainderCheck.setText("Remainder: " + remainder);
    }

    private void displayBinaryResult(String value) {
        binaryResult.setText("Binary Result: " + value);
        binaryResult.setFont(new Font("Serif", Font.BOLD,13));
    }

}
