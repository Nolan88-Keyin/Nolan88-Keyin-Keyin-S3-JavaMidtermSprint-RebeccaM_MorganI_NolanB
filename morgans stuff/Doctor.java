
/*Morgan Ings*/

/*the Doctor class represents a doctor with additional information such as specialty as well as a list of patients */
/* It inherits from the Person class, which provides basic information such as name, age, phone number, and a unique ID. */

import java.util.ArrayList; /*importing the Arraylist libary to store critical info that needs to be changed and displayed many times */

/*creating the Doctor class that extends the Person class, and defining additional variables/arrays */
public class Doctor extends Person {
    private String specialty;
    private ArrayList<Patient> patients;
    

    public Doctor(String name, int age, String phoneNumber, String specialty) { /* Constructor to initialize a Doctor object with name, age, phone number, and specialty */

        super(name, age, phoneNumber);
        this.specialty = specialty;
        this.patients = new ArrayList<>(); /* Initialize the list of patients */
        /*unlike the Person class, the doctor class doesn't need to generate a unique ID on its own since it inherits from the Person class */
    }

    /* Getters and setters for the Doctor class */

    public void setPatients(ArrayList<Patient> patients) {
        this.patients = patients;
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    /* Override the toString() method to provide a string representation of the Doctor object */

    @Override
    public String toString() {
        return "Doctor - " + super.toString() + '\n' + 
            "specialty - " + specialty + '\n' +
            System.lineSeparator();
    }
    
}
