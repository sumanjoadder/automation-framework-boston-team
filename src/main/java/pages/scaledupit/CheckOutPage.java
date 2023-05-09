package pages.scaledupit;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage extends CommonAPI {

    Logger LOG = LogManager.getLogger(CheckOutPage.class.getName());

    public CheckOutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //objects

    @FindBy(xpath = "//ul[@class='wc_payment_methods payment_methods methods']")
    WebElement InfoMessage;
    @FindBy(css = "#place_order")
    WebElement placeOrderButton;

    //reusable methods

    public String getInfoMessage(){

        return getTextFromElement(InfoMessage);

    }
    public void clickOnPlaceOrderButton() {
        clickOn(placeOrderButton);
        LOG.info("click on Place Order button success");

    }

}





