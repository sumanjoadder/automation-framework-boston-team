package pages.freecrmpages;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage extends CommonAPI {

    Logger LOG = LogManager.getLogger(CreateNewContactPage.class.getName());

    public CreateNewContactPage(WebDriver driver) { PageFactory.initElements(driver, this);}

    @FindBy(xpath = "//i[@class='users icon']")
    WebElement hoverOverLeftMenu;

    @FindBy(xpath = "(//span[@class='item-text'])[3]")
    WebElement addNewContactIcon;

    @FindBy(xpath = "(//button[@class='ui linkedin button'])[3]")
    WebElement createBtn;

    @FindBy(xpath = "//input[@name='first_name']")
    WebElement firstNameField;

    @FindBy(xpath = " //input[@name='last_name']")
    WebElement lastNameField;

    @FindBy(xpath = "//button[@class='ui linkedin button']")
    WebElement saveButton;


    public void setHoverOverLeftMenu(WebDriver driver){
        hoverOver(driver, hoverOverLeftMenu);
        LOG.info("hover over menu success");
    }

    public void clickOnAddContactIcon(){
        clickOn(addNewContactIcon);
        LOG.info("click on contacts success");
    }

    public void clickOnCreateBtn(){
        clickOn(createBtn);
        LOG.info("click on create button success");
    }

    public void typeFirstName(String enterFirstName){
        type(firstNameField, enterFirstName);
        LOG.info("type first name success");
    }

    public void typeLastName(String enterLastName){
        type(firstNameField, enterLastName);
        LOG.info("type last name success");
    }

    public void clickOnSaveButton(){
        clickOn(saveButton);
        LOG.info("click save button success");
    }

}
