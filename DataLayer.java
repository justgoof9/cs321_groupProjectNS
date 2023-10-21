import java.util.HashMap;
import java.util.LinkedList;
import java.util.UUID;

public class DataLayer {
    private HashMap<UUID,Application> applications;             //hashmap of applications
    private LinkedList<String> emails;                          //list of emails to be sent
    private HashMap<String,NonImmigrantWorker> immigrantRegistry; //registry of nonimmigrant applicants already applied

    public DataLayer(){
        this.applications = new HashMap<>();
        this.emails = new LinkedList<>();
        this.immigrantRegistry = new HashMap<>();
    }
    
    //getters and setters
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

    //end getters and setters

    //retrieve application from id passed in
    public Application retrieveApplication(UUID id){
        return applications.get(id);
    }

    //return email message associated with application id
    public String sendEmail(UUID id){
        return applications.get(id).getEmailMessage();
    }

    //add application to map
    public boolean addApplication(Application application){
        if(application!=null){
            applications.put(application.getUUID(), application);
            return true;
        }
        return false;
    }

}

