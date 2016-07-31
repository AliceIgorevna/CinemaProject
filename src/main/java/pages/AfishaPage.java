package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;
import utils.waiting.Waiter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Алиса on 28.07.2016.
 */
public class AfishaPage extends BasePage {
    private final String CITY_BUTTON = ".//*[contains(@class, 'scroll')]/preceding-sibling::*";
    private final String CITY_DROPDOWN_ITEM = ".//*[contains(@class, 'scroll')]/li/a[contains(text(), '%s')]";
    private final String DATE_BUTTON = ".//*[@id='dlist']/preceding-sibling::*";
    private final String DATE_DROPDOWN_ITEM = ".//*[@id='dlist']/li/a[contains(text(), '%s')]";
    private final String FILMS_TITLE = ".//div[@class='row']/div[@class='span6']/div[@class='h3']/a";
    private final String DROP_DOWN_MENU = ".//*[contains(@class,'dropdown-menu')]";

    @FindBy(xpath = CITY_BUTTON)
    public WebElement cityButton;

    @FindBy(xpath = DATE_BUTTON)
    public WebElement dateButton;


    public AfishaPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void setCityOptionFromToolbar(String city) {
        click(By.xpath(CITY_BUTTON));
        Waiter.waitForElementPresent(By.xpath(DROP_DOWN_MENU), BasePage.driver);
        click(By.xpath(String.format(CITY_DROPDOWN_ITEM, city)));
    }

    public void setDateOptionFromToolbar(String date) {
        Waiter.waitPageLoading(getDriver());
        click(By.xpath(DATE_BUTTON));
        Waiter.waitForElementPresent(By.xpath(DROP_DOWN_MENU), BasePage.driver);
        click(By.xpath(String.format(DATE_DROPDOWN_ITEM, date)));
    }

    public Map<Integer, String> getAllAvailableFilmsTitle() {
        Map<Integer, String> films = new HashMap<>();
        List<WebElement> filmsTitleElements = findElements(By.xpath(FILMS_TITLE));
        for (int i = 0; i < filmsTitleElements.size(); i++) {
            films.put(i + 1, filmsTitleElements.get(i).getText());
        }
        return films;
    }
}
