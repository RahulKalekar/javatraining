import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyClass {
    private static final Logger logger = LogManager.getLogger(MyClass.class);

    public static void main(String[] args) {
        logger.info("Application started");

        // Your business logic here
        logger.debug("This is a debug message");
        logger.error("This is an error message");
    }
}
