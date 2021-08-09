package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BootstrapDualListBoxPage extends BasePage {

    public String listBoxUrl = "test/bootstrap-dual-list-box-demo.html";

    @FindBy(name = "SearchDualList")
    public WebElement searchLeft;

    @FindBy(css = ".form-control:nth-child(1)")
    public WebElement searchRight;

    @FindBy(css = ".move-left")
    public WebElement moveLeftArrow;

    @FindBy(css = ".move-right > .glyphicon")
    public WebElement moveRightArrow;

    public By leftListUl = By.cssSelector(".text-right > ul:nth-child(2)");

    public By rightListUl = By.cssSelector("div.dual-list:nth-child(6) > div:nth-child(1) > ul:nth-child(2)");

    public BootstrapDualListBoxPage(WebDriver driver) {
        super(driver);
    }

    public void selectItemLeftByText(String itemText){
        List<WebElement> itemsLeft = driver.findElements(leftListUl);
        for(WebElement item: itemsLeft){
            if(item.getText().equals(itemText)){
                item.click();
            }
        }
    }

    public void selectItemRightByText(String itemText){
        List<WebElement> itemsRight = driver.findElements(this.rightListUl);
        for(WebElement item: itemsRight){
            if(item.getText().equals(itemText)){
                item.click();
            }
        }
    }

    public boolean isItemListedOnLeft(String itemText){
        boolean isListed = false;
        List<WebElement> itemsLeft = driver.findElements(leftListUl);

        for(WebElement item: itemsLeft){
            if(item.getText().contains(itemText)){
                isListed = true;
            }
        }
        return isListed;
    }

    public boolean isItemListedOnRight(String itemText){
        boolean isListed = false;
        List<WebElement> itemsRight = driver.findElements(this.rightListUl);

        for(WebElement item: itemsRight){
            if(item.getText().contains(itemText)){
                isListed = true;
            }
        }
        return isListed;
    }

    public void searchLeft(String item){
        this.searchLeft.clear();
        this.searchLeft.sendKeys(item);
    }

    public void searchRight(String item){
        this.searchRight.clear();
        this.searchRight.sendKeys(item);
    }

    public void moveToLeft(){
        this.moveLeftArrow.click();
    }

    public void moveToRight(){
        this.moveRightArrow.click();
    }
}
