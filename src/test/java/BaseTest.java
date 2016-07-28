import core.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.DriverFactory;

/**
 * Created by Алиса on 28.07.2016.
 */
public class BaseTest {
    private static WebDriver driver;
    private DriverFactory driverFactory;

    @BeforeClass
    public void setup() {
        driverFactory = new DriverFactory();
        driver = driverFactory.getDriver(PropertiesReader.getPropertyValue("browser.firefox"));
    }

    /*@Test
    public void test(){
        driver.get("http://www.kinofilms.ua/");
    }*/
    @AfterClass
    public void cleanup() {
        driver.close();
    }
}
