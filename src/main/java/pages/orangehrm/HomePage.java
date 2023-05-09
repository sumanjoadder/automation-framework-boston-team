package pages.orangehrm;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage extends CommonAPI {
    Logger LOG = LogManager.getLogger(HomePage.class.getName());
    public HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    //object elements
    @FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")
    WebElement dashBordAsHeader;
    @FindBy(xpath = "//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")
    WebElement userDropDown;
    @FindBy(xpath = "//a[text()='Change Password']")
    WebElement changePasswordOption;
    @FindBy(xpath = "(//input[@type='password'])[1]")
    WebElement currentPasswordField;
    @FindBy(xpath = "(//input[@type='password'])[2]")
    WebElement PasswordField;
    @FindBy(xpath = "(//input[@type='password'])[3]")
    WebElement confirmationPasswordField;
    @FindBy(xpath = "//h6[text()='Update Password']")
    WebElement updatePasswordTitle;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitButton;
    @FindBy(xpath ="//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']")
    WebElement toastMessage;
    @FindBy(xpath = "//span[text()='PIM']")
    WebElement PIMFromMenu;
    @FindBy(xpath = "//a[text()='Logout']")
    WebElement logoutOption;

    //reusable steps
    public boolean checkIfDashBordIsDisplayedAsHeader() {
        return checkElementIsDisplayed(dashBordAsHeader);
    }
    public void switchAndAcceptChangePasswordAlert() {
         switchToAlertAndAcceptIt();
    }
    public void selectChangePasswordFromUserDropDown() throws Exception {
       selectOptionFromDropdown(userDropDown,"Change Password" );
    }
    public String getToastMessage() {
        return getTextFromElement(toastMessage) ;
    }
    public void updatePassword(String currentPassword,String updatedPassword) {
        clickOn(userDropDown);
        clickOn(changePasswordOption);
        Assert.assertEquals(getTextFromElement(updatePasswordTitle),"Update Password");
        LOG.info("landed in the Update Password page success");
        type(currentPasswordField,currentPassword);
        type(PasswordField,updatedPassword);
        type(confirmationPasswordField,updatedPassword);
        clickOn(submitButton);
    }
    public void clickOnPIMFromMenu() {
        clickOn(PIMFromMenu);
    }
    public void logout(){
        clickOn(userDropDown);
        clickOn(logoutOption);
    }


}
