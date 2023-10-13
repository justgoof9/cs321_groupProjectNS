import java.util.HashMap;
import java.util.LinkedList;
import java.util.UUID;

public class DataLayer {
    private HashMap<UUID,Application> applications;
    private LinkedList<String> emails;
    private HashMap<String,NonImmigrantWorker> immigrantRegistry;

    public DataLayer(){
        this.applications = new HashMap<>();
        this.emails = new LinkedList<>();
        this.immigrantRegistry = new HashMap<>();
    }

    public Application retrieveApplication(UUID id){
        return null;
    }

    public String sendEmail(UUID id){
        return null;
    }

    public boolean addApplication(Application application){
        return false;
    }
}

