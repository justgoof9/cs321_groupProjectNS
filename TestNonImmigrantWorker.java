// Importing required static methods from the Hamcrest library to aid in testing.
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

/**
 * Test class for verifying the functionality of the NonImmigrantWorker class methods.
 */
public class TestNonImmigrantWorker {

    /**
     * Test to verify that the setFirstName() and getFirstName() methods
     * of the NonImmigrantWorker class function correctly.
     */
    @Test
    public void testGetSetFirstName() {
        NonImmigrantWorker worker = new NonImmigrantWorker();  // Creating an instance of NonImmigrantWorker.
        String name = "testName";
        worker.setFirstName(name);  // Setting the first name.
        // Asserting that the first name set is the same as the one retrieved.
        assertThat(worker.getFirstName(), is(name));
    }

    /**
     * Test to verify that the setLastName() and getLastName() methods
     * of the NonImmigrantWorker class function correctly.
     */
    @Test
    public void testGetSetLastName() {
        NonImmigrantWorker worker = new NonImmigrantWorker();  // Creating an instance of NonImmigrantWorker.
        String name = "testName";
        worker.setLastName(name);  // Setting the last name.
        // Asserting that the last name set is the same as the one retrieved.
        assertThat(worker.getLastName(), is(name));
    }

    /**
     * Test to verify that the setDob() and getDob() methods
     * of the NonImmigrantWorker class function correctly.
     */
    @Test
    public void testGetSetDob() {
        NonImmigrantWorker worker = new NonImmigrantWorker();  // Creating an instance of NonImmigrantWorker.
        String name = "testName";
        worker.setDob(name);  // Setting the date of birth.
        // Asserting that the date of birth set is the same as the one retrieved.
        assertThat(worker.getDob(), is(name));
    }

    /**
     * Test to verify that the setANumber() and getANumber() methods
     * of the NonImmigrantWorker class function correctly.
     */
    @Test
    public void testGetSetAnumber() {
        NonImmigrantWorker worker = new NonImmigrantWorker();  // Creating an instance of NonImmigrantWorker.
        String name = "testName";
        worker.setANumber(name);  // Setting the A-number.
        // Asserting that the A-number set is the same as the one retrieved.
        assertThat(worker.getANumber(), is(name));
    }

}