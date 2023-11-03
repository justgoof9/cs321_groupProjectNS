package com.gp321;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApprovalScreen extends JFrame {
    public ApprovalScreen(String firstName, String lastName, String dob, String ssn, String email) {
        setTitle("Approval Screen");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 5, 5));

        panel.add(new JLabel("First Name:"));
        JLabel firstNameLabel = new JLabel(firstName);
        panel.add(firstNameLabel);

        panel.add(new JLabel("Last Name:"));
        JLabel lastNameLabel = new JLabel(lastName);
        panel.add(lastNameLabel);

        panel.add(new JLabel("Date of Birth (YYYY-MM-DD):"));
        JLabel dobLabel = new JLabel(dob);
        panel.add(dobLabel);

        panel.add(new JLabel("SSN:"));
        JLabel ssnLabel = new JLabel(ssn);
        panel.add(ssnLabel);

        panel.add(new JLabel("Email:"));
        JLabel emailLabel = new JLabel(email);
        panel.add(emailLabel);

        JButton approveButton = new JButton("Approve");
        approveButton.setForeground(Color.RED);
        approveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle approval logic here
            }
        });
        panel.add(approveButton);

        JButton getNextReviewButton = new JButton("Get Next Review");
        getNextReviewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle "Get Next Review" logic here
            }
        });
        panel.add(getNextReviewButton);

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ApprovalScreen("John", "Doe", "1990-01-01", "123-45-6789", "john.doe@example.com");
        });
    }
}
