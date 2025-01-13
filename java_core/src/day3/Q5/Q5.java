package day3.Q5;


public class Q5 {

    public static void main(String[] args) {
        try {
            registerUser("Rahul","Bharat");
            registerUser("Joe Root","England");
        } catch (InvalidCountryException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void registerUser(String username,String country) {
        if (country.equals("Bharat")) {
            System.out.println("User registered success");
        }
        else {
            throw new InvalidCountryException();
        }
    }
}