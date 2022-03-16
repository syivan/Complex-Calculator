package graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import calculations.BigNumberCalculator;
import dataread.InputVerifier;

/**
 * The Big Number calculator section is built here where the user is able to add, subtract, multiply
 * and divide big number values, and they will also be able to do extended features such as
 * factorials, getting a square root, getting x to the power of y, getting the greatest common denominator of 2 values,
 * getting the lowest common multiple of 2 values, getting a square of a value and all those will be interacted here
 * @author Ivan Sy
 * @version 11/20/2021
 */
public class BigNumberWindow implements ActionListener{

    private JFrame frame;
    private JPanel displayPanel;
    private JLabel introLabel;
    private JLabel numLabel1;
    private JLabel numLabel2;
    private JLabel resultLabel;
    private JLabel xCheck;
    private JLabel yCheck;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField resultField;
    private JButton addButton;
    private JButton subtractButton;
    private JButton multiplyButton;
    private JButton divideButton;
    private JButton modulusButton;
    private JButton xPowerYButton;
    private JButton xSqrtButton;
    private JButton xSquaredButton;
    private JButton xFactorialButton;
    private JButton gcdButton;
    private JButton lcmButton;

    /**
     * The Big Number section interface is built here, along with the respective labels, buttons and text fields
     * the user will be able to interact with
     * @param frame the frame where all components and panels will be built
     */
    public BigNumberWindow(JFrame frame) {
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
        frame.setTitle("Big Number Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initializeDisplay() {
        displayPanel = new JPanel();
        displayPanel.setLayout(null);
        frame.add(displayPanel);
        displayPanel.setBackground(new Color(229,224,255));
    }

    private void initializeButtons() {
        addButton = new JButton("Add");
        subtractButton = new JButton("Subtract");
        multiplyButton = new JButton("Multiply");
        divideButton = new JButton("Divide");
        modulusButton = new JButton("Modulus");
        xPowerYButton = new JButton("X^Y");
        xSqrtButton = new JButton("sqrt of X");
        xSquaredButton = new JButton("X^2");
        xFactorialButton = new JButton("X!");
        gcdButton = new JButton("GCD");
        lcmButton = new JButton("LCM");
    }

    private void initializeLabels() {
        introLabel = new JLabel("Welcome Big Number Calculator");
        numLabel1 = new JLabel("First Value:");
        numLabel2 = new JLabel("Second Value:");
        resultLabel = new JLabel("Result: ");
        xCheck = new JLabel();
        yCheck = new JLabel();
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
        resultField.setSize(300, 25);
    }

    private void addComponentsToDisplay() {
        displayPanel.add(numLabel1);
        displayPanel.add(numLabel2);
        displayPanel.add(resultLabel);
        displayPanel.add(textField1);
        displayPanel.add(textField2);
        displayPanel.add(resultField);
        displayPanel.add(addButton);
        displayPanel.add(subtractButton);
        displayPanel.add(multiplyButton);
        displayPanel.add(divideButton);
        displayPanel.add(modulusButton);
        displayPanel.add(xPowerYButton);
        displayPanel.add(xSqrtButton);
        displayPanel.add(xSquaredButton);
        displayPanel.add(xFactorialButton);
        displayPanel.add(gcdButton);
        displayPanel.add(lcmButton);
        displayPanel.add(introLabel);
        displayPanel.add(xCheck);
        displayPanel.add(yCheck);
    }

    private void initializeComponentBounds() {
        numLabel1.setBounds(50, 102, 100,20);
        numLabel2.setBounds(50, 142,100, 20);
        resultLabel.setBounds(50, 200,100,20);
        textField1.setBounds(200, 100,100,20);
        textField2.setBounds(200,140,100,20);
        resultField.setBounds(200,195,100,20);
        addButton.setBounds(60,270,75,40);
        subtractButton.setBounds(150,270,75,40);
        multiplyButton.setBounds(240,270,75,40);
        divideButton.setBounds(330, 270, 75, 40);
        modulusButton.setBounds(420, 270, 75, 40);
        xPowerYButton.setBounds(60, 320, 75, 40);
        xSquaredButton.setBounds(150, 320, 75, 40);
        xSqrtButton.setBounds(240, 320, 75, 40);
        xFactorialButton.setBounds(330, 320, 75, 40);
        gcdButton.setBounds(420, 320, 75, 40);
        lcmButton.setBounds(240,370,75,40);
        introLabel.setBounds(127, 20,400,60);
        xCheck.setBounds(60,430,350,30);
        yCheck.setBounds(60, 460, 350, 30);
    }

    private void addComponentListeners() {
        addButton.addActionListener(this);
        subtractButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);
        modulusButton.addActionListener(this);
        xPowerYButton.addActionListener(this);
        xSqrtButton.addActionListener(this);
        xSquaredButton.addActionListener(this);
        xFactorialButton.addActionListener(this);
        gcdButton.addActionListener(this);
        lcmButton.addActionListener(this);
    }

    /**
     * When a user clicks one of the buttons to choose desired function, they will be
     * prompted with the desired result of the operation they choose, displayed in the result menu
     * @param e encompasses the button items to declare action on desired functionality
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton)
            addOperation();
        else if (e.getSource() == subtractButton)
            subtractOperation();
        else if (e.getSource() == multiplyButton)
            multiplyOperation();
        else if (e.getSource() == divideButton)
            divideOperation();
        else if (e.getSource() == modulusButton)
            modulusOperation();
        else if (e.getSource() == xPowerYButton)
            xPowerYOperation();
        else if (e.getSource() == xSquaredButton)
            xSquaredOperation();
        else if (e.getSource() == xSqrtButton)
            xSqrtOperation();
        else if (e.getSource() == xFactorialButton)
            xFactorialOperation();
        else if (e.getSource() == gcdButton)
            gcdOperation();
        else if (e.getSource() == lcmButton)
            lcmOperation();
    }

    private void addOperation() {
        String xValue = textField1.getText().trim();
        String yValue = textField2.getText().trim();
        boolean isXValid = new InputVerifier().verifyBigDecimal(xValue);
        boolean isYValid = new InputVerifier().verifyBigDecimal(yValue);
        if (isXValid && isYValid) {
            String result = new BigNumberCalculator().add(xValue, yValue);
            setToResult(result);
        } else {
            resultField.setText("");
            setAlerts(isXValid,isYValid);
        }
    }

    private void subtractOperation() {
        String xValue = textField1.getText().trim();
        String yValue = textField2.getText().trim();
        boolean isXValid = new InputVerifier().verifyBigDecimal(xValue);
        boolean isYValid = new InputVerifier().verifyBigDecimal(yValue);
        if (isXValid && isYValid) {
            String result = new BigNumberCalculator().subtract(xValue, yValue);
            setToResult(result);
        } else {
            resultField.setText("");
            setAlerts(isXValid,isYValid);
        }
    }

    private void multiplyOperation() {
        String xValue = textField1.getText().trim();
        String yValue = textField2.getText().trim();
        boolean isXValid = new InputVerifier().verifyBigDecimal(xValue);
        boolean isYValid = new InputVerifier().verifyBigDecimal(yValue);
        if (isXValid && isYValid) {
            String result = new BigNumberCalculator().multiply(xValue, yValue);
            setToResult(result);
        } else {
            resultField.setText("");
            setAlerts(isXValid,isYValid);
        }
    }

    private void divideOperation() {
        String xValue = textField1.getText().trim();
        String yValue = textField2.getText().trim();
        boolean isXValid = new InputVerifier().verifyBigDecimal(xValue);
        boolean isYValid = new InputVerifier().verifyBigDecimal(yValue);
        if (isXValid && isYValid) {
            BigDecimal test = new BigDecimal(yValue);
            if (test.compareTo(BigDecimal.ZERO) == 0) { //CANNOT DIVIDE BY ZERO
                displayToChecks("", "Y Alert: Do not divide by 0");
                return;
            }
            String result = new BigNumberCalculator().bigDivide(xValue, yValue);
            setToResult(result);
        } else {
            resultField.setText("");
            setAlerts(isXValid,isYValid);
        }
    }

    private void modulusOperation() {
        String xValue = textField1.getText().trim();
        String yValue = textField2.getText().trim();
        boolean isXValid = new InputVerifier().verifyBigDecimal(xValue);
        boolean isYValid = new InputVerifier().verifyBigDecimal(yValue);
        if (isXValid && isYValid) {
            BigDecimal test = new BigDecimal(yValue);
            if (test.compareTo(BigDecimal.ZERO) == 0) { //CANNOT MOD BY ZERO
                displayToChecks("", "Y Alert: Do not modulus with 0");
                return;
            }
            String result = new BigNumberCalculator().modulus(xValue, yValue);
            setToResult(result);
        } else {
            resultField.setText("");
            setAlerts(isXValid,isYValid);
        }
    }

    private void xPowerYOperation() {
        String xValue = textField1.getText().trim();
        String yValue = textField2.getText().trim();
        InputVerifier verifier = new InputVerifier();
        boolean isXNegative = verifier.checkNegative(xValue);
        boolean isYNegative = verifier.checkNegative(yValue);
        boolean isXDecimal = verifier.checkDecimal(xValue);
        boolean isYDecimal = verifier.checkDecimal(yValue);
        boolean isXValid = !isXNegative && !isXDecimal && verifier.verifyBigDecimal(xValue);
        boolean isYValid = !isYNegative && !isYDecimal && verifier.verifyBigDecimal(yValue);
        if (isXValid && isYValid) {
            String result = new BigNumberCalculator().power(xValue, yValue);
            setToResult(result);
        } else {
            resultField.setText("");
            String xAlert = "";
            String yAlert = "";
            if (!isXValid) xAlert = "X Alert: X value must not have decimal and be positive";
            if (!isYValid) yAlert = "Y Alert: Y value must not have decimal and be positive";
            displayToChecks(xAlert, yAlert);
        }
    }

    private void xSquaredOperation() {
        String xValue = textField1.getText().trim();
        boolean isXValid = new InputVerifier().verifyBigDecimal(xValue);
        if (isXValid) {
            String result = new BigNumberCalculator().square(xValue);
            setToResult(result);
        } else {
            resultField.setText("");
            displayToChecks("X Alert: X value must be a valid real number", "");
        }
    }

    private void xSqrtOperation() {
        String xValue = textField1.getText().trim();
        boolean isXNegative = new InputVerifier().checkNegative(xValue);
        boolean isXValid = !isXNegative && new InputVerifier().verifyBigDecimal(xValue);
        if (isXValid) {
            String result = new BigNumberCalculator().squareRoot(xValue);
            setToResult(result);
        } else {
            resultField.setText("");
            displayToChecks("X Alert: X value must a valid positive real number", "");
        }
    }

    private void xFactorialOperation() {
        String xValue = textField1.getText().trim();
        InputVerifier verifier = new InputVerifier();
        boolean isXNegative = verifier.checkNegative(xValue);
        boolean isXDecimal = verifier.checkDecimal(xValue);
        boolean isXValid = !isXNegative && !isXDecimal && verifier.verifyBigDecimal(xValue);
        if (isXValid) {
            String result = new BigNumberCalculator().factorial(xValue);
            setToResult(result);
        } else {
            resultField.setText("");
            displayToChecks("X Alert: X value must a valid positive real number", "");
        }
    }


    private void gcdOperation() {
        String xValue = textField1.getText().trim();
        String yValue = textField2.getText().trim();
        InputVerifier verifier = new InputVerifier();
        boolean isXNegative = verifier.checkNegative(xValue);
        boolean isYNegative = verifier.checkNegative(yValue);
        boolean isXDecimal = verifier.checkDecimal(xValue);
        boolean isYDecimal = verifier.checkDecimal(yValue);
        boolean isXValid = !isXNegative && !isXDecimal && verifier.verifyBigDecimal(xValue);
        boolean isYValid = !isYNegative && !isYDecimal && verifier.verifyBigDecimal(yValue);
        if (isXValid && isYValid) {
            String result = new BigNumberCalculator().calculateGCD(xValue, yValue);
            setToResult(result);
        } else {
            resultField.setText("");
            String xAlert = "";
            String yAlert = "";
            if (!isXValid) xAlert = "X Alert: X value must not have decimal and be positive";
            if (!isYValid) yAlert = "Y Alert: Y value must not have decimal and be positive";
            displayToChecks(xAlert, yAlert);
        }
    }

    private void lcmOperation() {
        String xValue = textField1.getText().trim();
        String yValue = textField2.getText().trim();
        InputVerifier verifier = new InputVerifier();
        boolean isXNegative = verifier.checkNegative(xValue);
        boolean isYNegative = verifier.checkNegative(yValue);
        boolean isXDecimal = verifier.checkDecimal(xValue);
        boolean isYDecimal = verifier.checkDecimal(yValue);
        boolean isXValid = !isXNegative && !isXDecimal && verifier.verifyBigDecimal(xValue);
        boolean isYValid = !isYNegative && !isYDecimal && verifier.verifyBigDecimal(yValue);
        if (isXValid && isYValid) {
            String result = new BigNumberCalculator().calculateLCM(xValue, yValue);
            setToResult(result);
        } else {
            resultField.setText("");
            String xAlert = "";
            String yAlert = "";
            if (!isXValid) xAlert = "X Alert: X value must not have decimal and be positive";
            if (!isYValid) yAlert = "Y Alert: Y value must not have decimal and be positive";
            displayToChecks(xAlert, yAlert);
        }
    }

    private void setToResult(String result) {
        resultField.setText(result);
        resultField.setFont(new Font("Serif", Font.BOLD, 12));
    }

    private void displayToChecks(String xValue, String yValue) {
        xCheck.setText(xValue);
        yCheck.setText(yValue);
    }

    private void setAlerts(boolean isXValid, boolean isYValid) {
        String xAlert = "X Alert: X value must be a valid real number";
        String yAlert = "Y Alert: Y value must be a valid real number";
        if (!isXValid && !isYValid)   displayToChecks(xAlert, yAlert);
        else if (!isXValid)            displayToChecks(xAlert, "");
        else if (!isYValid)            displayToChecks("", yAlert);
    }
}
