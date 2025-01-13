package day3.Q5;

public class UserRegistration {

    // Method to register user
    public void registerUser(String username, String userCountry) throws InvalidCountryException {
        // Check if the user country is not India
        if (!userCountry.equalsIgnoreCase("India")) {
            // Throw the custom exception with the error message
            throw new InvalidCountryException("User Outside India cannot be registered");
        } else {
            // Successful registration message
            System.out.println("User registration done successfully");
        }
    }

}
