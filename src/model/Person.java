
/**
 * Represents a person in the pharmacy system.
 *
 * <p>This base class stores shared identity and contact fields for patient and doctor records.</p>
 */
public class Person {
        private String name;
        private int age;
        private String phoneNumber;
        private int id;
    private static int idCounter = 1;

        /**
         * Creates a person record.
         *
         * @param name person name
         * @param age person age
         * @param phoneNumber person phone number
         */
        public Person(String name, int age, String phoneNumber) {
            this.name = name;
            this.age = age;
            this.phoneNumber = phoneNumber;
            this.id = idCounter++;
        }

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

        /**
         * Returns a formatted person summary.
         *
         * @return person details as text
         */
        @Override
        public String toString() {
            return  "id - " + id +
                    ", name - " + name + '\n' +
                    "age - " + age + ", phoneNumber - " + phoneNumber + '\n' +
                    System.lineSeparator();
        }
    }


