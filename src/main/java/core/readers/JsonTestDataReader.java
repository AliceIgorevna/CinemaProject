package core.readers;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by Алиса on 30.07.2016.
 */
public class JsonTestDataReader {

    public static String readJson(String setName, String key) {
        String result = null;
        try {
            JsonElement element = new JsonParser().parse(new FileReader(PropertiesReader.getPropertyValue("jsonPath")));
            JsonObject object = element.getAsJsonObject().get(setName).getAsJsonObject();
            result = object.get(key).getAsString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
}
