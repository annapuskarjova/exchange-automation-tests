package context;
import org.openqa.selenium.WebDriver;

public class webDriverContext {

    /** The driverInstance. */
    private static InheritableThreadLocal<WebDriver> driverinstance = new InheritableThreadLocal<>();

    public static WebDriver getDriver() {
        if (driverinstance.get() == null)
            throw new IllegalStateException(
                    "WebDriver has not been set! Please set WebDriver instance by WebDriverContext.setDriver...");
        else
            return driverinstance.get();
    }

    /**
     * Sets the driver.
     * @param driver the new driver
     */
    public static void setDriver(WebDriver driver) {
        driverinstance.set(driver);
    }
}
