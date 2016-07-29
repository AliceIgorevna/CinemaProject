package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Алиса on 28.07.2016.
 */
public class Driver {
    public static WebDriver driver;

    private Driver() {
    }

    public static WebDriver getCurrentDriverInstance(String browser) {
        if (browser.equals("chrome")) {
            return driver = new FirefoxDriver();
        }
        if (browser.equals("firefox")) {
            return driver = new FirefoxDriver();
        } else
            return null;
    }
}
