import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

public class TestCitizen {
    //test Citizen class
    @Test
    public void testGetSetFirstName(){
        Citizen citizen = new Citizen();
        String name = "testName";
        citizen.setFirstName(name);
        assertThat(citizen.getFirstName(), is(name));
    }
    

    
}
