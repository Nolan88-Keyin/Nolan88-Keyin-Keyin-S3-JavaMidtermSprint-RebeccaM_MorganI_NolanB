# Pharmacy Management System

This repository contains a Java console application for managing pharmacy operations such as patients, doctors, medications, prescriptions, reporting, and restocking.

## Documentation Guide
- User documentation: [USER_DOCUMENTATION.md](USER_DOCUMENTATION.md)
	- Use this for running the app, using the menu, and understanding feature behavior from an end-user perspective.
- Development documentation: [DEVELOPMENT_DOCUMENTATION.md](DEVELOPMENT_DOCUMENTATION.md)
	- Use this for architecture, class responsibilities, build process, dependencies, standards, Javadocs, and theoretical database design.

## Where To Start
1. Read [USER_DOCUMENTATION.md](USER_DOCUMENTATION.md) for setup and menu usage.
2. Read [DEVELOPMENT_DOCUMENTATION.md](DEVELOPMENT_DOCUMENTATION.md) for technical implementation details.
3. Build and run the program using the commands documented in both files.

## Basic Folder Structure
- [src](src)
	- Main Java source files.
- [src/model](src/model)
	- Domain classes: Person, Patient, Doctor, Medication, Prescription.
- [src/service](src/service)
	- Core system logic, prescription workflow, and reporting logic.
- [src/app](src/app)
	- Application entry point and Scanner-based menu.
- [bin](bin)
	- Compiled class files output by the Java compiler.
- [docs](docs)
	- Diagram assets used by documentation (class and ER diagrams).

## Team
- NolanB
- MorganI
- RebeccaM

## Team Contributions

### Morgan
Created the classes in the model folder and designed the class diagram.

### Rebecca
Developed the MedicationTrackingSystem.

### Nolan
Created ui (PharmacyManagementApp and PharmacyMenu), developed the PrescriptionService and PrescriptionReports files, and designed the ER diagram.
