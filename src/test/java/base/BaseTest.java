package base;

import core.readers.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.AfishaPage;
import pages.base.BasePage;
import pages.HomePage;
import utils.driver.DriverFactory;

/**
 * Created by Алиса on 28.07.2016.
 */
public class BaseTest {
    private static WebDriver driver;
    private DriverFactory driverFactory;
    protected HomePage homePage;
    protected AfishaPage afishaPage;

    @BeforeClass
    public void setup() {
        driverFactory = new DriverFactory();
        driver = driverFactory.getDriver(PropertiesReader.getPropertyValue("browser.firefox"));
        BasePage.driver = driver;
    }

    @AfterClass
    public void cleanup() {
        driver.close();
    }
}
