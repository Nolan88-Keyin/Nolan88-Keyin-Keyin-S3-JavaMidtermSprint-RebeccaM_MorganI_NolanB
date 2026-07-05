
import java.util.ArrayList;

/**
 * Represents a patient in the pharmacy system.
 *
 * <p>Extends Person and adds medication and prescription tracking.</p>
 */
public class Patient extends Person {

    private ArrayList<Medication> medications;
    private ArrayList<Prescription> prescriptions;

    /**
     * Creates a patient record.
     *
     * @param name patient name
     * @param age patient age
     * @param phoneNumber patient phone number
     */
    public Patient(String name, int age, String phoneNumber) {
        super(name, age, phoneNumber);
        this.medications = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
    }

    public void setMedications(ArrayList<Medication> medications) {
        this.medications = medications;
    }

    public ArrayList<Medication> getMedications() {
        return medications;
    }

    public void addMedication(Medication medication) {
        medications.add(medication);
    }

    public void removeMedication(Medication medication) {
        medications.remove(medication);
    }

    public ArrayList<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public void addPrescription(Prescription prescription) {
        prescriptions.add(prescription);
    }

    public void setPrescriptions(ArrayList<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }

    public void removePrescription(Prescription prescription) {
        prescriptions.remove(prescription);
    }

    /**
     * Returns a formatted patient summary.
     *
     * @return patient details as text
     */
    @Override
    public String toString() {
        return "Patient - " + super.toString();
    }
    
}
