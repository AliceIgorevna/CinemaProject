package core.readers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Алиса on 28.07.2016.
 */
public class PropertiesReader {
    private static Properties loadProperties() throws IOException {
        Properties properties = new Properties();
        String filePath = "testing.properties";
        InputStream inputStream = PropertiesReader.class.getClassLoader().getResourceAsStream(filePath);
        if(inputStream!=null){
            properties.load(inputStream);
        }
        return properties;
    }
    public static String getPropertyValue(String key){
        Properties property = null;
        try {
            property = loadProperties();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return property.getProperty(key);
    }
}
