package com.gp321.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

/**
 * This class represents a GUI-based application for collecting and processing 
 * information for both Citizen and NonImmigrantWorker applicants. It integrates 
 * the functionalities of data entry, application creation, and interaction with 
 * workflow and data layers.
 */
public class CombinedApplication extends JFrame {

    DataLayer dataLayer; // Represents the data layer for database interactions
    Workflow workFlow; // Represents the workflow layer for business processes

    // GUI components for Citizen data entry
    private JTextField firstNameFieldCitizen, lastNameFieldCitizen, dobFieldCitizen, ssnField, emailField;

    // GUI components for NonImmigrantWorker data entry
    private JTextField firstNameFieldWorker, lastNameFieldWorker, dobFieldWorker, aNumberField;

    private JButton submitButton; // Button to submit the application


    /**
     * Constructs the CombinedApplication frame with initialized data and workflow layers,
     * and sets up the user interface.
     */
    public CombinedApplication() {
        dataLayer = new DataLayer();
        workFlow = new Workflow();
        createUI();
    }

    /**
     * Initializes and arranges the GUI components for the application.
     * This method sets up the main panel with two separate sections for 
     * Citizen and NonImmigrantWorker data entry.
     */
    private void createUI() {
        // Main panel with BoxLayout for horizontal arrangement
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));

        // Panel for Citizen fields
        JPanel citizenPanel = new JPanel();
        citizenPanel.setLayout(new GridLayout(6, 2)); // Grid for structured layout
        addComponentsToPanel(citizenPanel, true);

        // Panel for Worker fields
        JPanel workerPanel = new JPanel();
        workerPanel.setLayout(new GridLayout(5, 2)); // Grid for structured layout
        addComponentsToPanel(workerPanel, false);

        // Adding both panels to the main panel
        mainPanel.add(citizenPanel);
        mainPanel.add(Box.createHorizontalStrut(10)); // Spacer for separation
        mainPanel.add(workerPanel);

        // Adding the main panel to the frame
        add(mainPanel);

        // Set up the frame
        setTitle("Combined Data Entry");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack(); // Adjusts the window to fit the components
    }


    /**
     * Adds components to a specified panel for either Citizen or NonImmigrantWorker.
     * It initializes and arranges text fields and labels within the given panel.
     *
     * @param panel The panel where components are added.
     * @param isCitizen Boolean flag to determine if the panel is for a Citizen (true) or a NonImmigrantWorker (false).
     */
    private void addComponentsToPanel(JPanel panel, boolean isCitizen) {
        if (isCitizen) {
            // Initialize Citizen components
            firstNameFieldCitizen = new JTextField(20);
            lastNameFieldCitizen = new JTextField(20);
            dobFieldCitizen = new JTextField(20);
            ssnField = new JTextField(20);
            emailField = new JTextField(20);

            // Add Citizen components
            panel.add(new JLabel("Citizen - First Name:"));
            panel.add(firstNameFieldCitizen);
            panel.add(new JLabel("Citizen - Last Name:"));
            panel.add(lastNameFieldCitizen);
            panel.add(new JLabel("Citizen - Date of Birth (YYYY-MM-DD):"));
            panel.add(dobFieldCitizen);
            panel.add(new JLabel("Citizen - SSN:"));
            panel.add(ssnField);
            panel.add(new JLabel("Citizen - Email:"));
            panel.add(emailField);
        } else {
            // Initialize Worker components
            firstNameFieldWorker = new JTextField(20);
            lastNameFieldWorker = new JTextField(20);
            dobFieldWorker = new JTextField(20);
            aNumberField = new JTextField(20);

            // Add Worker components
            panel.add(new JLabel("Worker - First Name:"));
            panel.add(firstNameFieldWorker);
            panel.add(new JLabel("Worker - Last Name:"));
            panel.add(lastNameFieldWorker);
            panel.add(new JLabel("Worker - Date of Birth (YYYY-MM-DD):"));
            panel.add(dobFieldWorker);
            panel.add(new JLabel("Worker - A-Number:"));
            panel.add(aNumberField);
        }

        // Add the submit button only if it's a Citizen panel
        if (isCitizen) {
            submitButton = new JButton("Submit");
            submitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    submitData();
                }
            });
            panel.add(submitButton);
        }
    }

    /**
     * Handles the submission of data entered in the GUI. This method creates
     * and processes Citizen, NonImmigrantWorker, and Application objects,
     * and then interacts with the workflow and data layers for further processing.
     */
    private void submitData() {
    // Creating Citizen object
    Citizen citizen = new Citizen();
    citizen.setFirstName(firstNameFieldCitizen.getText());
    citizen.setLastName(lastNameFieldCitizen.getText());
    citizen.setDob(dobFieldCitizen.getText());
    citizen.setSsn(ssnField.getText());
    citizen.setEmail(emailField.getText());

    // Creating NonImmigrantWorker object
    NonImmigrantWorker worker = new NonImmigrantWorker();
    worker.setFirstName(firstNameFieldWorker.getText());
    worker.setLastName(lastNameFieldWorker.getText());
    worker.setDob(dobFieldWorker.getText());
    worker.setANumber(aNumberField.getText());

    // Creating Application object
    Application application = new Application();
    application.setCitizenApplicant(citizen);
    application.setAlienApplicant(worker);
    application.setUuid(UUID.randomUUID()); // Generating a random UUID for the application

    workFlow.addReview(application.getUUID());

    dataLayer.addApplication(application);
    dataLayer.writeOut();
    workFlow.writeOut();

   
    
    System.out.println("Application created with Citizen and Non-Immigrant Worker data.");
}

    /**
     * The main entry point for the CombinedApplication. This method initializes
     * and displays the GUI.
     *
     * @param args Command line arguments, if used (not in our case)
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CombinedApplication().setVisible(true);
            }
        });
    }
}
