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

    /*
    * Edit a medications information. 
    */

    public void editMedication (Medication medication, String name, String dose, int quantityInStock) {
        medication.setName(name);
        medication.setDose(dose);
        medication.setQuantityInStock(quantityInStock);
    }

    /*
    * Search patient by name.
     */

    public Patient searchPatient (String name) {

        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getName().equalsIgnoreCase(name)) {
                return patients.get(i);
            }
        }

        return null;
    }

    /*
    * Search doctor by name.
     */

    public Doctor searchDoctor (String name) {

        for (int i = 0; i < doctors.size(); i++) {
            if (doctors.get(i).getName().equalsIgnoreCase(name)) {
                return doctors.get(i);
            }
        }

        return null;
    }

    /*
    * Search medication by name.
     */

    public Medication searchMedication (String name) {

        for (int i = 0; i < medications.size(); i++) {
            if (medications.get(i).getName().equalsIgnoreCase(name)) {
                return medications.get(i);
            }
        }

        return null;
    }


}