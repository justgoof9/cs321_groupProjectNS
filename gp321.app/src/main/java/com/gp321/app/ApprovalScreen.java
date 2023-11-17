package com.gp321.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApprovalScreen extends JFrame {
    DataLayer dataLayer;
    public ApprovalScreen() {
        //set properties
        setTitle("USCIS Immigration Approval");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //create jpanel
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(10, 2, 10, 10));
        infoPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        //create labels for immigrant information
        JLabel titleLabel = new JLabel("USCIS Immigration Review");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));

        JLabel citizenLabel = new JLabel("Citizen Info");

        JLabel nameLabel = new JLabel("Full Name:");
        JLabel nameValue = new JLabel();

        JLabel dobLabel = new JLabel("Date of Birth:");
        JLabel dobValue = new JLabel();

        JLabel ssnLabel = new JLabel("SSN:");
        JLabel ssnValue = new JLabel();

        JLabel emailLabel = new JLabel("Email:");
        JLabel emailValue = new JLabel();

        JLabel immigranLabel = new JLabel("NonImmigrant Info");

        JLabel immNameLabel = new JLabel("Full Name:");
        JLabel immNameValue = new JLabel();

        JLabel immDobLabel = new JLabel("Date of Birth:");
        JLabel immDobValue = new JLabel();

        JLabel aNumLabel = new JLabel("Alien Number:");
        JLabel aNumValue = new JLabel();

        //add immigrant information to the panel
        infoPanel.add(titleLabel);
        infoPanel.add(new JLabel()); //spacing
        infoPanel.add(citizenLabel);
        infoPanel.add(new JLabel()); //spacing
        infoPanel.add(nameLabel);
        infoPanel.add(nameValue);
        infoPanel.add(dobLabel);
        infoPanel.add(dobValue);
        infoPanel.add(ssnLabel);
        infoPanel.add(ssnValue);
        infoPanel.add(emailLabel);
        infoPanel.add(emailValue);
        infoPanel.add(immigranLabel);
        infoPanel.add(new JLabel()); //spacing
        infoPanel.add(immNameLabel);
        infoPanel.add(immNameValue);
        infoPanel.add(immDobLabel);
        infoPanel.add(immDobValue);
        infoPanel.add(aNumLabel);
        infoPanel.add(aNumValue);

        //add buttons
        JButton approveButton = new JButton("Approve Application");
        JButton getNextApproveButton = new JButton("Request new Application");

        //event handling
        approveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(ApprovalScreen.this, "Getting Next Review");
            }
        });

        getNextApproveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(ApprovalScreen.this, "Approved Application");
            }
        });


        //create panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2, 10, 10));
        buttonPanel.add(approveButton);
        buttonPanel.add(getNextApproveButton);

        //create container for info and buttons
        JPanel containerPanel = new JPanel();
        containerPanel.setLayout(new BorderLayout());
        containerPanel.add(infoPanel, BorderLayout.CENTER);
        containerPanel.add(buttonPanel, BorderLayout.SOUTH);

        //add container
        add(containerPanel);

        //center frame
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ApprovalScreen frame = new ApprovalScreen();
                frame.setVisible(true);
            }
        });
    }
}
