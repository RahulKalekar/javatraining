package day3.Q5;

public class InvalidCountryException extends RuntimeException {
    public InvalidCountryException(String message) {
        super(message);
    }

    public InvalidCountryException() {
        super("Angrez not allowed");
    }
}
