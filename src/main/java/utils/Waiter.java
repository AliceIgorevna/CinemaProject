package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Алиса on 28.07.2016.
 */
public class Waiter {
    public static WebElement waitForElementPresent(By element, WebDriver driver) {
        return (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(element));
    }
}
