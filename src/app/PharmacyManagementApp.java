import java.util.Scanner;

/**
 * Entry point for the Pharmacy Management System application.
 */
public class PharmacyManagementApp {

    /**
     * Starts the application, seeds sample data, and launches the menu.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        MedicationTrackingSystem system = new MedicationTrackingSystem();
        PrescriptionService prescriptionService = new PrescriptionService(system);
        PrescriptionReports prescriptionReports = new PrescriptionReports(system);

        Scanner input = new Scanner(System.in);

        PharmacyMenu menu = new PharmacyMenu(system, prescriptionService, prescriptionReports, input);

        System.out.println("Pharmacy Management System started.");
        System.out.println("Use menu options to manage the system.");
        Patient patient1 = new Patient("Jane Smith", 25, "098-765-4321");
        Patient patient2 = new Patient("Alice Johnson", 40, "555-123-4567");
        Patient patient3 = new Patient("Bob Williams", 35, "777-888-9999");
        Patient patient4 = new Patient("Emily Brown", 28, "111-222-3333");
        


        Doctor doctor1 = new Doctor("Dr. John Doe", 40, "709-555-1234", "Cardiology");
        Doctor doctor2 = new Doctor("Dr. Jane Smith", 35, "709-555-5678", "Dermatology");
        Doctor doctor3 = new Doctor("Dr. Michael Johnson", 45, "709-555-9012", "Pediatrics");
        Doctor doctor4 = new Doctor("Dr. Emily Davis", 38, "709-555-3456", "Orthopedics");
        Medication medication1 = new Medication("Aspirin", "500mg", 30);
        Medication medication2 = new Medication("Ibuprofen", "200mg", 20);
        Medication medication3 = new Medication("Paracetamol", "500mg", 15);
        Medication medication4 = new Medication("Amoxicillin", "250mg", 10);
        Medication medication5 = new Medication("Metformin", "1000mg", 60);
        Medication medication6 = new Medication("Lisinopril", "10mg", 30);
        Medication medication7 = new Medication("Tylenol", "500mg", 20);
        Medication medication8 = new Medication("Simvastatin", "20mg", 30);
        Medication medication9 = new Medication("Omeprazole", "20mg", 14);

        Prescription prescription1 = new Prescription(patient1, doctor1, medication1);
        Prescription prescription2 = new Prescription(patient1, doctor1, medication2);
        Prescription prescription3 = new Prescription(patient2, doctor2, medication3);
        Prescription prescription4 = new Prescription(patient2, doctor2, medication4);
        Prescription prescription5 = new Prescription(patient3, doctor3, medication5);
        Prescription prescription6 = new Prescription(patient3, doctor3, medication6);
        Prescription prescription7 = new Prescription(patient4, doctor4, medication7);
        Prescription prescription8 = new Prescription(patient4, doctor4, medication8);
        Prescription prescription9 = new Prescription(patient4, doctor4, medication9);

        system.addPatient(patient1);
        system.addPatient(patient2);
        system.addPatient(patient3);
        system.addPatient(patient4);

        system.addDoctor(doctor1);
        system.addDoctor(doctor2);
        system.addDoctor(doctor3);
        system.addDoctor(doctor4);

        system.addMedication(medication1);
        system.addMedication(medication2);
        system.addMedication(medication3);
        system.addMedication(medication4);
        system.addMedication(medication5);
        system.addMedication(medication6);
        system.addMedication(medication7);
        system.addMedication(medication8);
        system.addMedication(medication9);

        system.addPrescription(prescription1);
        system.addPrescription(prescription2);
        system.addPrescription(prescription3);
        system.addPrescription(prescription4);
        system.addPrescription(prescription5);
        system.addPrescription(prescription6);
        system.addPrescription(prescription7);
        system.addPrescription(prescription8);
        system.addPrescription(prescription9);

        patient1.addMedication(medication1);
        patient1.addMedication(medication2);
        patient2.addMedication(medication3);
        patient2.addMedication(medication4);
        patient3.addMedication(medication5);
        patient3.addMedication(medication6);
        patient4.addMedication(medication7);
        patient4.addMedication(medication8);
        patient4.addMedication(medication9);

        patient1.addPrescription(prescription1);
        patient1.addPrescription(prescription2);
        patient2.addPrescription(prescription3);
        patient2.addPrescription(prescription4);
        patient3.addPrescription(prescription5);
        patient3.addPrescription(prescription6);
        patient4.addPrescription(prescription7);
        patient4.addPrescription(prescription8);
        patient4.addPrescription(prescription9);

        doctor1.addPatient(patient1);
        doctor2.addPatient(patient2);
        doctor3.addPatient(patient3);
        doctor4.addPatient(patient4);

        menu.runMenu();

    }
}
