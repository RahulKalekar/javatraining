package factory;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    private static final String PROPERTIES_FILE = "dbconn.properties";

    public Connection getConnection() throws SQLException {
        Properties properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
            if (input == null) {
                throw new FileNotFoundException("dbconn file not found");
            }
            properties.load(input);

            String url = properties.getProperty("jdbc.url");
            String username = properties.getProperty("jdbc.username");
            String password = properties.getProperty("jdbc.password");
            String driver = properties.getProperty("jdbc.driver");

            Class.forName(driver);
            return DriverManager.getConnection(url, username, password);

        } catch (IOException | ClassNotFoundException e) {
            throw new SQLException("Error loading db", e);
        }
    }
}

