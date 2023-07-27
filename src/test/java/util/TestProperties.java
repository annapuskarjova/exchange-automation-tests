package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import context.Constants;

public class TestProperties {
    /** The Constant props. */
    private static final Properties props = new Properties();

    /**
     * Load all propertie.
     */
    public static void loadAllProperties() {
        try {
            FileInputStream Locator;
            Locator = new FileInputStream(Constants.PROPERTY_FILE_PATH);
            props.load(Locator);
        } catch (IOException e) {
            LoggerUtil.getLogger().fatal("Could not load properties : " + e.getMessage());
        }
    }
}
