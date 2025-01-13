package day3.Q6;

// Class to validate age
public class AgeValidator {

    // Method to validate age
    public boolean isAgeValid(int age) {
        // Validate if age is between 18 and 59 (inclusive)
        return age >= 18 && age < 60;
    }

    // Method to check if age is valid, throws exception if not
    public void validateAge(int age) throws InvalidAgeException {
        if (!isAgeValid(age)) {
            throw new InvalidAgeException("Age must be between 18 and 59, inclusive.");
        }
    }
}
