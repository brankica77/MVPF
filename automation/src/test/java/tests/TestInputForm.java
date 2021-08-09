package tests;

import data.Expected;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.InputFormWithValidationsPage;
import utils.WebDrivers;

import java.io.IOException;

public class TestInputForm extends BaseTest {
    InputFormWithValidationsPage inputPage;
    private Expected expected;

    public TestInputForm() throws IOException {
    }

    @BeforeTest
    public void init() throws IOException, InstantiationException, IllegalAccessException {
        expected = Expected.get(expectedFilePath);
        driver = WebDrivers.chromeDriver();
        inputPage = PageFactory.initElements(driver, InputFormWithValidationsPage.class);

        driver.navigate().to(homeURL + inputPage.inputFormUrl);
        driver.manage().window().maximize();
    }

    @AfterTest
    public void therdown (){
        if (driver != null){
            WebDrivers.silentyCloseDriver(driver);
        }
    }

    @Test
    public void emptyInputTest() {
        inputPage.clickSend();

        Assert.assertTrue(isMatch(inputPage.firstNameError.getText(), expected.getEmptyFirstNameError()),
                "First name error message failed!");

        Assert.assertTrue(isMatch(inputPage.lastNameError.getText(), expected.getEmptyLastNameError()),
                "Last name error message failed!");

        Assert.assertTrue(isMatch(inputPage.emailError.getText(), expected.getEmptyEmailError()),
                "Email error message failed!");

        Assert.assertTrue(isMatch(inputPage.phoneError.getText(), expected.getEmptyPhoneError()),
                "Phone error message failed!");

        Assert.assertTrue(isMatch(inputPage.addressError.getText(), expected.getEmptyAddressError()),
                "Phone error message failed!");

        Assert.assertTrue(isMatch(inputPage.cityError.getText(), expected.getEmptyCityError()),
                "City error message failed!");

        Assert.assertTrue(isMatch(inputPage.stateError.getText(), expected.getEmptyStateError()),
                "State error message failed!");

        Assert.assertTrue(isMatch(inputPage.zipError.getText(), expected.getEmptyZipCodeError()),
                "Zip Code error message failed!");

        Assert.assertTrue(isMatch(inputPage.commentError.getText(), expected.getEmptyProjectDescError()),
                "Project description error message failed!");
    }

    @Test
    public void positiveInputTest() {
        inputPage.randomFirstName();
        inputPage.randomLastName();
        inputPage.randomEmail();
        inputPage.enterPhone("1212212000");
        inputPage.randomAddress();
        inputPage.randomCity();
        inputPage.stateCalifornia();
        inputPage.randomZip();
        inputPage.noHosting();
        inputPage.enterDescription("This is positive test on input form!");
        inputPage.clickSend();
    }
}
