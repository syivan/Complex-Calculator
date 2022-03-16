package graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The main window is built here along with its two menu components, Help and Calculator,
 * and is where the primary window where the user interacts on will be based
 * @author Ivan Sy
 * @version 11/20/2021
 */
public class MainWindow extends JFrame implements ActionListener{

    private JLabel introLabel;
    private ImageIcon introImage;
    private JMenuBar menuBar;
    private JMenu calculatorMenu;
    private JMenu aboutMenu;
    private JMenuItem binaryItem;
    private JMenuItem hexItem;
    private JMenuItem bigNumberItem;
    private JMenuItem aboutItem;

    /**
     * All components of the Frame window is built here
     */
    public MainWindow() {
        initializeIntro();
        initializeFrame();
        initializeMenuBar();
        this.setVisible(true);
    }

    //Initializes the frame (title, size)
    private void initializeFrame() {
        this.setTitle("The Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,600);
        this.add(introLabel);
    }

    //Initializes the intro, showing a fish and a preparation statement for my user
    private void initializeIntro() {
        introLabel = new JLabel();
        introLabel.setText("Are you ready to Calculate?");
        introImage = new ImageIcon(new ImageIcon("fish.png").getImage().getScaledInstance(200,200, Image.SCALE_DEFAULT));
        introLabel.setIcon(introImage);
        introLabel.setHorizontalTextPosition(JLabel.CENTER);
        introLabel.setVerticalTextPosition(JLabel.TOP);
        introLabel.setFont(new Font("Serif", Font.BOLD, 20));
        introLabel.setIconTextGap(30);
        introLabel.setBackground(new Color(229,224,255));
        introLabel.setOpaque(true);
        introLabel.setVerticalAlignment(JLabel.CENTER);
        introLabel.setHorizontalAlignment(JLabel.CENTER);
    }

    //initializes the menu bar, containing an about section and a Calculator choice section
    private void initializeMenuBar() {
        menuBar = new JMenuBar();
        calculatorMenu = new JMenu("Calculator");
        aboutMenu = new JMenu("About");
        menuBar.add(calculatorMenu);
        menuBar.add(aboutMenu);
        aboutMenu.addActionListener(this);
        this.setJMenuBar(menuBar);
        initializeMenuItems();
    }

    private void initializeMenuItems() {
        binaryItem = new JMenuItem("Binary Calculator");
        hexItem = new JMenuItem("Hexadecimal Calculator");
        bigNumberItem = new JMenuItem("Big Number Calculator");
        aboutItem = new JMenuItem("About");
        binaryItem.addActionListener(this);
        hexItem.addActionListener(this);
        bigNumberItem.addActionListener(this);
        aboutItem.addActionListener(this);
        calculatorMenu.add(binaryItem);
        calculatorMenu.add(hexItem);
        calculatorMenu.add(bigNumberItem);
        aboutMenu.add(aboutItem);
    }

    /**
     * When a user clicks one of the menu items to choose calculator or about section, they will be
     * prompted to the desired functional calculator or About section window
     * @param e encompasses the menu items to declare action
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == binaryItem) {
            new BinaryWindow(this);
        }
        else if (e.getSource() == hexItem) {
            new HexWindow(this);
        }
        else if (e.getSource() == bigNumberItem) {
            new BigNumberWindow(this);
        }
        else if (e.getSource() == aboutItem) {
            new AboutWindow();
        }
    }

}
