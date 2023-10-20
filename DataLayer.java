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
    
    public HashMap<UUID, Application> getApplications() {
        return applications;
    }
    public void setApplications(HashMap<UUID, Application> applications) {
        this.applications = applications;
    }
    public LinkedList<String> getEmails() {
        return emails;
    }
    public void setEmails(LinkedList<String> emails) {
        this.emails = emails;
    }
    public HashMap<String, NonImmigrantWorker> getImmigrantRegistry() {
        return immigrantRegistry;
    }
    public void setImmigrantRegistry(HashMap<String, NonImmigrantWorker> immigrantRegistry) {
        this.immigrantRegistry = immigrantRegistry;
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

