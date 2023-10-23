package com.gp321.app;

import java.util.UUID;

public class Application{
    private UUID applicationId;                 //application id
    private boolean toEmail;                    //variable determines if an application has an email to send
    private Citizen citizenApplicant;           //Citizen associated with application
    private NonImmigrantWorker alienApplicant;  //nonimmigrant associated with application
    private String emailMessage;                //email to be sent

    //Getters and setters
    public void setEmailMessage(String emailMessage) {
        this.emailMessage = emailMessage;
    }

    public void setAlienApplicant(NonImmigrantWorker alienApplicant) {
        this.alienApplicant = alienApplicant;
    }

    public void setCitizenApplicant(Citizen citizenApplicant) {
        this.citizenApplicant = citizenApplicant;
    }

    public String getEmailMessage() {
        return emailMessage;
    }
    
    public NonImmigrantWorker getAlienApplicant() {
        return alienApplicant;
    }

    public Citizen getCitizenApplicant() {
        return citizenApplicant;
    }

    public void setUuid(UUID id) {
        this.applicationId = id;
    }
    public void setEmail(boolean toEmail) {
        this.toEmail = toEmail;
    }
    public UUID getUUID() {
        return applicationId;
    }
    public boolean getEmail() {
        return toEmail;
    }
    //end getters and setters
    
    //set toEmail variable to true
    public boolean toEmail() {
        toEmail = true;
        return toEmail;
    }

}
