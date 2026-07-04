import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Generates prescription and system reports.
 */
public class PrescriptionReports {

    private final MedicationTrackingSystem system;

    /**
     * Creates a report service for a medication tracking system.
     *
     * @param system the system used as the report data source
     */
    public PrescriptionReports(MedicationTrackingSystem system) {
        this.system = system;
    }

    /**
     * Prints all prescriptions issued by a specific doctor.
     *
     * @param doctor the doctor whose prescriptions will be listed
     */
    public void prescriptionByDoctor(Doctor doctor) {
        if (doctor == null) {
            System.out.println("Doctor is null. Cannot retrieve prescriptions.");
            return;
        }

        List<Prescription> prescriptions = system.getPrescriptions();
        boolean found = false;

        System.out.println("Prescriptions by Doctor " + doctor.getName() + ":");
        for (Prescription prescription : prescriptions) {
            if (prescription != null && prescription.getDoctor() == doctor) {
                System.out.println(prescription);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No prescriptions found for the doctor: " + doctor.getName());
        }
    }

    /**
     * Prints a past-year prescription summary for a patient by medication name.
     *
     * @param patient the patient whose past-year prescriptions are summarized
     */
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

        LocalDate oneYearAgo = LocalDate.now().minusYears(1);
        Map<String, Integer> medicationCounts = new LinkedHashMap<>();

        for (Prescription prescription : prescriptions) {
            if (prescription == null || prescription.getMedication() == null || prescription.getExpires() == null) {
                continue;
            }

            LocalDate issueDate = prescription.getExpires().minusYears(1);
            if (!issueDate.isBefore(oneYearAgo)) {
                String medicationName = prescription.getMedication().getName();
                medicationCounts.put(medicationName, medicationCounts.getOrDefault(medicationName, 0) + 1);
            }
        }

        if (medicationCounts.isEmpty()) {
            System.out.println("No prescriptions in the past year for patient: " + patient.getName());
            return;
        }

        System.out.println("Past-year medication summary for " + patient.getName() + ":");
        for (Map.Entry<String, Integer> entry : medicationCounts.entrySet()) {
            System.out.println("- " + entry.getKey() + " (" + entry.getValue() + ")");
        }
    }

    /**
     * Prints a full system report including doctors, patients, medications, and prescriptions.
     */
    public void generateFullSystemReport() {
        System.out.println("\n===== FULL SYSTEM REPORT =====");

        System.out.println("\nDoctors:");
        printList(system.getDoctors());

        System.out.println("\nPatients:");
        printList(system.getPatients());

        System.out.println("\nMedications:");
        printList(system.getMedications());

        System.out.println("\nPrescriptions:");
        printList(system.getPrescriptions());

        System.out.println("\n===== END REPORT =====");
    }

    /**
     * Prints all items in a list or "None" when empty.
     *
     * @param items the list to print
     */
    private void printList(List<?> items) {
        if (items == null || items.isEmpty()) {
            System.out.println("None");
            return;
        }

        for (Object item : items) {
            System.out.println(item);
        }
    }
}
