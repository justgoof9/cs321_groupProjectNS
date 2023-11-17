package com.gp321.app;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.UUID;
import java.io.*;
import java.util.*;

public class DataLayer {
    private HashMap<UUID,Application> applications;             //hashmap of applications
    private LinkedList<String> emails;                          //list of emails to be sent
    private HashMap<String,NonImmigrantWorker> immigrantRegistry; //registry of nonimmigrant applicants already applied

    public DataLayer(){
        this.applications = new HashMap<>();
        this.emails = new LinkedList<>();
        this.immigrantRegistry = new HashMap<>();
        setValues();
    }
    private void setValues(){
        File file;
        Scanner scanner;
        String next;
        String[] data;
        Application application = new Application();
        Citizen citizen = new Citizen();
        NonImmigrantWorker nonImmigrantWorker = new NonImmigrantWorker();
        try{
            file = new File("../resources/datalayer.csv");
            scanner = new Scanner(file);

            while(scanner.hasNextLine()){
                next = scanner.nextLine();
                data = next.split(",");
                application.setUuid(UUID.fromString(data[0]));
                citizen.setFirstName(data[2]);
                citizen.setLastName(data[3]);
                citizen.setDob(data[4]);
                citizen.setSsn(data[5]);
                citizen.setEmail(data[6]);
                nonImmigrantWorker.setFirstName(data[7]);
                nonImmigrantWorker.setLastName(data[8]);
                nonImmigrantWorker.setDob(data[9]);
                nonImmigrantWorker.setANumber(data[10]);
                application.setCitizenApplicant(citizen);
                application.setAlienApplicant(nonImmigrantWorker);
                applications.put(application.getUUID(),application);
            }
            scanner.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
    //getters and setters
    public HashMap<UUID, Application> getApplications() {
        return applications;
    }
    public void setApplications(HashMap<UUID, Application> applications) {
        this.applications = applications;
    }
    public LinkedList<String> getEmails() {
        return emails;
    }
    public void setEmails(LinkedList<String> emails) {
        this.emails = emails;
    }
    public HashMap<String, NonImmigrantWorker> getImmigrantRegistry() {
        return immigrantRegistry;
    }
    public void setImmigrantRegistry(HashMap<String, NonImmigrantWorker> immigrantRegistry) {
        this.immigrantRegistry = immigrantRegistry;
    }

    //end getters and setters

    //retrieve application from id passed in
    public Application retrieveApplication(UUID id){
        return applications.get(id);
    }

    //return email message associated with application id
    public String sendEmail(UUID id){
        return applications.get(id).getEmailMessage();
    }

    //add application to map
    public boolean addApplication(Application application){
        if(application!=null){
            applications.put(application.getUUID(), application);
            return true;
        }
        return false;
    }

}

