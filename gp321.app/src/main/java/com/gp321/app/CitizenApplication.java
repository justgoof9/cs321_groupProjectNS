
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CitizenApplication extends JFrame {

    private JTextField firstNameField, lastNameField, dobField, ssnField, emailField;
    private JButton submitButton;

    public CitizenApplication() {
        createUI();
    }

    private void createUI() {
        setLayout(new GridLayout(6, 2)); // rows, columns

        // Create text fields
        firstNameField = new JTextField(20);
        lastNameField = new JTextField(20);
        dobField = new JTextField(20);
        ssnField = new JTextField(20);
        emailField = new JTextField(20);

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
        add(new JLabel("SSN:"));
        add(ssnField);
        add(new JLabel("Email:"));
        add(emailField);
        add(submitButton);

        // Set up the frame
        setTitle("Citizen Data Entry");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack(); // Adjusts the window to fit the components
    }

    private void submitData() {
        Citizen citizen = new Citizen();
        citizen.setFirstName(firstNameField.getText());
        citizen.setLastName(lastNameField.getText());
        citizen.setDob(dobField.getText());
        citizen.setSsn(ssnField.getText());
        citizen.setEmail(emailField.getText());

        // For now, we just print the Citizen's information to the console
        System.out.println("Citizen Information:");
        System.out.println("First Name: " + citizen.getFirstName());
        System.out.println("Last Name: " + citizen.getLastName());
        System.out.println("DOB: " + citizen.getDob());
        System.out.println("SSN: " + citizen.getSsn());
        System.out.println("Email: " + citizen.getEmail());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CitizenApplication().setVisible(true);
            }
        });
package com.gp321.app;
    }
}
