
/*Morgan Ings*/

/*The TestPerson class is a test class that creates instances of the Patient, Doctor, Medication, and Prescription classes. It demonstrates the functionality of these classes by adding medications and prescriptions to patients, associating patients with doctors, and printing out the information for each doctor, their patients, medications, and prescriptions.*/

public class TestPerson {
    
    public static void main(String[] args) {
        

        Patient patient1 = new Patient("Jane Smith", 25, "098-765-4321");
        Patient patient2 = new Patient("Alice Johnson", 40, "555-123-4567");
        Patient patient3 = new Patient("Bob Williams", 35, "777-888-9999");
        Patient patient4 = new Patient("Emily Brown", 28, "111-222-3333");
        


        Doctor doctor1 = new Doctor("Dr. John Doe", 40, "709-555-1234", "Cardiology");
        Doctor doctor2 = new Doctor("Dr. Jane Smith", 35, "709-555-5678", "Dermatology");
        Doctor doctor3 = new Doctor("Dr. Michael Johnson", 45, "709-555-9012", "Pediatrics");
        Doctor doctor4 = new Doctor("Dr. Emily Davis", 38, "709-555-3456", "Orthopedics");
        


        /* Create medications for the patient */
        Medication medication1 = new Medication("Aspirin", "500mg", "30 tablets");
        Medication medication2 = new Medication("Ibuprofen", "200mg", "20 tablets");
        Medication medication3 = new Medication("Paracetamol", "500mg", "15 tablets");
        Medication medication4 = new Medication("Amoxicillin", "250mg", "10 capsules");
        Medication medication5 = new Medication("Metformin", "1000mg", "60 tablets");
        Medication medication6 = new Medication("Lisinopril", "10mg", "30 tablets");
        Medication medication7 = new Medication("Tylenol", "500mg", "20 tablets");
        Medication medication8 = new Medication("Simvastatin", "20mg", "30 tablets");
        Medication medication9 = new Medication("Omeprazole", "20mg", "14 capsules");

        /* Create prescriptions for the patient */
        Prescription prescription1 = new Prescription(patient1, doctor1, medication1);
        Prescription prescription2 = new Prescription(patient1, doctor1, medication2);
        Prescription prescription3 = new Prescription(patient2, doctor2, medication3);
        Prescription prescription4 = new Prescription(patient2, doctor2, medication4);
        Prescription prescription5 = new Prescription(patient3, doctor3, medication5);
        Prescription prescription6 = new Prescription(patient3, doctor3, medication6);
        Prescription prescription7 = new Prescription(patient4, doctor4, medication7);
        Prescription prescription8 = new Prescription(patient4, doctor4, medication8);
        Prescription prescription9 = new Prescription(patient4, doctor4, medication9);
    

        /* Add medications to the patient */
        patient1.addMedication(medication1);
        patient1.addMedication(medication2);
        patient2.addMedication(medication3);
        patient2.addMedication(medication4);
        patient3.addMedication(medication5);
        patient3.addMedication(medication6);
        patient4.addMedication(medication7);
        patient4.addMedication(medication8);
        patient4.addMedication(medication9);

        /* Add prescriptions to the patient */
        patient1.addPrescription(prescription1);
        patient1.addPrescription(prescription2);
        patient2.addPrescription(prescription3);
        patient2.addPrescription(prescription4);
        patient3.addPrescription(prescription5);
        patient3.addPrescription(prescription6);
        patient4.addPrescription(prescription7);
        patient4.addPrescription(prescription8);
        patient4.addPrescription(prescription9);

        /*add info to classes like adding patients to the doctors list */
        doctor1.addPatient(patient1);
        doctor2.addPatient(patient2);
        doctor3.addPatient(patient3);
        doctor4.addPatient(patient4);

        /* Create an ArrayList to hold the doctors */
        Doctor[] doctors = {doctor1, doctor2, doctor3, doctor4};
        


        System.out.println();/*blank line */

        /* Print out the information for each doctor, their patients, medications, and prescriptions using a for loop */

        for (Doctor doctor : doctors) {
            System.out.println(doctor);

            System.out.println();/*blank line */

            for (Patient patient : doctor.getPatients()) { /* Print out the patients of the doctor */
                System.out.println("Patients of " + doctor.getName() + ":");
                System.out.println(patient);

            System.out.println();/*blank line */

            System.out.println("Medications:");/*print out patient's medications */
            for (Medication med : patient.getMedications()) {
                System.out.println(med);
            }

            System.out.println();/*blank line */

            System.out.println("Prescriptions:");/*print out patient's prescriptions */
            for (Prescription pres : patient.getPrescriptions()) {
                System.out.println(pres);
            }

            System.out.println();/*blank line */
        }}

        
    }
}
