package day3.Q5;

// Custom Exception Class
public class InvalidCountryException extends Exception {

    // Default constructor
    public InvalidCountryException() {
        super();
    }

    // Constructor that accepts a message
    public InvalidCountryException(String message) {
        super(message);
    }
}
