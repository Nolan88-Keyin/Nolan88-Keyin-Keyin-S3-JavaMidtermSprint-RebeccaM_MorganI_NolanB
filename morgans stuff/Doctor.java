
/*Morgan Ings*/

/*the Doctor class represents a doctor with additional information such as specialization as well as a list of patients */
/* It inherits from the Person class, which provides basic information such as name, age, phone number, and a unique ID. */

import java.util.ArrayList; /*importing the Arraylist libary to store critical info that needs to be changed and displayed many times */

/*creating the Doctor class that extends the Person class, and defining additional variables/arrays */
public class Doctor /* extends Person*/ {
    private String specialization;
    private String name;
    private String phoneNumber;
    private int age;
    private int id;
    private static int idCounter = 1; /* Static counter to generate unique IDs */
    private ArrayList<Patient> patients;
    

    public Doctor(String name, int age, String phoneNumber, String specialization) { /* Constructor to initialize a Doctor object with name, age, phone number, and specialty */

        this.phoneNumber = phoneNumber;
        this.id = idCounter++; /* Assign the unique ID to the Doctor object */
        this.age = age;
        this.name = name;
        this.specialization = specialization;
        this.patients = new ArrayList<>(); /* Initialize the list of patients */
        
    }

    /* Getters and setters for the Doctor class */

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
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

    /* Override the toString() method to provide a string representation of the Doctor object */

    @Override
    public String toString() {
        return "Doctor - " + "Id - " + id + ", Name - " + name + '\n' + 
            "Specialization - " + specialization + '\n' +
            "Age - " + age + '\n' +
            "Phone Number - " + phoneNumber + '\n' +
            System.lineSeparator();
    }
    
}
