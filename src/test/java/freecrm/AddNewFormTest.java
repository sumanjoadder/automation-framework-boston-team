package freecrm;

import base.CommonAPI;
import pages.freecrmpages.AddNewFormPage;
import pages.freecrmpages.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddNewFormTest extends CommonAPI {
    Logger LOG = LogManager.getLogger(AddNewFormTest.class.getName());

    @Test
    public void AddNewFormVerify() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        AddNewFormPage formPage = new AddNewFormPage(getDriver());

        loginPage.clickOnLoginBtn();
        String title = getCurrentTitle();
        Assert.assertEquals(title, "Cogmento CRM");
        LOG.info("login title page validation success");

        loginPage.typeEmailAddress("john.doe@gmail.com");
        loginPage.typePassword("johndoepassword");
        loginPage.clickOnLoginButton();

        formPage.setHoverOverLeftMenu(getDriver());
        formPage.clickOnFormIcon();
        formPage.clickOnAddButton();
        formPage.typeOnNameField("New Form");
        formPage.clickOnSaveButton();
    }
}
