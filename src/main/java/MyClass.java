import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyClass {
    private static final Logger logger = LogManager.getLogger(MyClass.class);

    public static void main(String[] args) {
        doSomething();
    }
    public static void doSomething() {
        logger.debug("This is a debug message.");
        logger.info("This is an info message.");
        logger.error("This is an error message.");
    }
}
