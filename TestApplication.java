import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.*;
import org.junit.Test;

public class TestApplication {
    @Test
    public void testGetSetAlienApplicant(){
        Application application = new Application();
        NonImmigrantWorker nonImmigrantWorker = new NonImmigrantWorker();
        application.setAlienApplicant(nonImmigrantWorker);
        assertThat(application.getAlienApplicant(), is(nonImmigrantWorker));
    }

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
    public void testGetSetEmailFalse(){
        Application application = new Application();
        application.setEmail(false);
        assertThat(application.getEmail(), is(false));
    }

    public void testGetSetEmailTrue(){
        Application application = new Application();
        application.setEmail(true);
        assertThat(application.getEmail(), is(true));
    }

    public void testToEmailTrue(){
        Application application = new Application();
        application.setEmail(true);
        application.toEmail();
        assertThat(application.getEmail(), is(true));
    }

    public void testToEmailFalse(){
        Application application = new Application();
        application.setEmail(false);
        application.toEmail();
        assertThat(application.getEmail(), is(true));
    }

}