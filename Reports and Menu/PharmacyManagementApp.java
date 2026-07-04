import java.util.Scanner;

// Entry point for the Pharmacy Management System application.
public class PharmacyManagementApp {

    // Creates dependencies and runs menu.
    public static void main(String[] args) {
        // System and services.
        MedicationTrackingSystem system = new MedicationTrackingSystem();
        PrescriptionService prescriptionService = new PrescriptionService(system);
        PrescriptionReports prescriptionReports = new PrescriptionReports(system);

        // Console input for menu interaction.
        Scanner input = new Scanner(System.in);

        // Menu setup and launch.
        PharmacyMenu menu = new PharmacyMenu(system, prescriptionService, prescriptionReports, input);

        System.out.println("Pharmacy Management System started.");
        System.out.println("Use menu options to manage the system.");

        menu.runMenu();
    }
}
