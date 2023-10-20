import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.HashMap;

import org.junit.Test;
import java.util.*;

public class TestDataLayer {

    @Test
    public void testGetSetApplications(){
        DataLayer dataLayer = new DataLayer();
        HashMap<UUID,Application> applications = new HashMap<>();
        dataLayer.setApplications(applications);
        assertThat(dataLayer.getApplications(), is(applications));
    }

    public void testGetSetEmails(){
        DataLayer dataLayer = new DataLayer();
        LinkedList<String> emails = new LinkedList<>();
        dataLayer.setEmails(emails);
        assertThat(dataLayer.getEmails(), is(emails));
    }

    public void testGetSetImmigrants(){
        DataLayer dataLayer = new DataLayer();
        HashMap<UUID,NonImmigrantWorker> immigrants = new HashMap<>();
        dataLayer.setImmigrantRegistry(immigrants);
        assertThat(dataLayer.getImmigrantRegistry(), is(immigrants));
    }


    public void testAddApplicationValid(){
        DataLayer dataLayer = new DataLayer();
        Application application = new Application();
        UUID id = new UUID(0,0);
        application.setUuid(id);
        assertThat(dataLayer.addApplication(application), is(true));
    }

    public void testAddApplicationInvalid(){
        DataLayer dataLayer = new DataLayer();
        assertThat(dataLayer.addApplication(null), is(false));
    }

    public void testAddRetrieveApplication(){
        DataLayer dataLayer = new DataLayer();
        Application application = new Application();
        UUID id = new UUID(0, 0);
        application.setUuid(id);
        dataLayer.addApplication(application);
        assertThat(dataLayer.retrieveApplication(id), is(application));
    }
    public void testSendEmail(){
        DataLayer dataLayer = new DataLayer();
        Application application = new Application();
        UUID id = new UUID(0, 0);
        String email = "Test Email";
        application.setUuid(id);
        application.setEmailMessage(email);
        dataLayer.addApplication(application);
        assertThat(dataLayer.sendEmail(id), is(email));
    }
    
}
