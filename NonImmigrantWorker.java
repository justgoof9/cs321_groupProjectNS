/**
 * Represents a non-immigrant worker with basic personal details.
 */
public class NonImmigrantWorker {
    
    // Instance variables to store the worker's first name, last name, date of birth, and A-number.
    private String firstName;
    private String lastName;
    private String dob;  // Date of birth
    private String aNumber;  // Alien registration number (A-number)

    /**
     * Sets the worker's date of birth.
     * 
     * @param dob The date of birth to set.
     */
    public void setDob(String dob) {
        this.dob = dob;
    }

    /**
     * Sets the worker's first name.
     * 
     * @param firstName The first name to set.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Sets the worker's last name.
     * 
     * @param lastName The last name to set.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Sets the worker's Alien registration number (A-number).
     * 
     * @param aNumber The A-number to set.
     */
    public void setANumber(String aNumber) {
        this.aNumber = aNumber;
    }

    /**
     * Retrieves the worker's date of birth.
     * 
     * @return The date of birth of the worker.
     */
    public String getDob() {
        return dob;
    }
    
    /**
     * Retrieves the worker's first name.
     * 
     * @return The first name of the worker.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Retrieves the worker's last name.
     * 
     * @return The last name of the worker.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Retrieves the worker's Alien registration number (A-number).
     * 
     * @return The A-number of the worker.
     */
    public String getANumber() {
        return aNumber;
    }

}