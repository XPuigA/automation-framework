package common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractTest {

    protected static final Logger LOGGER = Logger.getLogger("MainLogger");

    protected AbstractTest() {
        injectProperties("test-configuration.properties");
        String level = System.getProperty("debug.level");
        if (level != null) {
            LOGGER.setLevel(Level.parse(level));
        }
    }

    private void injectProperties(String filename) {
        Properties props = new Properties();
        try(InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(filename)) {
            props.load(inputStream);
            for(String name: props.stringPropertyNames()) {
                if (System.getProperty(name) == null) { // If the property has been set by command line, do not overwrite it
                    System.setProperty(name, props.getProperty(name));
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading properties file: " + filename);
        }
    }
}
