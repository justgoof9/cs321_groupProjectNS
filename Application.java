import java.util.UUID;

public class Application{
    private UUID applicationId;
    private boolean toEmail;
    Citizen citizenApplicant;
    NonImmigrantWorker alienApplicant;

    public void setAlienApplicant(NonImmigrantWorker alienApplicant) {
        this.alienApplicant = alienApplicant;
    }

    public void setCitizenApplicant(Citizen citizenApplicant) {
        this.citizenApplicant = citizenApplicant;
    }

    public NonImmigrantWorker getAlienApplicant() {
        return alienApplicant;
    }

    public Citizen getCitizenApplicant() {
        return citizenApplicant;
    }

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
