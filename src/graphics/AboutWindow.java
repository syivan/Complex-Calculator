package graphics;

import javax.swing.*;
import java.awt.*;

/**
 * the about window is generated for basic information on the author of this code, which is Ivan Sy,
 * giving quick information on name, school year, and interests and hobbies
 * @author Ivan Sy
 * @version 11/20/2021
 */
public class AboutWindow extends JFrame {

    private JPanel windowPanel;

    /**
     * initializes the frame and all components the help window contains
     */
    AboutWindow() {
        initializeFrame();
        initializePanel();
        initializeDisplay();
        setVisible(true);
    }

    private void initializeFrame() {
        this.setTitle("About who? Me.");
        this.setLayout(new GridBagLayout());
        this.getContentPane().setBackground(Color.ORANGE);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setSize(500,400);
    }

    private void initializePanel() {
        windowPanel = new JPanel();
        windowPanel.setBackground(Color.PINK);
        windowPanel.setLayout(new GridLayout(4,1));
        this.add(windowPanel);
    }

    private void initializeDisplay() {
        JLabel author = new JLabel("Author: Ivan Sy");
        JLabel schoolYear = new JLabel("School Year: Junior 2023");
        JLabel aboutMe = new JLabel("If I'm not coding, I'm a teacher. If not, I'm game developing (planning phase)");
        windowPanel.add(author);
        windowPanel.add(schoolYear);
        windowPanel.add(aboutMe);
    }

}
