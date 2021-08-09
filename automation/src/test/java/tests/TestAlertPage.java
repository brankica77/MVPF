package tests;

import data.Expected;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.BootstrapAlertPage;
import utils.WebDrivers;

import java.io.IOException;

public class TestAlertPage extends BaseTest {
    BootstrapAlertPage alertPage;
    private Expected expected;

    public TestAlertPage() throws IOException {
    }

    @BeforeTest
    public void init() throws IOException, InstantiationException, IllegalAccessException {
        expected = Expected.get(expectedFilePath);
        driver = WebDrivers.chromeDriver();
        alertPage = PageFactory.initElements(driver, BootstrapAlertPage.class);

        driver.navigate().to(homeURL + alertPage.alertPageUrl);
        driver.manage().window().maximize();
    }

    @AfterTest
    public void therdown (){
        if (driver != null){
            WebDrivers.silentyCloseDriver(driver);
        }
    }

    @Test
    public void autocloseableSuccessMessage() {
        alertPage.clickAutocloseableSuccess();

        Assert.assertTrue(isMatch(alertPage.autoclosableSuccessAlert.getText(), expected.autocloseableSuccessMessage()),
                "Autocloseable success message is incorrect!");

        Assert.assertTrue(((alertPage.autocloseableSuccessAlertTime+1) <
                        waitUntilElementDisappears(alertPage.autoclosableSuccessMessage,
                                alertPage.autocloseableSuccessAlertTime +1)),
                "Alert didn't disappear in " + alertPage.autocloseableSuccessAlertTime);
    }

    // @Test
    public void normalSuccessMessage() {
        alertPage.clickNormalSuccess();
        Assert.assertTrue(isMatch(alertPage.normalSuccessAlert.getText(), expected.normalSuccessMessage()),
                "Normal success message is incorrect!");
        alertPage.closeNormalSuccess();
    }
}
