package day3.Q5;

public class Q5 {
    public static void main(String[] args) {
        // Create an instance of UserRegistration
        UserRegistration userRegistration = new UserRegistration();

        // Example 1: User from India
        try {
            userRegistration.registerUser("JohnDoe", "India");
        } catch (InvalidCountryException e) {
            System.out.println(e.getMessage());
        }

        // Example 2: User from outside India
        try {
            userRegistration.registerUser("JaneDoe", "USA");
        } catch (InvalidCountryException e) {
            System.out.println(e.getMessage());
        }
    }
}
