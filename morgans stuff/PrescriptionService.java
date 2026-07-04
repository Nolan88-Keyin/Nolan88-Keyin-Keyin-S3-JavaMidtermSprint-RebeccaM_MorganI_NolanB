import java.time.LocalDate;

/**
 * Provides prescription acceptance logic for the pharmacy workflow.
 * Validates data, links records, and updates medication stock.
 */
public class PrescriptionService {

    private final MedicationTrackingSystem system;

    /**
     * Creates a prescription service tied to a medication tracking system.
     *
     * @param system the medication tracking system used for lookups and updates
     */
    public PrescriptionService(MedicationTrackingSystem system) {
        this.system = system;
    }

    /**
     * Accepts a prescription after validating required relationships and stock state.
        * Checks system state, validates doctor/patient/medication, links records,
        * decrements stock, and prints a confirmation message.
     *
     * @param prescription the prescription to accept
     */
    public void acceptPrescription(Prescription prescription) {
        if (system == null) {
            System.out.println("Medication tracking system is not available.");
            return;
        }
        if (prescription == null) {
            System.out.println("Prescription is null. Cannot accept it.");
            return;
        }

        Doctor doctor = prescription.getDoctor();
        Patient patient = prescription.getPatient();
        Medication medication = prescription.getMedication();

        if (doctor == null || patient == null || medication == null) {
            System.out.println("Prescription must include doctor, patient, and medication.");
            return;
        }

        if (!system.getDoctors().contains(doctor)) {
            System.out.println("Doctor is not registered in the system.");
            return;
        }
        if (!system.getPatients().contains(patient)) {
            System.out.println("Patient is not registered in the system.");
            return;
        }
        if (!system.getMedications().contains(medication)) {
            System.out.println("Medication is not registered in the system.");
            return;
        }
        if (isMedicationExpired(medication)) {
            System.out.println("Medication " + medication.getName() + " has expired.");
            return;
        }
        if (getMedicationStockCount(medication) <= 0) {
            System.out.println("Medication " + medication.getName() + " is out of stock.");
            return;
        }

        if (!doctor.getPatients().contains(patient)) {
            doctor.addPatient(patient);
        }
        if (!patient.getPrescriptions().contains(prescription)) {
            patient.addPrescription(prescription);
        }
        if (!system.getPrescriptions().contains(prescription)) {
            system.addPrescription(prescription);
        }

        decrementMedicationStock(medication, 1);

        System.out.println("Prescription accepted for " + patient.getName() + " by Dr. " + doctor.getName() + ".");
    }

    /**
     * Decrements medication stock by a given amount.
     *
     * @param medication the medication whose stock is being reduced
     * @param amount the amount to reduce from current stock
     */
    private void decrementMedicationStock(Medication medication, int amount) {
        int currentStock = medication.getQuantity();
        medication.setQuantity(Math.max(0, currentStock - amount));
    }

    /**
     * Returns the current stock count for a medication.
     *
     * @param medication the medication to inspect
     * @return the stock count, or 0 if medication is null
     */
    private int getMedicationStockCount(Medication medication) {
        if (medication == null) {
            return 0;
        }
        return medication.getQuantity();
    }

    /**
     * Checks whether a medication is expired based on the current date.
     *
     * @param medication the medication to check
     * @return true if the medication has an expiration date before today; otherwise false
     */
    private boolean isMedicationExpired(Medication medication) {
        LocalDate expiration = medication.getExpirationDate();
        return expiration != null && expiration.isBefore(LocalDate.now());
    }
}