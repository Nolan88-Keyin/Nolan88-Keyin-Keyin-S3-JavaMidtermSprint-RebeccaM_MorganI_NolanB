# User Documentation: Pharmacy Management System

## 1. Application Overview
- Project name: Pharmacy Management System
- Team members: NolanB, MorganI, RebeccaM
- Purpose of the application: This application manages core pharmacy operations using object-oriented design, including patient, doctor, medication, and prescription records. It supports adding, editing, deleting, and searching records, accepting prescriptions, assigning patients to doctors, checking expired medications, restocking inventory, and generating reports for pharmacy staff.

## 2. Features at a Glance
- Add patient, doctor, medication
- Delete patient, doctor, medication
- Edit patient, doctor, medication
- Search patient, doctor, medication by name
- Accept a prescription
- Assign patient to doctor
- Generate reports
- Check expired medications
- Restock medication

## 3. How to Start the Program
### 3.1 From Project Root
1. Open a terminal in the project root folder.
2. Compile all Java source files into the bin folder.
3. Run the main application class.

Note: `javac -d bin ...` usually creates the bin folder automatically. If you get an output-path or permission error, create the bin folder manually and run the compile command again.

### 3.2 Windows (PowerShell)
```powershell
# Compile all Java files
$sources = Get-ChildItem -Path src -Recurse -Filter *.java | ForEach-Object { $_.FullName }
javac -d bin $sources

# Run the program
java -cp bin PharmacyManagementApp
```

### 3.3 Linux/macOS (bash)
```bash
# Compile all Java files
javac -d bin src/model/*.java src/service/*.java src/app/*.java

# Run the program
java -cp bin PharmacyManagementApp
```

## 4. How to Use the Menu
### Main Menu Options
1. Add
2. Delete
3. Edit
4. Search
5. Accept Prescription
6. Add Patient to Doctor
7. Full System Report
8. Expired Medications Report
9. Prescriptions by Doctor
10. Patient Past-Year Prescription Report
11. Restock Medication
0. Exit

### 4.1 Add
- Input required:
  - Select type: 1 Patient, 2 Doctor, or 3 Medication.
  - Patient: name, age, phone.
  - Doctor: name, age, phone, specialty.
  - Medication: name, dosage, quantity.
- Expected output:
  - Success message such as Patient added, Doctor added, or Medication added.
  - If a number is invalid, the menu asks again until a valid whole number is entered.
- Example:
  - Add -> 1 (Patient)
  - Name: Chris Stone
  - Age: 31
  - Phone: 709-555-0101
  - Output: Patient added.

### 4.2 Delete
- Input required:
  - Select type: 1 Patient, 2 Doctor, or 3 Medication.
  - Enter the name of the record to delete.
- Expected output:
  - If found: Patient deleted, Doctor deleted, or Medication deleted.
  - If not found: corresponding not found message.
- Example:
  - Delete -> 3 (Medication)
  - Medication name: Aspirin
  - Output: Medication deleted.

### 4.3 Edit
- Input required:
  - Select type: 1 Patient, 2 Doctor, or 3 Medication.
  - Enter existing name to locate the record.
  - Enter new values for that record.
- Expected output:
  - If found: updated confirmation message.
  - If not found: corresponding not found message.
- Example:
  - Edit -> 2 (Doctor)
  - Doctor name to edit: Dr. John Doe
  - New name: Dr. John Doe
  - New age: 41
  - New phone: 709-555-7777
  - New specialty: Cardiology
  - Output: Doctor updated.

### 4.4 Search
- Input required:
  - Select type: 1 Patient, 2 Doctor, or 3 Medication.
  - Enter the name to search.
- Expected output:
  - If found: full object details printed to console.
  - If not found: corresponding not found message.
- Example:
  - Search -> 1 (Patient)
  - Patient name: Jane Smith
  - Output: patient details including id, name, age, and phone.

### 4.5 Accept Prescription
- Input required:
  - Doctor name
  - Patient name
  - Medication name
- Validation behavior (missing doctor/patient/medication, expired, out of stock):
  - If doctor, patient, or medication cannot be found: Doctor, patient, or medication was not found.
  - If medication is expired: prescription is rejected.
  - If medication quantity is 0: prescription is rejected.
- Expected output:
  - On success, prescription is accepted, linked to patient and system records, medication stock is decreased by 1, and a confirmation message is printed.

### 4.6 Reports
- Full system report:
  - Prints all doctors, patients, medications, and prescriptions currently stored in the system.
- Expired medications report:
  - Prints only medications with expiration date before today.
  - If none are expired, prints No expired medications found.
- Prescriptions by doctor:
  - Prompts for doctor name and prints prescriptions issued by that doctor.
  - If doctor is not found or no matching prescriptions exist, a clear message is shown.
- Patient past-year prescription summary:
  - Prints a summarized list of medication names prescribed within the past year, with counts.

### 4.7 Restock Medication
- Input required:
  - Enter amount to add to all medications (must be at least 1).
- Expected output:
  - Increases quantity of every medication by the entered amount.
  - Prints All medications restocked.
- Example:
  - Restock -> Amount to add: 5
  - Output: All medications restocked.

## 5. Class Diagram
The following diagram shows the core classes and how they are related:

[Pharmacy class diagram](docs/class-diagram.svg)

Arrows indicate inheritance and association relationships between classes.

If the diagram preview does not render in your Markdown viewer, open `docs/class-diagram.svg` directly.

## 6. Example User Flow
1. Start the app from the project root.
2. Select Add, then add a doctor.
3. Select Add, then add a patient.
4. Select Add, then add a medication with a quantity greater than 0.
5. Select Add Patient to Doctor and enter the doctor and patient names.
6. Select Accept Prescription and enter doctor, patient, and medication names.
7. Confirm the success message that the prescription was accepted.
8. Select Prescriptions by Doctor and enter the same doctor name.
9. Review the printed prescription details to verify the link was created.
10. Select Full System Report to view all stored records together.

# Thank you for using the Pharmacy Management System.

