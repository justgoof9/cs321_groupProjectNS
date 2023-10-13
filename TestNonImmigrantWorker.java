import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

public class TestNonImmigrantWorker {
    @Test
    public void testIgetFirstName (){
        NonImmigrantWorker worker = new NonImmigrantWorker();
        String name = "testName";
        worker.setFirstName(name);
        assertThat(worker.getFirstName(), is(name));
    }

    @Test
    public void testGetSetLastName(){
        Citizen citizen = new Citizen();
        String name = "testName";
        citizen.setLastName(name);
        assertThat(citizen.getLastName(), is(name));
    }

    @Test
    public void testGetSetDob(){
        Citizen citizen = new Citizen();
        String name = "testName";
        citizen.setDob(name);
        assertThat(citizen.getDob(), is(name));
    }

    @Test
    public void testGetSetSsn(){
        Citizen citizen = new Citizen();
        String name = "testName";
        citizen.setSsn(name);
        assertThat(citizen.getSsn(), is(name));
    }

    @Test
    public void testGetSetEmail(){
        Citizen citizen = new Citizen();
        String name = "testName";
        citizen.setEmail(name);
        assertThat(citizen.getEmail(), is(name));
    }
}
