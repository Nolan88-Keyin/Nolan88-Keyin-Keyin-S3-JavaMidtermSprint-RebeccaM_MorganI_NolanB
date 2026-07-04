
/*Morgan Ings*/

/*The Patient class represents a patient with additional information such as a list of medications and prescriptions */
/* It inherits from the Person class, which provides basic information such as name, age, and phone number */

import java.util.ArrayList; /*importing the Arraylist libary to store critical info that needs to be changed and displayed many times */

/*creating the Patient class that extends the Person class, and defining additional variables/arrays */
public class Patient extends Person {

    private ArrayList<Medication> medications;
    private ArrayList<Prescription> prescriptions;

    public Patient(String name, int age, String phoneNumber) { /* Constructor to initialize a Patient object with name, age, and phone number */
        super(name, age, phoneNumber);
        this.medications = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
    }
    /* Getters and setters for the Patient class */

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

    /* Override the toString() method to provide a string representation of the Patient object */

    @Override
        public String toString() {
            return "Patient - " + super.toString();
        }
    
}
