package utils.waiting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Алиса on 28.07.2016.
 */
public class Waiter {
    public static WebElement waitForElementPresent(By element, WebDriver driver) {
        return (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public static void waitPageLoading(WebDriver driver) {
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }
}
