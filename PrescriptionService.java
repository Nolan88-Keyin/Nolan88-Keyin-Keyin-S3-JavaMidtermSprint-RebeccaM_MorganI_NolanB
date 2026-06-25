import java.util.LocalDate;

public class PerscriptionService {

    public void acceptPrescription(Prescription prescription) {
        System.out.println("Enter Doctor's name for prescription: ");
        if (system.getDoctors() == null || system.getDoctors().isEmpty()) {
            System.out.println("No doctors available in the system.");
            return;
        }
        System.out.println("Enter Patient's name for prescription: ");
        if (system.getPatients() == null || system.getPatients().isEmpty()) {
            System.out.println("No patients available in the system.");
            return;
        }
        system.out.println("Enter Medication name for prescription: ");
        if (system.getMedications() == null || system.getMedications().isEmpty()) {
            System.out.println("No medications available in the system.");
            return;
        }
        system.addPrescription(prescription);
    }

    public void addPatientToDoctor(Patient patient, Doctor doctor) {
        if (doctor == null || patient == null) {
            System.out.println("Doctor or Patient is null. Cannot add patient to doctor.");
            return;
        }
        doctor.addPatient(patient);
    }

    public void prescriptionByDoctor(Doctor doctor) {
        if (doctor == null) {
            System.out.println("Doctor is null. Cannot retrieve prescriptions.");
            return;
        }
        List<Prescription> prescriptions = doctor.getPrescriptions();
        if (prescriptions == null || prescriptions.isEmpty()) {
            System.out.println("No prescriptions found for the doctor: " + doctor.getName());
            return;
        }
        System.out.println("Prescriptions by Doctor " + doctor.getName() + ":");
        for (Prescription prescription : prescriptions) {
            System.out.println(prescription);
        }
    }

    public void checkMedicationExpiry(Medication medication) {
        if (medication == null) {
            System.out.println("Medication is null. Cannot check expiry.");
            return;
        }
        if (medication.getExpiryDate().before(new Date())) {
            System.out.println("Medication " + medication.getName() + " has expired.");
        } else {
            System.out.println("Medication " + medication.getName() + " is valid.");
        }
    }

    public void patientPerscriptionPastYear(Patient patient) {
        if (patient == null) {
            System.out.println("Patient is null. Cannot retrieve prescriptions.");
            return;
        }
        List<Prescription> prescriptions = patient.getPrescriptions();
        if (prescriptions == null || prescriptions.isEmpty()) {
            System.out.println("No prescriptions found for the patient: " + patient.getName());
            return;
        }
        System.out.println("Prescriptions for Patient " + patient.getName() + " in the past year:");
        LocalDate oneYearAgo = LocalDate.now().minusYears(1);
        for (Prescription prescription : prescriptions) {
            if (prescription.getDate().isAfter(oneYearAgo)) {
                System.out.println(prescription);
            }
        }
    }