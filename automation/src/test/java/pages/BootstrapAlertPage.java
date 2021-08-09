package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BootstrapAlertPage extends BasePage {

    public String alertPageUrl = "test/bootstrap-alert-messages-demo.html";

    @FindBy(id = "autoclosable-btn-success")
    public WebElement autoclosableSuccessButton;

    @FindBy (css = ".alert-autocloseable-success")
    public WebElement autoclosableSuccessAlert;

    public By autoclosableSuccessMessage = By.cssSelector(".alert-autocloseable-success");

    public long autocloseableSuccessAlertTime = 5;

    @FindBy (id = "normal-btn-success")
    public WebElement normalSuccessButton;

    @FindBy (css = ".alert-normal-success")
    public WebElement normalSuccessAlert;

    @FindBy (css = ".alert-success > .close")
    public WebElement normalSuccessAlertClose;

    @FindBy(id = "autoclosable-btn-warning")
    public WebElement autoclosableWarningButton;

    @FindBy (css = ".alert-autocloseable-warning")
    public WebElement autoclosableWarningAlert;

    public By autoclosableWarningMessage = By.cssSelector(".alert-autocloseable-warning");

    public long autocloseableWarningMessageTime = 3;

    @FindBy (id = "normal-btn-warning")
    public WebElement normalWarningButton;

    @FindBy (css = ".alert-normal-warning")
    public WebElement normalWarningAlert;

    @FindBy (css = ".alert-warning > .close")
    public WebElement normalWarningAlertClose;

    @FindBy(id = "autoclosable-btn-danger")
    public WebElement autoclosableDangerButton;

    @FindBy (css = ".alert-autocloseable-danger")
    public WebElement autoclosableDangerAlert;

    public By autoclosableDangerMessage = By.cssSelector(".alert-autocloseable-danger");

    public long autocloseableDangerMessageTime = 5;

    @FindBy (id = "normal-btn-danger")
    public WebElement normalDangerButton;

    @FindBy (css = ".alert-normal-danger")
    public WebElement normalDangerAlert;

    @FindBy (css = ".alert-danger > .close")
    public WebElement normalDangerAlertClose;

    @FindBy(id = "autoclosable-btn-info")
    public WebElement autoclosableInfoButton;

    @FindBy (css = ".alert-autocloseable-info")
    public WebElement autoclosableInfoAlert;

    public By autoclosableInfoMessage = By.cssSelector(".alert-autocloseable-info");

    public long autocloseableInfoMessageTime = 6;

    @FindBy (id = "normal-btn-info")
    public WebElement normalInfoButton;

    @FindBy (css = ".alert-normal-info")
    public WebElement normalInfoAlert;

    @FindBy (css = ".alert-info > .close")
    public WebElement normalInfoAlertClose;

    public BootstrapAlertPage(WebDriver driver) {
        super(driver);
    }

    public void clickAutocloseableSuccess(){
        this.autoclosableSuccessButton.click();
    }

    public void clickNormalSuccess(){
        this.normalSuccessButton.click();
    }

    public void closeNormalSuccess(){
        this.normalSuccessAlertClose.click();
    }

    public void clickAutocloseableWarning(){
        this.autoclosableWarningButton.click();
    }

    public void clickNormalWarning(){
        this.normalWarningButton.click();
    }

    public void closeNormalWarning(){
        this.normalWarningAlertClose.click();
    }

    public void clickAutocloseableDanger(){
        this.autoclosableDangerButton.click();
    }

    public void clickNormalDanger(){
        this.normalDangerButton.click();
    }

    public void closeNormalDanger(){
        this.normalDangerAlertClose.click();
    }

    public void clickAutocloseableInfo(){
        this.autoclosableInfoButton.click();
    }

    public void clickNormalInfo(){
        this.normalInfoButton.click();
    }

    public void closeNormalInfo(){
        this.normalInfoAlertClose.click();
    }
}
