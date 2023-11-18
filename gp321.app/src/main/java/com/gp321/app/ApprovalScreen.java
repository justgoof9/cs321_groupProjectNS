package com.gp321.app;

import javax.swing.*;
import java.awt.*;
import java.util.UUID; // Import UUID class here


public class ApprovalScreen extends JFrame {
    DataLayer dataLayer;

    public ApprovalScreen() {

        //initalizing dataLayer.
        dataLayer = new DataLayer();
        // Setting the title of the JFrame
        setTitle("USCIS Immigration Approval");

        // Setting the layout
        setLayout(new BorderLayout()); // Use BorderLayout

        // Creating the title label
        JLabel titleLabel = new JLabel("USCIS Immigration Review", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));

        // Adding the title label to the top
        add(titleLabel, BorderLayout.NORTH);

        // Creating a panel with GridLayout for the other labels
        JPanel gridPanel = new JPanel(new GridLayout(10, 2)); // 10 rows, 2 columns

              // Assuming you want to display the first application's data
            //   UUID firstKey = dataLayer.getApplications().keySet().iterator().next();
            //   Application firstApplication = dataLayer.getApplications().get(firstKey);
      
            //   // Check if there is an application available
            //   if (firstApplication != null) {
            //       Citizen citizen = firstApplication.getCitizenApplicant();
            //       NonImmigrantWorker nonImmigrant = firstApplication.getAlienApplicant();
      
            //       // Adding labels and corresponding data for citizen
            //       addLabelAndData(gridPanel, "Citizen First Name:", citizen.getFirstName());
            //       addLabelAndData(gridPanel, "Citizen Date of Birth:", citizen.getDob());
            //       addLabelAndData(gridPanel, "Citizen SSN:", citizen.getSsn());
            //       addLabelAndData(gridPanel, "Citizen Email:", citizen.getEmail());
      
            //       // Adding labels and corresponding data for non-immigrant worker
            //       addLabelAndData(gridPanel, "Nonimmigrant First Name:", nonImmigrant.getFirstName());
            //       addLabelAndData(gridPanel, "Nonimmigrant Date of Birth:", nonImmigrant.getDob());
            //       addLabelAndData(gridPanel, "Nonimmigrant Alien Number:", nonImmigrant.getANumber());
            //   }

        // Adding the grid panel to the center
        add(gridPanel, BorderLayout.CENTER);

        // Set default close operation and window size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
    }
    // public void addLabelAndData(JPanel panel, String labelText, String dataText) {
    //     panel.add(new JLabel(labelText));
    //     panel.add(new JLabel(dataText));
    // }

    public static void main(String[] args) {
        // Running the form
        SwingUtilities.invokeLater(() -> {
            new ApprovalScreen().setVisible(true);
        });
    }
}