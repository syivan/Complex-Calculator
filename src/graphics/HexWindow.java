package graphics;

import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import calculations.BinaryCalculator;
import calculations.HexCalculator;
import dataread.InputVerifier;

/**
 * The Hexadecimal calculator section is built here where the user is able to add, subtract, multiply
 * and divide hexadecimal values
 * The user will also be able to convert a decimal value to a hexadecimal value,
 * along with hexadecimal to decimal value and the user will do all those in this section
 * @author Ivan Sy
 * @version 11/20/2021
 */
public class HexWindow implements ActionListener {

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
    private JButton toHexButton;
    private JButton addButton;
    private JButton subtractButton;
    private JButton multiplyButton;
    private JButton divideButton;
    private JLabel hexResult;

    /**
     * The Hexadecimal section interface is built here, along with the respective labels, buttons and text fields
     * the user will be able to interact with
     * @param frame the frame where all components and panels will be built
     */
    public HexWindow(JFrame frame) {
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
        frame.setTitle("Hex Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /*
      initializes the display where JPanel will be used to enter my components exclusively
     */
    private void initializeDisplay() {
        displayPanel = new JPanel();
        displayPanel.setLayout(null); //removes default layout
        frame.add(displayPanel);
        displayPanel.setBackground(new Color(229,224,255));
    }

    private void initializeButtons() {
        toDecimalButton = new JButton("X to Decimal");
        toHexButton = new JButton("X to Hex");
        addButton = new JButton("Add");
        subtractButton = new JButton("Subtract");
        multiplyButton = new JButton("Multiply");
        divideButton = new JButton("Divide");
    }


    private void initializeLabels() {
        introLabel = new JLabel("Hello Hex Calculator");
        numLabel1 = new JLabel("First Value:");
        numLabel2 = new JLabel("Second Value:");
        xCheck = new JLabel();
        yCheck = new JLabel();
        remainderCheck = new JLabel();
        hexResult = new JLabel();
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
        displayPanel.add(toHexButton);
        displayPanel.add(addButton);
        displayPanel.add(subtractButton);
        displayPanel.add(multiplyButton);
        displayPanel.add(divideButton);
        displayPanel.add(introLabel);
        displayPanel.add(xCheck);
        displayPanel.add(yCheck);
        displayPanel.add(remainderCheck);
        displayPanel.add(hexResult);
    }

    private void initializeComponentBounds() {
        numLabel1.setBounds(50, 102, 100,20);
        numLabel2.setBounds(50, 142,100, 20);
        resultLabel.setBounds(50, 200,100,20);
        textField1.setBounds(200, 100,100,20);
        textField2.setBounds(200,140,100,20);
        resultField.setBounds(200,195,100,20);
        toDecimalButton.setBounds(100,250,150,40);
        toHexButton.setBounds(370,250,150,40);
        addButton.setBounds(60,300,75,40);
        subtractButton.setBounds(210,300,75,40);
        multiplyButton.setBounds(330,300,75,40);
        divideButton.setBounds(480, 300, 75, 40);
        introLabel.setBounds(185, 20,400,60);
        xCheck.setBounds(60,360,350,30);
        yCheck.setBounds(60, 390, 350, 30);
        hexResult.setBounds(60, 420,350,30);
        remainderCheck.setBounds(60, 450, 400, 30);
    }

    private void addComponentListeners() {
        toDecimalButton.addActionListener(this);
        toHexButton.addActionListener(this);
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
        else if (e.getSource() == toHexButton)
            toHexOperation();
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
        boolean isNegative = xValue.startsWith("-");
        if (isNegative) xValue = xValue.substring(1);
        boolean isHex = new InputVerifier().verifyHex(xValue);
        if (isHex) {
            hexResult.setText("");
            String decimalValue = new HexCalculator().convertHexToDecimal(xValue);
            if (isNegative) decimalValue = "-" + decimalValue;
            setToResult(decimalValue);
            resetAlerts();
        } else {
            hexResult.setText("");
            resultField.setText("");
            displayToChecks("X Alert: Hex must contain values 0-9, a-f, A-F only", "");
        }
    }

    private void toHexOperation() {
        String xValue = textField1.getText().trim();
        boolean isDecimal = new InputVerifier().verifyDecimal(xValue);
        boolean isNegative = xValue.startsWith("-");
        if (isDecimal) {
            hexResult.setText("");
            if (isNegative) xValue = xValue.substring(1);
            String hexValue = new HexCalculator().convertDecimalToHex(xValue);
            if (isNegative) hexValue = "-" + hexValue;
            setToResult(hexValue);
            resetAlerts();
        } else {
            hexResult.setText("");
            resultField.setText("");
            displayToChecks("X Alert: Decimal must contain real numbers only only", "");
        }
    }

    private void addOperation() {
        String xValue = textField1.getText().trim();
        String yValue = textField2.getText().trim();
        boolean isXNegative = xValue.startsWith("-");
        boolean isYNegative = yValue.startsWith("-");
        if (isXNegative) xValue = xValue.substring(1);
        if (isYNegative) yValue = yValue.substring(1);
        boolean isXHex = new InputVerifier().verifyHex(xValue);
        boolean isYHex = new InputVerifier().verifyHex(yValue);
        if (isXHex && isYHex) {
            String xDecimal = new HexCalculator().convertHexToDecimal(xValue);
            String yDecimal = new HexCalculator().convertHexToDecimal(yValue);
            if (isXNegative) xDecimal = "-" + xDecimal;
            if (isYNegative) yDecimal = "-" + yDecimal;
            String result = new HexCalculator().add(xDecimal, yDecimal);
            String temp = result.startsWith("-") ? result.substring(1) : result;
            String hexResult = new HexCalculator().convertDecimalToHex(temp);
            if (!result.startsWith("-")) displayHexResult(hexResult);
            else displayHexResult("-" + hexResult);
            setToResult(result);
            displayToChecks("X value: " + xDecimal,"Y value: " + yDecimal);
        } else {
            hexResult.setText("");
            resultField.setText("");
            setAlerts(isXHex,isYHex);
        }
    }

    private void subtractOperation() {
        String xValue = textField1.getText().trim();
        String yValue = textField2.getText().trim();
        boolean isXNegative = xValue.startsWith("-");
        boolean isYNegative = yValue.startsWith("-");
        if (isXNegative) xValue = xValue.substring(1);
        if (isYNegative) yValue = yValue.substring(1);
        boolean isXHex = new InputVerifier().verifyHex(xValue);
        boolean isYHex = new InputVerifier().verifyHex(yValue);
        if (isXHex && isYHex) {
            String xDecimal = new HexCalculator().convertHexToDecimal(xValue);
            String yDecimal = new HexCalculator().convertHexToDecimal(yValue);
            if (isXNegative) xDecimal = "-" + xDecimal;
            if (isYNegative) yDecimal = "-" + yDecimal;
            String result = new HexCalculator().subtract(xDecimal, yDecimal);
            String temp = result.startsWith("-") ? result.substring(1) : result;
            String hexResult = new HexCalculator().convertDecimalToHex(temp);
            if (!result.startsWith("-")) displayHexResult(hexResult);
            else displayHexResult("-" + hexResult);
            setToResult(result);
            displayToChecks("X value: " + xDecimal,"Y value: " + yDecimal);
        } else {
            hexResult.setText("");
            resultField.setText("");
            setAlerts(isXHex,isYHex);
        }
    }

    private void multiplyOperation() {
        String xValue = textField1.getText().trim();
        String yValue = textField2.getText().trim();
        boolean isXNegative = xValue.startsWith("-");
        boolean isYNegative = yValue.startsWith("-");
        if (isXNegative) xValue = xValue.substring(1);
        if (isYNegative) yValue = yValue.substring(1);
        boolean isXHex = new InputVerifier().verifyHex(xValue);
        boolean isYHex = new InputVerifier().verifyHex(yValue);
        if (isXHex && isYHex) {
            String xDecimal = new HexCalculator().convertHexToDecimal(xValue);
            String yDecimal = new HexCalculator().convertHexToDecimal(yValue);
            if (isXNegative) xDecimal = "-" + xDecimal;
            if (isYNegative) yDecimal = "-" + yDecimal;
            String result = new HexCalculator().multiply(xDecimal, yDecimal);
            String temp = result.startsWith("-") ? result.substring(1) : result;
            String hexResult = new HexCalculator().convertDecimalToHex(temp);
            if (!result.startsWith("-")) displayHexResult(hexResult);
            else displayHexResult("-" + hexResult);
            setToResult(result);
            displayToChecks("X value: " + xDecimal,"Y value: " + yDecimal);
        } else {
            hexResult.setText("");
            resultField.setText("");
            setAlerts(isXHex,isYHex);
        }
    }

    private void divideOperation() {
        String xValue = textField1.getText().trim();
        String yValue = textField2.getText().trim();
        boolean isXNegative = xValue.startsWith("-");
        boolean isYNegative = yValue.startsWith("-");
        if (isXNegative) xValue = xValue.substring(1);
        if (isYNegative) yValue = yValue.substring(1);
        boolean isXHex = new InputVerifier().verifyHex(xValue);
        boolean isYHex = new InputVerifier().verifyHex(yValue);
        if (isXHex && isYHex) {
            String xDecimal = new HexCalculator().convertHexToDecimal(xValue);
            String yDecimal = new HexCalculator().convertHexToDecimal(yValue);
            if (yDecimal.equals("0")) { //CANNOT DIVIDE BY ZERO
                displayToChecks("", "Y Alert: Do not divide by 0");
                return;
            }
            if (isXNegative) xDecimal = "-" + xDecimal;
            if (isYNegative) yDecimal = "-" + yDecimal;
            String result = new HexCalculator().divide(xDecimal, yDecimal);
            String temp = result.startsWith("-") ? result.substring(1) : result;
            String hexResult = new HexCalculator().convertDecimalToHex(temp);
            if (!result.startsWith("-")) displayHexResult(hexResult);
            else displayHexResult("-" + hexResult);
            setToResult(result);
            displayToChecks("X value: " + xDecimal,"Y value: " + yDecimal);
            displayRemainder(xDecimal, yDecimal);
        } else {
            hexResult.setText("");
            resultField.setText("");
            setAlerts(isXHex,isYHex);
        }
    }

    private void setToResult(String result) {
        resultField.setText(result);
        resultField.setFont(new Font("Serif", Font.BOLD, 13));
    }

    private void setAlerts(boolean isXHex, boolean isYHex) {
        String xAlert = "X Alert: Hex must contain 0-9, a-f, A-F only";
        String yAlert = "Y Alert: Hex must contain 0-9, a-f, A-F only";
        if (!isXHex && !isYHex)   displayToChecks(xAlert, yAlert);
        else if (!isXHex)            displayToChecks(xAlert, "");
        else if (!isYHex)            displayToChecks("", yAlert);
    }

    private void displayToChecks(String xValue, String yValue) {
        xCheck.setText(xValue);
        yCheck.setText(yValue);
    }

    private void displayRemainder(String xDecimal, String yDecimal) {
        String remainder = new BinaryCalculator().modulus(xDecimal, yDecimal);
        remainderCheck.setText("Remainder: " + remainder);
    }

    private void displayHexResult(String value) {
        hexResult.setText("Hex Result: " + value);
        hexResult.setFont(new Font("Serif", Font.BOLD,13));
    }


}
