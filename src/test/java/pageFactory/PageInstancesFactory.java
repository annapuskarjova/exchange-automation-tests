package pageFactory;

import org.openqa.selenium.WebDriver;
import pages.BasePage;
import context.webDriverContext;

import java.lang.reflect.InvocationTargetException;

public class PageInstancesFactory {

    public static <T extends BasePage> T getInstance(Class<T> type) {
        try {
            return type.getConstructor(WebDriver.class).newInstance(webDriverContext.getDriver());
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                 | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
            return null;
        }
    }
}
