package day3.Q6;

// Custom Exception Class for Invalid Age
public class InvalidAgeException extends Exception {

    // Default constructor
    public InvalidAgeException() {
        super("Invalid age entered");
    }

    // Constructor that accepts a custom message
    public InvalidAgeException(String message) {
        super(message);
    }
}
