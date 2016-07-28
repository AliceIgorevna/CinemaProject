package pages;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Алиса on 28.07.2016.
 */
public abstract class BasePage {
    public static WebDriver driver;
    public static String BASE_URL = "http://www.kinofilms.ua/";
    public BasePage(WebDriver driver){
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        BasePage.driver = driver;
    }
    public static <T> T open(String URL, Class<T> classType) throws Exception {
        driver.get(URL);
        driver.manage().window().maximize();
        return classType.getConstructor(WebDriver.class).newInstance(driver);
    }

}
