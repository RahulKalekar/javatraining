package practice;

import java.io.*;

// Serializable class with a transient field
class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String username;
    private transient String password; // Marked as transient, won't be serialized

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{username='" + username + "', password='" + password + "'}";
    }
}

class TransientExample {
    public static void main(String[] args) {
        User user = new User("john_doe", "my_secret_password");
        String filename = "user.ser";

        // Serialize the object
        /*try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(user);
            System.out.println("Serialized User: " + user);
        } catch (IOException e) {
            e.printStackTrace();
        }

         */

        // Deserialize the object
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            User deserializedUser = (User) ois.readObject();
            System.out.println("Deserialized User: " + deserializedUser);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
