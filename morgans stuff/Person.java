
/*Morgan Ings*/

/*The Person class represents a person with basic information such as name, age, phone number, and a unique ID.*/
/* It serves as a base class for other classes like Doctor and Patient, which inherit from Person.*/


/*Creating the class and defining variables */
public class Person {
        private String name;
        private int age;
        private String phoneNumber;
        private int id;
        private static int idCounter = 1; /* Static counter to generate unique IDs */

        public Person(String name, int age, String phoneNumber) { /* Constructor to initialize a Person object with name, age, and phone number */
            this.name = name;
            this.age = age;
            this.phoneNumber = phoneNumber;
            this.id = idCounter++; /* Assign a unique ID and increment the counter after each instance */
        }

        /* Getters and setters for the Person class */

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public int getId() {
            return id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public void setId(int id) {
            this.id = id;
        }

        /* Override the toString() method to provide a string representation of the Person object */
        
        @Override
        public String toString() {
            return  "id - " + id +
                    ", name - " + name + '\n' +
                    "age - " + age + ", phoneNumber - " + phoneNumber + '\n' +
                    System.lineSeparator();
        }
    }
        
        
