package com.gp321.app;

import javax.swing.*;
import java.awt.*;
import java.util.UUID;

public class ApprovalScreen extends JFrame {
    DataLayer dataLayer;

    public ApprovalScreen() {
        dataLayer = new DataLayer();

        setTitle("USCIS Immigration Approval");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel infoPanel = new JPanel(new GridLayout(12, 2, 10, 10));
        infoPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titleLabel = new JLabel("USCIS Immigration Approval", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));

        // Labels for sections
        JLabel citizenLabel = new JLabel("Citizen Info:");
        JLabel nonImmigrantLabel = new JLabel("Nonimmigrant Info:");

        // Create JTextAreas for display
        JTextArea citizenNameValue = createNonEditableTextArea();
        JTextArea citizenDobValue = createNonEditableTextArea();
        JTextArea citizenSsnValue = createNonEditableTextArea();
        JTextArea citizenEmailValue = createNonEditableTextArea();

        JTextArea nonImmigrantNameValue = createNonEditableTextArea();
        JTextArea nonImmigrantDobValue = createNonEditableTextArea();
        JTextArea nonImmigrantANumberValue = createNonEditableTextArea();

        // Adding components to the panel
        infoPanel.add(titleLabel);
        infoPanel.add(new JLabel()); // Empty label for spacing
        infoPanel.add(citizenLabel);
        infoPanel.add(new JLabel()); // Empty label for spacing
        addField(infoPanel, "Full Name:", citizenNameValue);
        addField(infoPanel, "Date of Birth:", citizenDobValue);
        addField(infoPanel, "SSN:", citizenSsnValue);
        addField(infoPanel, "Email:", citizenEmailValue);
        infoPanel.add(nonImmigrantLabel);
        infoPanel.add(new JLabel()); // Empty label for spacing
        addField(infoPanel, "Full Name:", nonImmigrantNameValue);
        addField(infoPanel, "Date of Birth:", nonImmigrantDobValue);
        addField(infoPanel, "Alien Number:", nonImmigrantANumberValue);

        add(infoPanel);
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ApprovalScreen frame = new ApprovalScreen();
            frame.setVisible(true);
        });
    }
}
