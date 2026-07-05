import java.time.LocalDate;
import java.util.ArrayList;

import model.Doctor;
import model.Medication;
import model.Patient;
import model.Prescription;

/**
 * Manages pharmacy entities and core CRUD operations.
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


    /**
     * Creates an empty tracking system.
     */
    public MedicationTrackingSystem () {
        patients = new ArrayList<>();
        doctors = new ArrayList<>();
        medications = new ArrayList<>();
        prescriptions = new ArrayList<>();
    } 

    /**
     * Gets all patients.
     *
     * @return patient list
     */
    public ArrayList<Patient> getPatients() {
        return patients;
    }

    /**
     * Gets all doctors.
     *
     * @return doctor list
     */
    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    /**
     * Gets all medications.
     *
     * @return medication list
     */
    public ArrayList<Medication> getMedications() {
        return medications;
    }

    /**
     * Gets all prescriptions.
     *
     * @return prescription list
     */
    public ArrayList<Prescription> getPrescriptions() {
        return prescriptions;
    }

    /**
     * Finds a patient by name.
     *
     * @param name patient name to match
     * @return matching patient or null
     */
    public Patient findPatient(String name){
        for (Patient patient : patients) {
            if (patient.getName().equalsIgnoreCase(name)) {
                return patient;
            }
        }
        return null;
    }

    /**
     * Finds a doctor by name.
     *
     * @param name doctor name to match
     * @return matching doctor or null
     */
    public Doctor findDoctor(String name){
        for (Doctor doctor : doctors){
            if (doctor.getName().equalsIgnoreCase(name)){
                return doctor;
            }
        }
        return null;
    }

    /**
     * Finds a medication by name.
     *
     * @param name medication name to match
     * @return matching medication or null
     */
    public Medication findMedication(String name){
        for (Medication medication : medications){
            if (medication.getName().equalsIgnoreCase(name)){
                return medication;
            }
        }
        return null;
    }

    /**
     * Finds all prescriptions for a patient name.
     *
     * @param name patient name to match
     * @return list of matching prescriptions
     */
    public ArrayList<Prescription> findPrescriptions(String name) {
        ArrayList<Prescription> foundPrescriptions = new ArrayList<>();
        for (Prescription prescription : prescriptions) {
            if (prescription.getPatientname().equalsIgnoreCase(name)) {
                foundPrescriptions.add(prescription);
            }
        }
        return foundPrescriptions;
    }

    /**
     * Adds a patient to the system.
     *
     * @param patient patient to add
     */
    public void addPatient (Patient patient) {
        patients.add(patient);
    }

    /**
     * Adds a doctor to the system.
     *
     * @param doctor doctor to add
     */
    public void addDoctor (Doctor doctor) {
        doctors.add(doctor);
    }

    /**
     * Adds a medication to the system.
     *
     * @param medication medication to add
     */
    public void addMedication (Medication medication) {
        medications.add(medication);
    }

    /**
     * Adds a prescription to the system.
     *
     * @param prescription prescription to add
     */
    public void addPrescription (Prescription prescription) {
        prescriptions.add(prescription);
    }

    /**
     * Removes a patient from the system.
     *
     * @param patient patient to remove
     */
    public void removePatient (Patient patient) {
        patients.remove(patient);
    }

    /**
     * Removes a doctor from the system.
     *
     * @param doctor doctor to remove
     */
    public void removeDoctor (Doctor doctor) {
        doctors.remove(doctor);
    }

    /**
     * Removes a medication from the system.
     *
     * @param medication medication to remove
     */
    public void removeMedication (Medication medication) {
        medications.remove(medication);
    }

    /**
     * Removes a prescription from the system.
     *
     * @param prescription prescription to remove
     */
    public void removePrescription (Prescription prescription) {
        prescriptions.remove(prescription);
    }

    /**
     * Updates patient details.
     *
     * @param patient patient to update
     * @param name new name
     * @param age new age
     * @param phonenumber new phone number
     */
    public void editPatient (Patient patient, String name, int age, String phonenumber) {
        patient.setName(name);
        patient.setAge(age);
        patient.setPhoneNumber(phonenumber);
    }

    /**
     * Updates doctor details.
     *
     * @param doctor doctor to update
     * @param name new name
     * @param age new age
     * @param phonenumber new phone number
     * @param specialization new specialization
     */
    public void editDoctor (Doctor doctor, String name, int age, String phonenumber, String specialization) {
        doctor.setName(name);
        doctor.setAge(age);
        doctor.setPhoneNumber(phonenumber);
        doctor.setSpecialization(specialization);
    }

    /**
     * Updates medication details.
     *
     * @param medToEdit medication to update
     * @param newMedName new medication name
     * @param newDose new dosage value
     * @param newStock new stock value
     */
    public void editMedication (Medication medToEdit, String newMedName, String newDose, int newStock){

        Medication medication = findMedication(medToEdit.getName());
        
        if (medication != null) {

            medication.setName(newMedName);
            medication.setDosage(newDose);
            medication.setQuantity(newStock);
        }
       
    }

    /**
     * Increases stock for all medications and refreshes expiry dates.
     *
     * @param restockAmount amount to add to each medication
     */
    public void restockAllMedications(int restockAmount) {
        if (restockAmount <= 0) {
            return;
        }

        LocalDate newExpireDate = LocalDate.now().plusYears(1);
        for (Medication medication : medications) {
            int quantity = medication.getQuantity();
            medication.setQuantity(quantity + restockAmount);
            medication.setExpirationDate(newExpireDate);
        }
    }

    /**
     * Check if a medication is expired.
     *
     * @param medication medication to check
     * @return true if the medication is expired, false otherwise
     
      public boolean isMedicationExpired(Medication medication) {
        LocalDate currentDate = LocalDate.now();
        LocalDate expiryDate = medication.getExpirationDate();

        return expiryDate.isBefore(currentDate); /* return true if the medication is expired, false otherwise 
    }
    */
     

}