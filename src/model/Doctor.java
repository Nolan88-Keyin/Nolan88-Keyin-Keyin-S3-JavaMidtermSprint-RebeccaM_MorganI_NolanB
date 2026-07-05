
import java.util.ArrayList;

/**
 * Represents a doctor in the pharmacy system.
 *
 * <p>Extends Person and adds specialization plus managed patient links.</p>
 */
public class Doctor extends Person {
    private String specialization;
    private ArrayList<Patient> patients;
    

    /**
     * Creates a doctor record.
     *
     * @param name doctor name
     * @param age doctor age
     * @param phoneNumber doctor phone number
     * @param specialization doctor specialty
     */
    public Doctor(String name, int age, String phoneNumber, String specialization) {
        super(name, age, phoneNumber);
        this.specialization = specialization;
        this.patients = new ArrayList<>();
        
    }

    public void setPatients(ArrayList<Patient> patients) {
        this.patients = patients;
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    /**
     * Returns a formatted doctor summary.
     *
     * @return doctor details as text
     */
    @Override
    public String toString() {
        return "Doctor - " + "Id - " + getId() + ", Name - " + getName() + '\n' + 
            "Specialization - " + specialization + '\n' +
            "Age - " + getAge() + '\n' +
            "Phone Number - " + getPhoneNumber() + '\n' +
            System.lineSeparator();
    }
    
}
