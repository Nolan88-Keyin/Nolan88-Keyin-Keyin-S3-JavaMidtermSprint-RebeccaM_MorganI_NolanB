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

    /*gets the patient list */
    public ArrayList<Patient> getPatients() {
        return patients;
    }

    /*gets the doctor list */
    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    /*gets the medication list */
    public ArrayList<Medication> getMedications() {
        return medications;
    }

    /*gets the prescription list */
    public ArrayList<Prescription> getPrescriptions() {
        return prescriptions;
    }

    /*finds a specific patient by name */
    public Patient findPatient(String name){
        for (Patient patient : patients) {
            if (patient.getName().equalsIgnoreCase(name)) {
                return patient;
            }
        }
        return null;
    }

    /*finds a specific doctor by name */
    public Doctor findDoctor(String name){
        for (Doctor doctor : doctors){
            if (doctor.getName().equalsIgnoreCase(name)){
                return doctor;
            }
        }
        return null;
    }

    /*finds a specific medication by name */
    public Medication findMedication(String name){
        for (Medication medication : medications){
            if (medication.getName().equalsIgnoreCase(name)){
                return medication;
            }
        }
        return null;
    }

    /* finds all prescriptions for a given patient name */
    public ArrayList<Prescription> findPrescriptions(String name) {

        /*Tempary list to store found prescriptions for printing after a search */
        ArrayList<Prescription> foundPrescriptions = new ArrayList<>();
        for (Prescription prescription : prescriptions) {
            if (prescription.getPatientname().equalsIgnoreCase(name)) {
                foundPrescriptions.add(prescription);
            }
        }
        return foundPrescriptions;
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

    /*
    * Edit a patient's information. 
    */

    public void editPatient (Patient patient, String name, int age, String phonenumber) {
        patient.setName(name);
        patient.setAge(age);
        patient.setPhoneNumber(phonenumber);
    }

     /*
    * Edit a doctor's information. 
    */

    public void editDoctor (Doctor doctor, String name, int age, String phonenumber, String specialization) {
        doctor.setName(name);
        doctor.setAge(age);
        doctor.setPhoneNumber(phonenumber);
        doctor.setSpecialization(specialization);
    }

    public void editMedication (Medication medToEdit, String newMedName, String newDose, int newStock){

        Medication medication = findMedication(medToEdit.getName());
        
        if (medication != null) {

            medication.setName(newMedName);
            medication.setDosage(newDose);
            medication.setQuantity(newStock);
        }
       
    }

    public void restockMedication(Medication medToRestock, int restockAmount) {

        Medication medication = findMedication(medToRestock.getName());

        if (medication != null) {
            int quantity = medication.getQuantity();
            medication.setQuantity(quantity += restockAmount);
        }
    }



}