package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties configFile;

    static {
        String path = "src/test/resources/configuration.properties";
        try {
            //Loading the file:
            FileInputStream fileInputStream = new FileInputStream(path);
            //Instantiating the configFile object.
            configFile = new Properties();
            configFile.load(fileInputStream);
            fileInputStream.close();//close the stream.
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method will return the value of the key that was passed as a parameter
     * from the property file
     * @param key
     * @return
     */
    public static String getPropertyValue(String key){
        return configFile.getProperty(key);
    }
}
