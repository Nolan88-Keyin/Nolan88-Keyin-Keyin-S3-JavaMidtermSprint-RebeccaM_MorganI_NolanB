
/*Morgan Ings*/

/*The Prescription class represents a prescription with information such as expiration date, patient ID, doctor ID, medication ID, and a unique ID. like the Medication class, it has getters and setters for all its attributes, as all prescriptions are also stored in a static list */

/*importing necessary libraries */
import java.time.LocalDate;

/*creating the Prescription class and defining variables/arrays */
public class Prescription {
    private int id;
    private static int idCounter = 1; /* Static counter to generate unique IDs */
    private LocalDate expires; /* Expiration date of the prescription */
    private int patientId;
    private String patientname;
    private int doctorId;
    private String doctorname;
    private int medicationId;
    private String medicationName;
    

    public Prescription(Patient patient, Doctor doctor, Medication medication) { /* Constructor to initialize a Prescription object with patient, doctor, and medication information */

        this.id = idCounter++; /* Assign a unique ID and increment the counter after each instance */
        this.patientId = patient.getId();
        this.patientname = patient.getName();
        this.doctorId = doctor.getId();
        this.doctorname = doctor.getName();
        this.medicationId = medication.getId();
        this.medicationName = medication.getName();
        this.expires = LocalDate.now().plusYears(1); // Set expiration date to 1 year from now
    }

    /* Getters and setters for the Prescription class */

    public int getId() {
        return id;
    }

    public LocalDate getExpires() {
        return expires;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getPatientname() {
        return patientname;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public String getDoctorname() {
        return doctorname;
    }

    public int getMedicationId() {
        return medicationId;
    }

    public String getMedicationName() {
        return medicationName;
    }


    /* Override the toString() method to provide a string representation of the Prescription object */

    @Override
    public String toString() {
        return  "id - " + id + '\n' +
                "expires - " + expires + '\n' +
                "patientId - " + patientId + '\n' +
                "patientname - " + patientname + '\n' +
                "doctorId - " + doctorId + '\n' +
                "doctorname - " + doctorname + '\n' +
                "medicationId - " + medicationId + '\n' +
                "medicationName - " + medicationName + '\n' + 
                System.lineSeparator();
    }






}
