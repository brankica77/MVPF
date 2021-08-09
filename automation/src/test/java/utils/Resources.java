package utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class Resources {
    public static String propFileName ="config.properties";

    public static String getResourcePath (String resource){
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL urlResource = classLoader.getResource(resource);

        if(urlResource == null){
            throw new RuntimeException("There is no resource: " + resource);
        }
        return urlResource.getPath();
    }

    //gets property from properties file by property name
    public static String getProperty(String propName) throws IOException {
        String property = "";
        InputStream inputStream = null;
        try{
            Properties prop = new Properties();
            inputStream = Resources.class.getClassLoader().getResourceAsStream(propFileName);
            //getClass().getClassLoader().getResourceAsStream(propFileName);
            if (inputStream != null){
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file " + propFileName + "not found.");
            }

            property = prop.getProperty(propName);
        }catch (Exception e){
            return "";
        }finally {
            inputStream.close();
        }
        return property;
    }
}
