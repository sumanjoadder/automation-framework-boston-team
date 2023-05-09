package pages.scaledupit;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopPage extends CommonAPI {

    Logger LOG = LogManager.getLogger(ShopPage.class.getName());

    public ShopPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    //objects

    @FindBy(xpath = "//h2[text()='Biscuits']")
    WebElement Biscuit;

    //reusable methods
    public void clickOnBiscuit(){
        clickOn(Biscuit);
        LOG.info("click on biscuit  success");

    }
}
