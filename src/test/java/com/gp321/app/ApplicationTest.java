package com.gp321.app;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.beans.Transient;
import java.util.*;
import org.junit.Test;

public class ApplicationTest {
    @Test
    public void testGetSetAlienApplicant(){
        Application application = new Application();
        NonImmigrantWorker nonImmigrantWorker = new NonImmigrantWorker();
        application.setAlienApplicant(nonImmigrantWorker);
        assertThat(application.getAlienApplicant(), is(nonImmigrantWorker));
    }

    @Test
    public void testGetSetCitizenApplicant(){
        Application application = new Application();
        Citizen citizen = new Citizen();
        application.setCitizenApplicant(citizen);
        assertThat(application.getCitizenApplicant(),is(citizen));
    }
    @Test
    public void testGetSetUUID(){
        Application app = new Application();
        UUID id = new UUID(0, 0);
        app.setUuid(id);
        assertThat(app.getUUID(), is(id));
    }

    @Test
    public void testGetSetEmailFalse(){
        Application application = new Application();
        application.setEmail(false);
        assertThat(application.getEmail(), is(false));
    }

    @Test
    public void testGetSetEmailTrue(){
        Application application = new Application();
        application.setEmail(true);
        assertThat(application.getEmail(), is(true));
    }

    @Test
    public void testToEmailTrue(){
        Application application = new Application();
        application.setEmail(true);
        application.toEmail();
        assertThat(application.getEmail(), is(true));
    }

    @Test
    public void testToEmailFalse(){
        Application application = new Application();
        application.setEmail(false);
        application.toEmail();
        assertThat(application.getEmail(), is(true));
    }

    @Test
    public void testGetSetEmailMessage(){
        Application application = new Application();
        String email = "Test Email";
        application.setEmailMessage(email);
        assertThat(application.getEmailMessage(), is(email));
    }

}