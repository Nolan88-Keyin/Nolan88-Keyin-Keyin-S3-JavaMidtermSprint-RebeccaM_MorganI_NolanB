
import java.time.LocalDate;

/**
 * Represents a prescription issued by a doctor for a patient.
 */
public class Prescription {
    private int id;
    private static int idCounter = 1;
    private LocalDate expires;
    private int patientId;
    private String patientname;
    private int doctorId;
    private String doctorname;
    private int medicationId;
    private String medicationName;
    private Doctor doctor;
    private Medication medication;
    private Patient patient;
    

    /**
     * Creates a prescription record.
     *
     * @param patient linked patient
     * @param doctor linked doctor
     * @param medication linked medication
     */
    public Prescription(Patient patient, Doctor doctor, Medication medication) {

        this.id = idCounter++;
        this.patient = patient;
        this.medication = medication;
        this.patientId = patient.getId();
        this.patientname = patient.getName();
        this.doctorId = doctor.getId();
        this.doctorname = doctor.getName();
        this.doctor = doctor;
        this.medicationId = medication.getId();
        this.medicationName = medication.getName();
        this.expires = LocalDate.now().plusYears(1);
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Medication getMedication() {
        return medication;
    }

    public Patient getPatient() {
        return patient;
    }

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


    /**
     * Returns a formatted prescription summary.
     *
     * @return prescription details as text
     */
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
