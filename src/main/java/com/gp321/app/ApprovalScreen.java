package com.gp321.app;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;
import java.util.UUID;

public class ApprovalScreen extends JFrame {
    DataLayer dataLayer;
    Workflow workflow;

    JTextArea citizenNameValue, citizenDobValue, citizenSsnValue, citizenEmailValue;
    JTextArea nonImmigrantNameValue, nonImmigrantDobValue, nonImmigrantANumberValue;

    public ApprovalScreen() {
        dataLayer = new DataLayer(null);
        workflow = new Workflow(null);

        setTitle("USCIS Immigration Approval");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel infoPanel = new JPanel(new GridLayout(12, 2, 10, 10));
        infoPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titleLabel = new JLabel("USCIS Immigration Approval", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        infoPanel.add(titleLabel);
        infoPanel.add(new JLabel());

        // Citizen Information
        JLabel citizenLabel = new JLabel("Citizen Info:");
        infoPanel.add(citizenLabel);
        infoPanel.add(new JLabel());

        citizenNameValue = createNonEditableTextArea();
        addField(infoPanel, "Full Name:", citizenNameValue);

        citizenDobValue = createNonEditableTextArea();
        addField(infoPanel, "Date of Birth:", citizenDobValue);

        citizenSsnValue = createNonEditableTextArea();
        addField(infoPanel, "SSN:", citizenSsnValue);

        citizenEmailValue = createNonEditableTextArea();
        addField(infoPanel, "Email:", citizenEmailValue);

        // Non-Immigrant Worker Information
        JLabel nonImmigrantLabel = new JLabel("Nonimmigrant Info:");
        infoPanel.add(nonImmigrantLabel);
        infoPanel.add(new JLabel());

        nonImmigrantNameValue = createNonEditableTextArea();
        addField(infoPanel, "Full Name:", nonImmigrantNameValue);

        nonImmigrantDobValue = createNonEditableTextArea();
        addField(infoPanel, "Date of Birth:", nonImmigrantDobValue);

        nonImmigrantANumberValue = createNonEditableTextArea();
        addField(infoPanel, "Alien Number:", nonImmigrantANumberValue);

        // Buttons for Approve and Get New Application
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        JButton approveButton = new JButton("Approve");
        JButton newApplicationButton = new JButton("Get New Application");

        approveButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Approved!"));
        newApplicationButton.addActionListener(e -> loadNextApplication());

        buttonPanel.add(approveButton);
        buttonPanel.add(newApplicationButton);

        add(infoPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
    }

    private void addField(JPanel panel, String labelText, JTextArea textArea) {
        panel.add(new JLabel(labelText));
        panel.add(textArea);
    }

    private JTextArea createNonEditableTextArea() {
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        return textArea;
    }

    private void loadNextApplication() {
        UUID id = workflow.retrieveApproval();
        if (id!=null) {
            Application application = dataLayer.retrieveApplication(id);
            updateApplicationData(application);
        } else {
            JOptionPane.showMessageDialog(this, "No more applications available.");
        }
        workflow.writeOut(null);
        dataLayer.writeOut(null);
    }

    private void updateApplicationData(Application application) {
        if (application != null) {
            Citizen citizen = application.getCitizenApplicant();
            NonImmigrantWorker nonImmigrant = application.getAlienApplicant();

            citizenNameValue.setText(citizen.getFirstName() + " " + citizen.getLastName());
            citizenDobValue.setText(citizen.getDob());
            citizenSsnValue.setText(citizen.getSsn());
            citizenEmailValue.setText(citizen.getEmail());

            nonImmigrantNameValue.setText(nonImmigrant.getFirstName() + " " + nonImmigrant.getLastName());
            nonImmigrantDobValue.setText(nonImmigrant.getDob());
            nonImmigrantANumberValue.setText(nonImmigrant.getANumber());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ApprovalScreen frame = new ApprovalScreen();
            frame.setVisible(true);
        });
    }
}
