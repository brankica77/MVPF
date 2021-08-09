package tests;

import data.Expected;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.BootstrapDualListBoxPage;
import utils.WebDrivers;

import java.io.IOException;

public class TestListBoxPage extends BaseTest {
    BootstrapDualListBoxPage listBoxPage;
    private Expected expected;

    public TestListBoxPage() throws IOException {
    }

    @BeforeTest
    public void init() throws IOException, InstantiationException, IllegalAccessException {
        expected = Expected.get(expectedFilePath);
        driver = WebDrivers.chromeDriver();
        listBoxPage = PageFactory.initElements(driver, BootstrapDualListBoxPage.class);

        driver.navigate().to(homeURL + listBoxPage.listBoxUrl);
        driver.manage().window().maximize();
    }

    @AfterTest
    public void therdown (){
        if (driver != null){
            WebDrivers.silentyCloseDriver(driver);
        }
    }

   @Test
    public void searchItem(){
        driver.get(driver.getCurrentUrl());
        listBoxPage.searchLeft(expected.boxItem());
        Assert.assertTrue(listBoxPage.isItemListedOnLeft(expected.boxItem()),
                "Item is not listed in the left list!");

        listBoxPage.searchRight(expected.boxItem());
        Assert.assertTrue(listBoxPage.isItemListedOnRight(expected.boxItem()),
        "Item is not listed in the right list!");
    }

    @Test
    public void moveItemToRightList() {
        driver.get(driver.getCurrentUrl());
        listBoxPage.searchLeft(expected.leftBoxItem());
        listBoxPage.selectItemLeftByText(expected.leftBoxItem());
        listBoxPage.moveToRight();

        Assert.assertTrue(listBoxPage.isItemListedOnRight(expected.leftBoxItem()),
                "Item is not found in the right list after moving!");
    }

    @Test
    public void moveItemToLeftList() {
        driver.get(driver.getCurrentUrl());
        listBoxPage.searchRight(expected.rightBoxItem());
        listBoxPage.selectItemRightByText(expected.rightBoxItem());
        listBoxPage.moveToLeft();

        Assert.assertTrue(listBoxPage.isItemListedOnLeft(expected.rightBoxItem()),
                "Item is not found in the left list after moving!");
    }
}
