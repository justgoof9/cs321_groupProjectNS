package com.gp321.app;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReviewScreen extends JFrame {

    public ReviewScreen() {
        // Create a button with text "Click Me"
        JButton button = new JButton("Click Me");
        

        // Create a panel to hold the button
        JPanel panel = new JPanel();
        panel.add(button);

        // Add the panel to the frame
        this.add(panel);

        // Set up the frame
        this.setSize(300, 200); // Set the size of the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set the default close operation
        this.setTitle("Simple GUI Application"); // Set the title of the frame
    }

    public static void main(String[] args) {
        // Schedule a job for the event dispatch thread: creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Create and display the GUI.
                ReviewScreen frame = new ReviewScreen();
                frame.setVisible(true);
            }
        });
    }
}
