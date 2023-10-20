import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.UUID;

import org.junit.Test;

public class TestApplication {
    //test Citizen class
    @Test
    public void testGetSetUUID(){
        Application app = new Application();
        UUID id = 21;
        app.setUuid(id);
        
    }
    public void testGetSetEmail(){
        Citizen citizen = new Citizen();
        String name = "testName";
        citizen.setFirstName(name);
        assertThat(citizen.getFirstName(), is(name));
    }

    
}