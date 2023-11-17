package com.gp321.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NonImmigrantWorkerApplication extends JFrame {

    private JTextField firstNameField, lastNameField, dobField, aNumberField;
    private JButton submitButton;

    public NonImmigrantWorkerApplication() {
        createUI();
    }

    private void createUI() {
        setLayout(new GridLayout(5, 2)); // rows, columns

        // Create text fields
        firstNameField = new JTextField(20);
        lastNameField = new JTextField(20);
        dobField = new JTextField(20);
        aNumberField = new JTextField(20);

        // Create submit button
        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitData();
            }
        });

        // Add components to the frame
        add(new JLabel("First Name:"));
        add(firstNameField);
        add(new JLabel("Last Name:"));
        add(lastNameField);
        add(new JLabel("Date of Birth (YYYY-MM-DD):"));
        add(dobField);
        add(new JLabel("A-Number:"));
        add(aNumberField);
        add(submitButton);

        // Set up the frame
        setTitle("Non-Immigrant Worker Data Entry");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack(); // Adjusts the window to fit the components
    }

    private void submitData() {
        NonImmigrantWorker worker = new NonImmigrantWorker();
        worker.setFirstName(firstNameField.getText());
        worker.setLastName(lastNameField.getText());
        worker.setDob(dobField.getText());
        worker.setANumber(aNumberField.getText());

        // For now, we just print the Worker's information to the console
        System.out.println("Non-Immigrant Worker Information:");
        System.out.println("First Name: " + worker.getFirstName());
        System.out.println("Last Name: " + worker.getLastName());
        System.out.println("DOB: " + worker.getDob());
        System.out.println("A-Number: " + worker.getANumber());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new NonImmigrantWorkerApplication().setVisible(true);
            }
        });
    }
}
