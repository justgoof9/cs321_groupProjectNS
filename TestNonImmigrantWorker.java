import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

public class TestNonImmigrantWorker {
    @Test
    public void testGetSetgetFirstName (){
        NonImmigrantWorker worker = new NonImmigrantWorker();
        String name = "testName";
        worker.setFirstName(name);
        assertThat(worker.getFirstName(), is(name));
    }

    @Test
    public void testGetSetLastName(){
        NonImmigrantWorker worker = new NonImmigrantWorker();
        String name = "testName";
        worker.setLastName(name);
        assertThat(worker.getLastName(), is(name));
    }

    @Test
    public void testGetSetDob(){
        NonImmigrantWorker worker = new NonImmigrantWorker();
        String name = "testName";
        worker.setDob(name);
        assertThat(worker.getDob(), is(name));
    }

    @Test
    public void testGetSetAnumber(){
        NonImmigrantWorker worker = new NonImmigrantWorker();
        String name = "testName";
        worker.setANumber(name);
        assertThat(worker.getANumber(), is(name));
    }

}
