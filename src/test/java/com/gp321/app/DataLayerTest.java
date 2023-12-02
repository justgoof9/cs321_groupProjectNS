package com.gp321.app;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.io.FileWriter;
import java.util.HashMap;

import org.junit.Test;
import java.util.*;

public class DataLayerTest {

    private String path = "testDataLayer.csv";
    private void initializeTestDatalayer(){
        try{
            FileWriter fileWriter = new FileWriter(path,false);
            fileWriter.write(
                    "6bd2b5a6-7a86-4017-8b4a-e90e49811fe6,false,safi,salem,2002-08-30,123456789,email@email,noor,salem,2000-07-15,987654321"
            );
            fileWriter.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void testGetSetApplications(){
        initializeTestDatalayer();
        DataLayer dataLayer = new DataLayer(path);
        HashMap<UUID,Application> applications = new HashMap<>();
        dataLayer.setApplications(applications);
        assertThat(dataLayer.getApplications(), is(applications));
    }

    @Test
    public void testGetSetEmails(){
        DataLayer dataLayer = new DataLayer(path);
        LinkedList<String> emails = new LinkedList<>();
        dataLayer.setEmails(emails);
        assertThat(dataLayer.getEmails(), is(emails));
    }

    @Test
    public void testGetSetImmigrants(){
        DataLayer dataLayer = new DataLayer(path);
        HashMap<String,NonImmigrantWorker> immigrants = new HashMap<>();
        dataLayer.setImmigrantRegistry(immigrants);
        assertThat(dataLayer.getImmigrantRegistry(), is(immigrants));
    }

    @Test
    public void testAddApplicationValid(){
        DataLayer dataLayer = new DataLayer(path);
        Application application = new Application();
        UUID id = new UUID(0,0);
        application.setUuid(id);
        assertThat(dataLayer.addApplication(application), is(true));
    }

    public void testAddApplicationInvalid(){
        DataLayer dataLayer = new DataLayer(path);
        assertThat(dataLayer.addApplication(null), is(false));
    }

    @Test
    public void testAddRetrieveApplication(){
        DataLayer dataLayer = new DataLayer(path);
        Application application = new Application();
        UUID id = new UUID(0, 0);
        application.setUuid(id);
        dataLayer.addApplication(application);
        assertThat(dataLayer.retrieveApplication(id), is(application));
    }

    @Test
    public void testSendEmail(){
        DataLayer dataLayer = new DataLayer(path);
        Application application = new Application();
        UUID id = new UUID(0, 0);
        String email = "Test Email";
        application.setUuid(id);
        application.setEmailMessage(email);
        dataLayer.addApplication(application);
        assertThat(dataLayer.sendEmail(id), is(email));
    }

    @Test
    public void testConstructor(){
        initializeTestDatalayer();
        DataLayer dataLayer = new DataLayer(path);
        assertThat(dataLayer.retrieveApplication(UUID.fromString("6bd2b5a6-7a86-4017-8b4a-e90e49811fe6")).getCitizenApplicant().getFirstName(),is("safi"));
    }

    @Test
    public void testWriteOut(){
        initializeTestDatalayer();
        DataLayer dataLayer = new DataLayer(path);
        Application application = new Application();
        Citizen citizen = new Citizen();
        NonImmigrantWorker niw = new NonImmigrantWorker();
        UUID id = new UUID(0,0);
        citizen.setDob("dob");
        citizen.setEmail("email");
        citizen.setFirstName("cfirst");
        citizen.setLastName("clast");
        citizen.setSsn("ssn");
        niw.setDob("idob");
        niw.setFirstName("ifirst");
        niw.setLastName("ilast");
        niw.setANumber("anum");
        application.setAlienApplicant(niw);
        application.setCitizenApplicant(citizen);
        application.setUuid(id);
        dataLayer.getApplications().clear();
        dataLayer.addApplication(application);
        dataLayer.writeOut(path);
        dataLayer = new DataLayer(path);
        assertThat(dataLayer.retrieveApplication(id).getUUID(),is(id));
        assertThat(dataLayer.retrieveApplication(id).getAlienApplicant().getFirstName(),is("ifirst"));
        assertThat(dataLayer.retrieveApplication(id).getCitizenApplicant().getFirstName(),is("cfirst"));
    }

    @Test
    public void testImmigrantExists(){
        initializeTestDatalayer();
        DataLayer dataLayer = new DataLayer(path);
        assertThat(dataLayer.immigrantExists("987654321"),is(true));
        assertThat(dataLayer.immigrantExists("00"),is(false));

    }
}
