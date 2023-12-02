package com.gp321.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReviewScreen extends JFrame {
    DataLayer dataLayer;
    Workflow workflow;
    Application application;
    public ReviewScreen() {
        dataLayer = new DataLayer(null);
        workflow = new Workflow(null);
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
        JTextArea nameValue = new JTextArea();

        JLabel dobLabel = new JLabel("Date of Birth:");
        JTextArea dobValue = new JTextArea();

        JLabel ssnLabel = new JLabel("SSN:");
        JTextArea ssnValue = new JTextArea();

        JLabel emailLabel = new JLabel("Email:");
        JTextArea emailValue = new JTextArea();

        JLabel immigrantLabel = new JLabel("NonImmigrant Info");

        JLabel immNameLabel = new JLabel("Full Name:");
        JTextArea immNameValue = new JTextArea();

        JLabel immDobLabel = new JLabel("Date of Birth:");
        JTextArea immDobValue = new JTextArea();

        JLabel aNumLabel = new JLabel("Alien Number:");
        JTextArea aNumValue = new JTextArea();

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
        infoPanel.add(immigrantLabel);
        infoPanel.add(new JLabel()); //spacing
        infoPanel.add(immNameLabel);
        infoPanel.add(immNameValue);
        infoPanel.add(immDobLabel);
        infoPanel.add(immDobValue);
        infoPanel.add(aNumLabel);
        infoPanel.add(aNumValue);

        //add buttons
        JButton getNextReview = new JButton("Get Next Review");

        JButton performValidation = new JButton("Perform Validation");

        JButton reviewed = new JButton("Reviewed");

        JButton sendEmailButton = new JButton("Send Email");

        //event handling
        getNextReview.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                application = dataLayer.retrieveApplication(workflow.retrieveReview());
                Citizen citizen = application.getCitizenApplicant();
                NonImmigrantWorker nonImmigrantWorker = application.getAlienApplicant();
                nameValue.setText(citizen.getFirstName()+' '+citizen.getLastName());
                dobValue.setText(citizen.getDob());
                ssnValue.setText(citizen.getSsn());
                emailValue.setText(citizen.getEmail());
                immNameValue.setText(nonImmigrantWorker.getFirstName()+' '+nonImmigrantWorker.getLastName());
                immDobValue.setText(nonImmigrantWorker.getDob());
                aNumValue.setText(nonImmigrantWorker.getANumber());

            }
        });

        performValidation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!dataLayer.immigrantExists(aNumValue.getText())){
                    JOptionPane.showMessageDialog(ReviewScreen.this, "Application Validation Failed aNum Exists");
                }
                else{
                    JOptionPane.showMessageDialog(ReviewScreen.this, "Application Reviewed");
                }
            }
        });

        reviewed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                workflow.addApproval(application.getUUID());
                workflow.writeOut(null);
                dataLayer.writeOut(null);
                JOptionPane.showMessageDialog(ReviewScreen.this, "Added to Approval");
            }
        });

        sendEmailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(ReviewScreen.this, "Added to Approval");
            }
            
        });

        //create panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2, 10, 10));
        buttonPanel.add(getNextReview);
        buttonPanel.add(performValidation);
        buttonPanel.add(reviewed);
        buttonPanel.add(sendEmailButton);
        
        //create container for info and buttons
        JPanel containerPanel = new JPanel();
        containerPanel.setLayout(new BorderLayout());
        containerPanel.add(infoPanel, BorderLayout.CENTER);
        containerPanel.add(buttonPanel, BorderLayout.SOUTH);

        //add container
        add(containerPanel);

        //center fram
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ReviewScreen frame = new ReviewScreen();
                frame.setVisible(true);
            }
        });
    }
}
