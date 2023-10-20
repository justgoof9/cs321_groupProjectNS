import java.util.UUID;

public class Application{
    private UUID applicationId;
    private boolean toEmail;
    Citizen citizenApplicant = new Citizen();
    NonImmigrantWorker alienApplicant = new NonImmigrantWorker();

    public void setUuid(UUID id) {
        this.applicationId = id;
    }
    public void setEmail(boolean toEmail) {
        this.toEmail = toEmail;
    }
    public UUID getUUID() {
        return applicationId;
    }
    public boolean getEmail() {
        return toEmail;
    }
    
    public boolean toEmail() {
        toEmail = true;
        return toEmail;
    }

}
