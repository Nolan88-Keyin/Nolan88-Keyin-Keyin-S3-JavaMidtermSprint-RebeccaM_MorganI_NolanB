
// /*Morgan Ings*/

// /*The TestPerson class is a test class that creates instances of the Patient, Doctor, Medication, and Prescription classes. It demonstrates the functionality of these classes by adding medications and prescriptions to patients, associating patients with doctors, and printing out the information for each doctor, their patients, medications, and prescriptions.*/

// import java.util.Scanner;

// public class TestPerson {
    
//     public static void main(String[] args) {


//         MedicationTrackingSystem system = new MedicationTrackingSystem(); /* Create an instance of the MedicationTrackingSystem class to manage patients, doctors, medications, and prescriptions and to have control overall as one system instead of a bunch of branches */

       


//         PrescriptionService prescriptionService = new PrescriptionService(system);
//         PrescriptionReports reports = new PrescriptionReports(system);
//         Scanner input = new Scanner(System.in);
        

//         PharmacyMenu menu = new PharmacyMenu(system, prescriptionService, reports, input);
        

//         Patient patient1 = new Patient("Jane Smith", 25, "098-765-4321");
//         Patient patient2 = new Patient("Alice Johnson", 40, "555-123-4567");
//         Patient patient3 = new Patient("Bob Williams", 35, "777-888-9999");
//         Patient patient4 = new Patient("Emily Brown", 28, "111-222-3333");
        


//         Doctor doctor1 = new Doctor("Dr. John Doe", 40, "709-555-1234", "Cardiology");
//         Doctor doctor2 = new Doctor("Dr. Jane Smith", 35, "709-555-5678", "Dermatology");
//         Doctor doctor3 = new Doctor("Dr. Michael Johnson", 45, "709-555-9012", "Pediatrics");
//         Doctor doctor4 = new Doctor("Dr. Emily Davis", 38, "709-555-3456", "Orthopedics");
        


//         /* Create medications for the patient */
//         Medication medication1 = new Medication("Aspirin", "500mg", 30);
//         Medication medication2 = new Medication("Ibuprofen", "200mg", 20);
//         Medication medication3 = new Medication("Paracetamol", "500mg", 15);
//         Medication medication4 = new Medication("Amoxicillin", "250mg", 10);
//         Medication medication5 = new Medication("Metformin", "1000mg", 60);
//         Medication medication6 = new Medication("Lisinopril", "10mg", 30);
//         Medication medication7 = new Medication("Tylenol", "500mg", 20);
//         Medication medication8 = new Medication("Simvastatin", "20mg", 30);
//         Medication medication9 = new Medication("Omeprazole", "20mg", 14);

//         /* Create prescriptions for the patient */
//         Prescription prescription1 = new Prescription(patient1, doctor1, medication1);
//         Prescription prescription2 = new Prescription(patient1, doctor1, medication2);
//         Prescription prescription3 = new Prescription(patient2, doctor2, medication3);
//         Prescription prescription4 = new Prescription(patient2, doctor2, medication4);
//         Prescription prescription5 = new Prescription(patient3, doctor3, medication5);
//         Prescription prescription6 = new Prescription(patient3, doctor3, medication6);
//         Prescription prescription7 = new Prescription(patient4, doctor4, medication7);
//         Prescription prescription8 = new Prescription(patient4, doctor4, medication8);
//         Prescription prescription9 = new Prescription(patient4, doctor4, medication9);


//         /*adding all data to the system so its all contained in one place */

//         /* Add patients to the system */
//         system.addPatient(patient1);
//         system.addPatient(patient2);
//         system.addPatient(patient3);
//         system.addPatient(patient4);

//         /* Add doctors to the system */
//         system.addDoctor(doctor1);
//         system.addDoctor(doctor2);
//         system.addDoctor(doctor3);
//         system.addDoctor(doctor4);

//         /* Add medications to the system */
//         system.addMedication(medication1);
//         system.addMedication(medication2);
//         system.addMedication(medication3);
//         system.addMedication(medication4);
//         system.addMedication(medication5);
//         system.addMedication(medication6);
//         system.addMedication(medication7);
//         system.addMedication(medication8);
//         system.addMedication(medication9);

//         /* Add prescriptions to the system */
//         system.addPrescription(prescription1);
//         system.addPrescription(prescription2);
//         system.addPrescription(prescription3);
//         system.addPrescription(prescription4);
//         system.addPrescription(prescription5);
//         system.addPrescription(prescription6);
//         system.addPrescription(prescription7);
//         system.addPrescription(prescription8);
//         system.addPrescription(prescription9);
    

//         /* Add medications to the patient */
//         patient1.addMedication(medication1);
//         patient1.addMedication(medication2);
//         patient2.addMedication(medication3);
//         patient2.addMedication(medication4);
//         patient3.addMedication(medication5);
//         patient3.addMedication(medication6);
//         patient4.addMedication(medication7);
//         patient4.addMedication(medication8);
//         patient4.addMedication(medication9);

//         /* Add prescriptions to the patient */
//         patient1.addPrescription(prescription1);
//         patient1.addPrescription(prescription2);
//         patient2.addPrescription(prescription3);
//         patient2.addPrescription(prescription4);
//         patient3.addPrescription(prescription5);
//         patient3.addPrescription(prescription6);
//         patient4.addPrescription(prescription7);
//         patient4.addPrescription(prescription8);
//         patient4.addPrescription(prescription9);

//         /*add info to classes like adding patients to the doctors list */
//         doctor1.addPatient(patient1);
//         doctor2.addPatient(patient2);
//         doctor3.addPatient(patient3);
//         doctor4.addPatient(patient4);

        

        


//         System.out.println();/*blank line */

//         /* Print out the information for each doctor, their patients, medications, and prescriptions using a for loop */

//         for (Doctor doctor : system.getDoctors()) { /* Loop through the list of doctors in the system */
//             System.out.println(doctor);

//             System.out.println();/*blank line */

//             for (Patient patient : doctor.getPatients()) { /* Print out the patients of the doctor */
//                 System.out.println("Patients of " + doctor.getName() + ":");
//                 System.out.println(patient);

//             System.out.println();/*blank line */

//             System.out.println("Medications:");/*print out patient's medications */
//             for (Medication med : patient.getMedications()) {
//                 System.out.println(med);
//             }

//             System.out.println();/*blank line */

//             System.out.println("Prescriptions:");/*print out patient's prescriptions */
//             for (Prescription pres : patient.getPrescriptions()) {
//                 System.out.println(pres);
//             }

//             System.out.println();/*blank line */
//         }}

//         System.out.println("All Doctors in the System:");
//         for (Doctor doctor : system.getDoctors()) {
//             System.out.println(doctor);
//         }

//         System.out.println("All Patients in the System:");
//         for (Patient patient : system.getPatients()) { /* Print out all patients in the system */
//             System.out.println(patient);
//         }

//         System.out.println(system.getMedications());
//         System.out.println(system.getPrescriptions());
        
//     }
// }
