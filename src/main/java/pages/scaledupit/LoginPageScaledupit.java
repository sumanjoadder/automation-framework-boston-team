package pages.scaledupit;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageScaledupit extends CommonAPI {

    Logger LOG = LogManager.getLogger(LoginPageScaledupit.class.getName());

    public LoginPageScaledupit(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    //objects
    @FindBy(css = "#username")
    WebElement usernameField;

    @FindBy(css = "#password")
    WebElement passwordField;

    @FindBy(css = "#reg_email")
    WebElement emailField;

    @FindBy(css = "#reg_password")
    WebElement passwordregField;


    @FindBy(xpath = "(//input[@name='_wp_http_referer']//preceding::button)[2]")
    WebElement LoginButton;

    @FindBy(xpath = "//div[@class='woocommerce-notices-wrapper']")
    WebElement ErrorMessage;

    @FindBy(xpath = "//button[@name='register']")
    WebElement RegisterButton;
    @FindBy(xpath = "//span[text()='Home']")
    WebElement homeButton;
    @FindBy(xpath = "//li[@class='woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--customer-logout']")
    WebElement logOutButton;


    //reusable methods
    public void typeusername(String username){
        type(usernameField, username);
        LOG.info("type username success");
    }

    public void typepassword(String password){
        type(passwordField, password);
        LOG.info("type password success");
    }
    public void clickOnLoginButton(){
        clickOn(LoginButton);
        LOG.info("click Login button success");
    }

    public void typeEmailAddress(String EmailAddress){
        type(emailField, EmailAddress);
        LOG.info("type EmailAddress success");
    }

    public void typepasswordRegister(String passwordRegister){
        type(passwordregField, passwordRegister);
        LOG.info("type password success");
    }
    public void clickOnRegisterButton(){
        clickOn(RegisterButton);
        LOG.info("click Login button success");
    }

    public String getErrorMessage(){
        return getTextFromElement(ErrorMessage);
        //LOG.info("error message success");

    }

    public void clickOnHomeButton(){
        clickOn(homeButton);
        LOG.info("click Home button success");
    }

    public void clickOnLogOut(){
        clickOn(logOutButton);
        LOG.info("click log out button success");
    }


}



