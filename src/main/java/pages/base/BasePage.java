package pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.waiting.Waiter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Алиса on 28.07.2016.
 */
public abstract class BasePage {
    private Actions actions;
    public static WebDriver driver;

    public BasePage(WebDriver webDriver) {
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        BasePage.driver = webDriver;
        actions = new Actions(driver);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static <T> T open(String URL, Class<T> classType) throws Exception {
        driver.get(URL);
        driver.manage().window().maximize();
        return classType.getConstructor(WebDriver.class).newInstance(driver);
    }

    public WebElement findElement(By element) {
        return driver.findElement(element);
    }

    public List<WebElement> findElements(By element) {
        return driver.findElements(element);
    }

    public void sendKeysToElement(By element, String value) {
        Waiter.waitForElementPresent(element, driver).sendKeys(value);
    }

    public void hoverToElement(WebElement element) {
        actions.moveToElement(element).build().perform();
    }

    public void click(By element) {
        findElement(element).click();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public List<String> getElementText(By element) {
        List<String> text = new ArrayList<>();
        for (WebElement e : findElements(element)) {
            text.add(e.getText());
        }
        return text;
    }
}
