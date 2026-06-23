import java.util.ArrayList;

/* MEDICATION TRACKING SYSTEM 
 * This class manages the pharmacy system.
 * Stores: Patients, doctors, medications, and prescriptions. 
 */

public class MedicationTrackingSystem {

    // List of all patients in the system
    private ArrayList<Patient> patients;

    // List of all doctors in the system
    private ArrayList<Doctor> doctors;

    // List of all medications available in the system
    private ArrayList<Medication> medications;

    // List of all prescriptions issued in the system
    private ArrayList<Prescription> prescriptions;

    /*  CONSTRUCTOR */
    /*  creates empty list when the system starts */

    public MedicationTrackingSystem () {
        patients = new ArrayList<>();
        doctors = new ArrayList<>();
        medications = new ArrayList<>();
        prescriptions = new ArrayList<>();
    } 

    /* adds a patient to the patients list */
    public void addPatient (Patient patient) {
        patients.add(patient);
    }

    /*  adds a doctor to the doctors list */
    public void addDoctor (Doctor doctor) {
        doctors.add(doctor);
    }

    /*  adds a medication to the medications array list */
    public void addMedication (Medication medication) {
        medications.add(medication);
    }

    /*  adds a prescriptions to the prescriptions array list */
    public void addPrescription (Prescription prescription) {
        prescriptions.add(prescription);
    }

    /*
    * Removes a patient from the system.
     */

    public void removePatient (Patient patient) {
        patients.remove(patient);
    }

    /*
    * Removes a doctor from the system.
     */

    public void removeDoctor (Doctor doctor) {
        doctors.remove(doctor);
    }

    /*
    * Removes a medication from the system.
     */

    public void removeMedication (Medication medication) {
        medications.remove(medication);
    }

    /*
    * Removes a prescription from the system.
     */

    public void removePrescription (Prescription prescription) {
        prescriptions.remove(prescription);
    }
}