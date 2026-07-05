import java.util.Scanner;
import java.time.LocalDate;

/**
 * Scanner-based main menu for pharmacy actions and reports.
 */
public class PharmacyMenu {

    private final MedicationTrackingSystem system;
    private final PrescriptionService prescriptionService;
    private final PrescriptionReports prescriptionReports;
    private final Scanner input;

    /**
     * Creates a menu with required system dependencies.
     *
     * @param system tracking system dependency
     * @param prescriptionService prescription workflow service
     * @param prescriptionReports reporting service
     * @param input scanner used for console input
     */
    public PharmacyMenu(
            MedicationTrackingSystem system,
            PrescriptionService prescriptionService,
            PrescriptionReports prescriptionReports,
            Scanner input) {
        this.system = system;
        this.prescriptionService = prescriptionService;
        this.prescriptionReports = prescriptionReports;
        this.input = input;
    }

    /**
     * Runs the interactive menu loop until exit is selected.
     */
    public void runMenu() {
        boolean running = true;

        while (running) {
            System.out.println("\n=== Pharmacy Menu ===");
            System.out.println("1. Add");
            System.out.println("2. Delete");
            System.out.println("3. Edit");
            System.out.println("4. Search");
            System.out.println("5. Accept Prescription");
            System.out.println("6. Add Patient To Doctor");
            System.out.println("7. Full System Report");
            System.out.println("8. Expired Medications Report");
            System.out.println("9. Prescriptions By Doctor");
            System.out.println("10. All Patients Past-Year Prescription Report");
            System.out.println("11. Restock All Medications");
            System.out.println("0. Exit");
            System.out.print("Select option: ");

            String choice = input.nextLine().trim();

            switch (choice) {
                // 1) Add patient, doctor, or medication.
                case "1":
                    System.out.println("Add: 1) Patient 2) Doctor 3) Medication 0) Return");
                    System.out.print("Select option: ");
                    String addChoice = input.nextLine().trim();
                    switch (addChoice) {
                        case "0":
                            System.out.println("Returning to main menu.");
                            break;
                        case "1":
                            System.out.print("Patient name: ");
                            String patientName = input.nextLine().trim();
                            int patientAge = readIntAtLeast("Age: ", 1);
                            System.out.print("Phone: ");
                            String patientPhone = input.nextLine().trim();
                            system.addPatient(new Patient(patientName, patientAge, patientPhone));
                            System.out.println("Patient added.");
                            break;
                        case "2":
                            System.out.print("Doctor name: ");
                            String doctorName = input.nextLine().trim();
                            int doctorAge = readIntAtLeast("Age: ", 1);
                            System.out.print("Phone: ");
                            String doctorPhone = input.nextLine().trim();
                            System.out.print("Specialty: ");
                            String specialty = input.nextLine().trim();
                            system.addDoctor(new Doctor(doctorName, doctorAge, doctorPhone, specialty));
                            System.out.println("Doctor added.");
                            break;
                        case "3":
                            System.out.print("Medication name: ");
                            String medicationName = input.nextLine().trim();
                            System.out.print("Dosage: ");
                            String dosage = input.nextLine().trim();
                            int quantityInt = readIntAtLeast("Quantity: ", 0);
                            system.addMedication(new Medication(medicationName, dosage, quantityInt));
                            System.out.println("Medication added.");
                            break;
                        default:
                            System.out.println("Invalid add option.");
                    }
                    break;

                // 2) Delete patient, doctor, or medication.
                case "2":
                    System.out.println("Delete: 1) Patient 2) Doctor 3) Medication 0) Return");
                    System.out.print("Select option: ");
                    String deleteChoice = input.nextLine().trim();
                    switch (deleteChoice) {
                        case "0":
                            System.out.println("Returning to main menu.");
                            break;
                        case "1":
                            System.out.print("Patient name: ");
                            Patient patientToDelete = system.findPatient(input.nextLine().trim());
                            if (patientToDelete == null) {
                                System.out.println("Patient not found.");
                            } else {
                                system.removePatient(patientToDelete);
                                System.out.println("Patient deleted.");
                            }
                            break;
                        case "2":
                            System.out.print("Doctor name: ");
                            Doctor doctorToDelete = system.findDoctor(input.nextLine().trim());
                            if (doctorToDelete == null) {
                                System.out.println("Doctor not found.");
                            } else {
                                system.removeDoctor(doctorToDelete);
                                System.out.println("Doctor deleted.");
                            }
                            break;
                        case "3":
                            System.out.print("Medication name: ");
                            Medication medToDelete = system.findMedication(input.nextLine().trim());
                            if (medToDelete == null) {
                                System.out.println("Medication not found.");
                            } else {
                                system.removeMedication(medToDelete);
                                System.out.println("Medication deleted.");
                            }
                            break;
                        default:
                            System.out.println("Invalid delete option.");
                    }
                    break;

                // 3) Edit patient, doctor, or medication details.
                case "3":
                    System.out.println("Edit: 1) Patient 2) Doctor 3) Medication 0) Return");
                    System.out.print("Select option: ");
                    String editChoice = input.nextLine().trim();
                    switch (editChoice) {
                        case "0":
                            System.out.println("Returning to main menu.");
                            break;
                        case "1":
                            System.out.print("Patient name to edit: ");
                            Patient patientToEdit = system.findPatient(input.nextLine().trim());
                            if (patientToEdit == null) {
                                System.out.println("Patient not found.");
                                break;
                            }
                            System.out.print("New name: ");
                            String newPatientName = input.nextLine().trim();
                            int newPatientAge = readIntAtLeast("New age: ", 1);
                            System.out.print("New phone: ");
                            String newPatientPhone = input.nextLine().trim();
                            system.editPatient(patientToEdit, newPatientName, newPatientAge, newPatientPhone);
                            System.out.println("Patient updated.");
                            break;
                        case "2":
                            System.out.print("Doctor name to edit: ");
                            Doctor doctorToEdit = system.findDoctor(input.nextLine().trim());
                            if (doctorToEdit == null) {
                                System.out.println("Doctor not found.");
                                break;
                            }
                            System.out.print("New name: ");
                            String newDoctorName = input.nextLine().trim();
                            int newDoctorAge = readIntAtLeast("New age: ", 1);
                            System.out.print("New phone: ");
                            String newDoctorPhone = input.nextLine().trim();
                            System.out.print("New specialty: ");
                            String newSpecialty = input.nextLine().trim();
                            system.editDoctor(doctorToEdit, newDoctorName, newDoctorAge, newDoctorPhone, newSpecialty);
                            System.out.println("Doctor updated.");
                            break;
                        case "3":
                            System.out.print("Medication name to edit: ");
                            Medication medToEdit = system.findMedication(input.nextLine().trim());
                            if (medToEdit == null) {
                                System.out.println("Medication not found.");
                                break;
                            }
                            System.out.print("New name: ");
                            String newMedName = input.nextLine().trim();
                            System.out.print("New dose: ");
                            String newDose = input.nextLine().trim();
                            int newStock = readIntAtLeast("New quantity in stock (int): ", 0);
                            system.editMedication(medToEdit, newMedName, newDose, newStock);
                            System.out.println("Medication updated.");
                            break;
                        default:
                            System.out.println("Invalid edit option.");
                    }
                    break;

                // 4) Search for patient, doctor, or medication by name.
                case "4":
                    System.out.println("Search: 1) Patient 2) Doctor 3) Medication 0) Return");
                    System.out.print("Select option: ");
                    String searchChoice = input.nextLine().trim();
                    switch (searchChoice) {
                        case "0":
                            System.out.println("Returning to main menu.");
                            break;
                        case "1":
                            System.out.print("Patient name: ");
                            Patient foundPatient = system.findPatient(input.nextLine().trim());
                            System.out.println(foundPatient == null ? "Patient not found." : foundPatient);
                            break;
                        case "2":
                            System.out.print("Doctor name: ");
                            Doctor foundDoctor = system.findDoctor(input.nextLine().trim());
                            System.out.println(foundDoctor == null ? "Doctor not found." : foundDoctor);
                            break;
                        case "3":
                            System.out.print("Medication name: ");
                            Medication foundMedication = system.findMedication(input.nextLine().trim());
                            System.out.println(foundMedication == null ? "Medication not found." : foundMedication);
                            break;
                        default:
                            System.out.println("Invalid search option.");
                    }
                    break;

                // 5) Accept a prescription and link entities.
                case "5":
                    System.out.print("Doctor name: ");
                    Doctor prescriptionDoctor = system.findDoctor(input.nextLine().trim());
                    System.out.print("Patient name: ");
                    Patient prescriptionPatient = system.findPatient(input.nextLine().trim());
                    System.out.print("Medication name: ");
                    Medication prescriptionMedication = system.findMedication(input.nextLine().trim());

                    if (prescriptionDoctor == null || prescriptionPatient == null || prescriptionMedication == null) {
                        System.out.println("Doctor, patient, or medication was not found.");
                        break;
                    }

                    prescriptionService.acceptPrescription(
                            new Prescription(prescriptionPatient, prescriptionDoctor, prescriptionMedication));
                    break;

                // 6) Assign a patient to a doctor's list.
                case "6":
                    System.out.print("Doctor name: ");
                    Doctor doctorForAssignment = system.findDoctor(input.nextLine().trim());
                    System.out.print("Patient name: ");
                    Patient patientForAssignment = system.findPatient(input.nextLine().trim());

                    if (doctorForAssignment == null || patientForAssignment == null) {
                        System.out.println("Doctor or patient not found.");
                        break;
                    }

                    doctorForAssignment.addPatient(patientForAssignment);
                    System.out.println("Patient assigned to doctor.");
                    break;

                // 7) Generate the full system report.
                case "7":
                    prescriptionReports.generateFullSystemReport();
                    break;

                // 8) Show expired medications report.
                case "8":
                    boolean foundExpired = false;
                    for (Medication medication : system.getMedications()) {
                        if (medication.getExpirationDate() != null
                                && medication.getExpirationDate().isBefore(LocalDate.now())) {
                            System.out.println(medication);
                            foundExpired = true;
                        }
                    }
                    if (!foundExpired) {
                        System.out.println("No expired medications found.");
                    }
                    break;

                // 9) Print all prescriptions for a specific doctor.
                case "9":
                    System.out.print("Doctor name: ");
                    Doctor reportDoctor = system.findDoctor(input.nextLine().trim());
                    prescriptionReports.prescriptionByDoctor(reportDoctor);
                    break;

                // 10) Print past-year prescription summary across all patients.
                case "10":
                    prescriptionReports.patientPrescriptionPastYear();
                    break;

                // 11) Restock all medications by a chosen amount.
                case "11":
                    int restockAmount = readIntAtLeast("Amount to add: ", 1);
                    system.restockAllMedications(restockAmount);
                    System.out.println("All medications restocked.");
                    break;

                case "0":
                    running = false;
                    System.out.println("Exiting menu.");
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    /**
     * Reads an integer from the console and retries until valid input is entered.
     *
     * @param prompt prompt shown to the user
     * @return validated integer value
     */
    private int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String raw = input.nextLine().trim();
            try {
                return Integer.parseInt(raw);
            } catch (NumberFormatException ex) {
                System.out.println("Invalid number. Please enter a whole number.");
            }
        }
    }

    /**
     * Reads an integer that must be greater than or equal to a minimum value.
     *
     * @param prompt prompt shown to the user
     * @param min minimum accepted value
     * @return validated integer value
     */
    private int readIntAtLeast(String prompt, int min) {
        while (true) {
            int value = readInt(prompt);
            if (value >= min) {
                return value;
            }
            System.out.println("Value must be at least " + min + ".");
        }
    }
}