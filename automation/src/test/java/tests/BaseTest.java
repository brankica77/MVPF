package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Resources;

import java.io.IOException;
import java.time.Duration;

import static java.time.Duration.*;

public class BaseTest {
    protected WebDriver driver;

    //public String homeURL = Resources.getPropertyFromPropertiesFile("homeURL","config.properties");
    public String homeURL = Resources.getProperty("homeURL");
    public String username = Resources.getProperty("username");
    public String password = Resources.getProperty("password");

    public String basePath = System.getProperty("user.dir");

    public String expectedRelativePath = "\\src\\main\\resources\\captions.json";
    public String expectedFilePath = basePath + expectedRelativePath;

    public BaseTest() throws IOException {
    }

    public boolean isPresent(WebElement element){
        boolean present;
        if (element != null){
            present = true;
        }
        else{
            present = false;
        }
        return present;
    }

    public boolean isMatch (String actual, String expected){
        if (actual.equals(expected)){
            return true;
        }
        else {
            if(actual.contains(expected)){
                return true;
            }
            else {
                return false;
            }
        }
    }

    public long waitUntilElementDisappears (By element, long duration){
        WebDriverWait wait = new WebDriverWait(driver, duration);;
        long time = System.currentTimeMillis();

        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(element)));

        return System.currentTimeMillis() - time;
    }
}
