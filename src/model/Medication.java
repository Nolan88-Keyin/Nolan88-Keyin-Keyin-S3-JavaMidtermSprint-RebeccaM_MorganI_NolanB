
import java.time.LocalDate;
import java.util.Random;

/**
 * Represents a medication stored in the pharmacy.
 *
 * <p>Includes stock details and an expiration date value.</p>
 */
public class Medication {
    private String name;
    private String dosage;
    private int quantity;
    private int id;
    private static int idCounter = 1;
    private LocalDate expirationDate;

    /**
     * Creates a medication record.
     *
     * @param name medication name
     * @param dosage medication dosage text
     * @param quantity stock quantity
     */
    public Medication(String name, String dosage, int quantity) {

        this.name = name;
        this.dosage = dosage;
        this.quantity = quantity;
        this.id = idCounter++;
        this.expirationDate = generateRandomExpirationDate();
    }
    

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


    /**
     * Generates a random expiration date in a mixed past/future range.
     *
     * @return generated expiration date
     */
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

    
    /**
     * Returns a formatted medication summary.
     *
     * @return medication details as text
     */
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
