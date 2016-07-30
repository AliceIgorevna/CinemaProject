package core;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

/**
 * Created by Алиса on 29.07.2016.
 */
public class ExcelTestDataReader {

    public static Object[][] getData(String excelFullName) {
        Object[][] testData = null;
        Row row = null;
        try (FileInputStream file = new FileInputStream(new File(excelFullName));
             XSSFWorkbook workbook = new XSSFWorkbook(file)) {
            XSSFSheet sheet = workbook.getSheetAt(0);
            int numberOfRows = sheet.getPhysicalNumberOfRows() - 1;
            int numberOfCells = sheet.getRow(0).getPhysicalNumberOfCells();
            testData = new Object[numberOfRows][numberOfCells];
            for (int i = 1; i <= numberOfRows; i++) {
                row = sheet.getRow(i);
                for (int j = 0; j < numberOfCells; j++) {
                    testData[i - 1][j] = row.getCell(j).toString();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return testData;
    }
}
