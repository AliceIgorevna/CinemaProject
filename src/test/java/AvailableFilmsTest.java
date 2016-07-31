import base.BaseTest;
import core.readers.DataProviderUtil;
import core.readers.JsonTestDataReader;
import core.writers.ResultWriter;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.base.BasePage;
import pages.HomePage;

import java.util.Map;

/**
 * Created by Алиса on 31.07.2016.
 */
public class AvailableFilmsTest extends BaseTest {

    @Test(dataProvider = "test", dataProviderClass = DataProviderUtil.class)
    public void test(String headerItemName, String listItemName, String expectedUrl, String city, String date) throws Exception {
        homePage = BasePage.open(JsonTestDataReader.readJson("data_set", "url"), HomePage.class);
        afishaPage = homePage.clickOnItemFromHeaderDropDownMenu(headerItemName, listItemName);
        Assert.assertEquals(afishaPage.getCurrentUrl(), expectedUrl, "Check url adress");
        afishaPage.setCityOptionFromToolbar(city);
        afishaPage.setDateOptionFromToolbar(date);
        Map<Integer, String> result = afishaPage.getAllAvailableFilmsTitle();
        ResultWriter.writeResultToFile(result);
    }
}
