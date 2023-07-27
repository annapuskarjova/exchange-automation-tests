package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.WebDriverManager;
import context.webDriverContext;

import listeners.LogListener;
import listeners.ReportListener;
import util.LoggerUtil;
import util.TestProperties;

@Listeners({ ReportListener.class, LogListener.class })
public class BaseTest {

    /** The driver. */
    protected WebDriver driver;

    /** Before test */
    @BeforeClass
    protected void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("disable-infobars");
        driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        webDriverContext.setDriver(driver);
    }

    /** Global setup */
    @BeforeSuite(alwaysRun = true)
    public void globalSetup() {
        LoggerUtil.log("************************** Test Execution Started ************************************");
        TestProperties.loadAllProperties();
    }

    /** After test */
    @AfterClass
    public void wrapUp() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

    /**
     * Wrap all up.
     * @param context the context
     */
    @AfterSuite(alwaysRun = true)
    public void wrapAllUp(ITestContext context) {
        int total = context.getAllTestMethods().length;
        int passed = context.getPassedTests().size();
        int failed = context.getFailedTests().size();
        int skipped = context.getSkippedTests().size();
        LoggerUtil.log("Total number of testcases : " + total);
        LoggerUtil.log("Number of testcases Passed : " + passed);
        LoggerUtil.log("Number of testcases Failed : " + failed);
        LoggerUtil.log("Number of testcases Skipped  : " + skipped);
        LoggerUtil.log("************************** Test Execution Finished ************************************");
    }
}
