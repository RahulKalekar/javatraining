package day3.Q6;
public class Q6 {

    public static void main(String[] args) {
        // Ensure that both name and age arguments are passed
        if (args.length != 2) {
            System.out.println("Error: Please provide both name and age as command-line arguments.");
            System.exit(1);  // Exit gracefully
        }

        String name = args[0];  // First argument is name
        int age = 0;

        // Create an instance of AgeValidator to validate age
        AgeValidator ageValidator = new AgeValidator();

        try {
            // Parse age from command-line argument
            age = Integer.parseInt(args[1]);

            // Validate the age using AgeValidator
            ageValidator.validateAge(age);

            // If age is valid, print the success message
            System.out.println("Registration successful for " + name + ", Age: " + age);

        } catch (NumberFormatException e) {
            // Handle case where age is not a valid number
            System.out.println("Error: Age must be a valid integer.");
            System.exit(1);  // Exit gracefully
        } catch (InvalidAgeException e) {
            // Handle the custom exception for invalid age
            System.out.println(e.getMessage());
            System.exit(1);  // Exit gracefully
        }
    }
}
