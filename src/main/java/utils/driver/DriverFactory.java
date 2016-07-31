package utils.driver;

import org.openqa.selenium.WebDriver;
import utils.driver.Driver;


/**
 * Created by Алиса on 28.07.2016.
 */
public class DriverFactory {

    public WebDriver getDriver(String browser) {
        return Driver.getCurrentDriverInstance(browser);
    }
}
