package factory;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class ConnectionFactory {
    private static final String PROPERTIES_FILE = "/dbconn.properties";
    private static String url;
    private static String username;
    private static String password;

    static {
        try (InputStream inputStream = ConnectionFactory.class.getResourceAsStream(PROPERTIES_FILE)) {
            Properties props = new Properties();
            if (inputStream != null) {
                props.load(inputStream);
            } else {
                throw new RuntimeException("Properties file not found in the resource folder");
            }
            Class.forName(props.getProperty("jdbc.drivername"));
            url = props.getProperty("jdbc.url");
            username = props.getProperty("jdbc.username");
            password = props.getProperty("jdbc.password");
        } catch (Exception e) {
            throw new RuntimeException("Failed to load database connection properties", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}
