package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InputFormWithValidationsPage extends BasePage {

    public String inputFormUrl = "test/input-form-demo.html";

    Faker faker = new Faker();

    @FindBy (name = "first_name")
    public WebElement firstNameInput;

    @FindBy (css = ".form-group:nth-child(2) .help-block:nth-child(4)")
    public WebElement firstNameError;

    @FindBy (name = "last_name")
    public WebElement lastNameInput;

    @FindBy (css = ".form-group:nth-child(3) .help-block:nth-child(4)")
    public WebElement lastNameError;

    @FindBy (name = "email")
    public WebElement emailInput;

    @FindBy (css = ".form-group:nth-child(4) .help-block:nth-child(3)")
    public WebElement emailError;

    @FindBy (name = "phone")
    public WebElement phoneInput;

    @FindBy (css = ".form-group:nth-child(5) .help-block:nth-child(3)")
    public WebElement phoneError;

    @FindBy (name = "address")
    public WebElement addressInput;

    @FindBy (css = ".form-group:nth-child(6) .help-block:nth-child(4)")
    public WebElement addressError;

    @FindBy (name = "city")
    public WebElement cityInput;

    @FindBy (css = ".form-group:nth-child(7) .help-block:nth-child(4)")
    public WebElement cityError;

    @FindBy (name = "state")
    public WebElement stateDropdown;

    @FindBy (css = ".selectContainer > .help-block")
    public WebElement stateError;

    @FindBy (name = "zip")
    public WebElement zipInput;

    @FindBy (css = ".form-group:nth-child(9) .help-block:nth-child(3)")
    public WebElement zipError;

    @FindBy (name = "website")
    public WebElement websiteInput;

    @FindBy (name = "comment")
    public WebElement commentInput;

    @FindBy (css = ".form-group:nth-child(12) .help-block:nth-child(4)")
    public WebElement commentError;

    @FindBy (css = ".radio:nth-child(2) input")
    public WebElement hostingNo;

    @FindBy (css = ".btn")
    public WebElement sendButton;

    public InputFormWithValidationsPage(WebDriver driver) {
        super(driver);
    }

    public void clickSend(){
        this.sendButton.click();
    }

    public void randomFirstName(){
        this.firstNameInput.click();
        this.firstNameInput.sendKeys(faker.name().firstName());
    }

    public void randomLastName(){
        this.lastNameInput.click();
        this.lastNameInput.sendKeys(faker.name().lastName());
    }

    public void randomEmail(){
        this.emailInput.click();
        this.emailInput.sendKeys(faker.internet().emailAddress());
    }

    public void stateCalifornia(){
        this.stateDropdown.click();
        this.stateDropdown.findElement(By.xpath("//option[. = 'California']")).click();
    }

    public void enterPhone(String phone){
        this.phoneInput.click();
        this.phoneInput.sendKeys(phone);
    }

    public void randomAddress(){
        this.addressInput.click();
        this.addressInput.sendKeys(faker.address().streetAddress());
    }

    public void randomCity(){
        this.cityInput.click();
        this.cityInput.sendKeys(faker.address().city());
    }

    public void randomZip(){
        this.zipInput.click();
        this.zipInput.sendKeys(faker.address().zipCode());
    }

    public void enterDescription (String description){
        this.commentInput.click();
        this.commentInput.sendKeys(description);
    }

    public void noHosting (){
        this.hostingNo.click();
    }
}
