package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDrivers {

    public static void silentyCloseDriver (WebDriver driver){
        try {
            if (driver != null){
                driver.close();
                driver.quit();
            }
        } catch (Exception e){
            //silenty close
        }
    }

    public static WebDriver chromeDriver() throws IllegalAccessException, InstantiationException {
        Class<? extends WebDriver> driverClass = ChromeDriver.class;
        WebDriverManager.getInstance(driverClass).setup();
        WebDriver webDriver = driverClass.newInstance();

        return webDriver;
    }
}
