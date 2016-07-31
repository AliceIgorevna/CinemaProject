package core.writers;

import core.readers.PropertiesReader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Алиса on 31.07.2016.
 */
public class ResultWriter {
    public static void writeResultToFile(Map<Integer, String> result) {
        File resultFile = new File(PropertiesReader.getPropertyValue("resultPath"));
        String stringResult = "";
        try (FileWriter fileWriter = new FileWriter(resultFile)) {
            for (Map.Entry<Integer, String> entry : result.entrySet()) {
                stringResult += entry.getKey()+ " - " + entry.getValue() + '\n';
            }
            fileWriter.write(stringResult);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
