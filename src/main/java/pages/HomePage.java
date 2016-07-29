package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Алиса on 28.07.2016.
 */
public class HomePage extends BasePage {
    public final String DROP_DOWN_HEADER_ELEMENT = ".//*[@data-toggle='dropdown' and contains(text(), '%s')]";
    public final String DROP_DOWN_LIST = DROP_DOWN_HEADER_ELEMENT + "/following-sibling::*//a[contains(text(), '%s')]";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void hoverToDropDownHeaderElementByName(String name) {
        hoverToElement(findElement(By.xpath(String.format(DROP_DOWN_HEADER_ELEMENT, name))));
    }

    public AfishaPage clickOnItemFromHeaderDropDownMenu(String headerMenuItemName, String listItemName) {
        hoverToDropDownHeaderElementByName(headerMenuItemName);
        click(By.xpath(String.format(DROP_DOWN_LIST, headerMenuItemName, listItemName)));
        //Waiter.waitForElementPresent(By.xpath(String.format(DROP_DOWN_HEADER_ELEMENT, headerMenuItemName, listItemName)), driver);
        return new AfishaPage(driver);
    }

}
