import core.ExcelTestDataReader;
import core.JsonTestDataReader;
import core.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AfishaPage;
import pages.BasePage;
import pages.HomePage;
import utils.DriverFactory;

import java.util.Map;

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

    @DataProvider(name = "test")
    public static Object[][] testData() {
        return ExcelTestDataReader.getData("src//test//resources//test.xlsx");
    }

    @Test(dataProvider = "test")
    public void test(String headerItemName, String listItemName, String expectedUrl, String city, String date) throws Exception {
        homePage = BasePage.open(JsonTestDataReader.readJson("data_set", "url"), HomePage.class); //"http://www.kinofilms.ua/"
        afishaPage = homePage.clickOnItemFromHeaderDropDownMenu(headerItemName, listItemName);
        Assert.assertEquals(afishaPage.getCurrentUrl(), expectedUrl, "Check url adress");
        afishaPage.setCityOptionFromToolbar(city);
        afishaPage.setDateOptionFromToolbar(date);
        Map<Integer, String> result = afishaPage.getAllAvailableFilmsTitle();
        for (Map.Entry<Integer, String> entry : result.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    @AfterClass
    public void cleanup() {
        driver.close();
    }
}
