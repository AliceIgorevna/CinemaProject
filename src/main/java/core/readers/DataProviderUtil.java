package core.readers;

/**
 * Created by Алиса on 30.07.2016.
 */
public class DataProviderUtil {
    @org.testng.annotations.DataProvider(name = "test")
    public static Object[][] testData() {
        return ExcelTestDataReader.getData(PropertiesReader.getPropertyValue("excelPath"));
    }
}
