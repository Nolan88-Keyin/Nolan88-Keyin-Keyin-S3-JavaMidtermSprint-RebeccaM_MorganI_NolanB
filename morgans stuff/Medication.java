
/*Morgan Ings*/

/*The Medication class represents a medication with information such as name, dosage, quantity, expiration date, and a unique ID.*/
/* It also maintains a static list of all medications created. */

/*importing necessary libraries */

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

/*creating the Medication class and defining variables/arrays */

public class Medication {
    private String name;
    private String dosage;
    private int quantity;
    private int id;
    private static int idCounter = 1; /* Static counter to generate unique IDs */
    private LocalDate expirationDate;
    public static ArrayList<Medication> medications = new ArrayList<>(); /* Static list to store all medications */

    public Medication(String name, String dosage, int quantity) { /* Constructor to initialize a Medication object with name, dosage, and quantity */

        this.name = name;
        this.dosage = dosage;
        this.quantity = quantity;
        this.id = idCounter++; /* Assign a unique ID and increment the counter after each instance */
        this.expirationDate = generateRandomExpirationDate(); /* Generate a random expiration date for the medication */
    }
    

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }


    /* Methods to manage the static list of medications */

    public void addMedication(Medication medication) {
        medications.add(medication);
    }

    public void removeMedication(Medication medication) {
        medications.remove(medication);
    }

    public static ArrayList<Medication> getMedications() {
        return medications;
    }

    /* Method to generate a random expiration date for the medication */
    /*Dates are able to be generated in the past or future so some may be expired and need to be removed */

    private static LocalDate generateRandomExpirationDate() {
        Random random = new Random();
        int year = random.nextInt(11) + 2023; // Random year between 2023 and 2033
        int month = random.nextInt(12) + 1; // Random month between 1 and 12
        int day = random.nextInt(31) + 1; // Random day between 1 and 31
        if (month == 2) { // Adjust for February
            day = Math.min(day, 28);
        } 
        else if (month == 4 || month == 6 || month == 9 || month == 11) { // Adjust for months with 30 days
            day = Math.min(day, 30);
        }
        return LocalDate.of(year, month, day); // Return the generated random date
    }

    
    /* Override the toString() method to provide a string representation of the Medication object */

    @Override
    public String toString() {
        return  "id - " + id + '\n' +
                "name - " + name + '\n' +
                "dosage - " + dosage + '\n' +
                "quantity - " + quantity + '\n' +
                "expirationDate - " + expirationDate + '\n' + 
                System.lineSeparator();
    }
}
