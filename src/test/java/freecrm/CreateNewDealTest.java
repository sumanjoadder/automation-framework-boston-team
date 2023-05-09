package freecrm;

import base.CommonAPI;
import pages.freecrmpages.CreateNewContactPage;
import pages.freecrmpages.CreateNewDealPage;
import pages.freecrmpages.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateNewDealTest extends CommonAPI {
    Logger LOG = LogManager.getLogger(CreateNewDealTest.class.getName());

    @Test
    public void CreateNewDealVerify() {
        LoginPage loginPage = new LoginPage(getDriver());
        CreateNewContactPage contactPage = new CreateNewContactPage(getDriver());
        CreateNewDealPage dealPage = new CreateNewDealPage(getDriver());

        loginPage.clickOnLoginBtn();
        String title = getCurrentTitle();
        Assert.assertEquals(title, "Cogmento CRM");
        LOG.info("login title page validation success");

        loginPage.typeEmailAddress("john.doe@gmail.com");
        loginPage.typePassword("johndoepassword");
        loginPage.clickOnLoginButton();

        dealPage.clickOnDeals();
        dealPage.clickOnCreateButton();
        dealPage.typeOnTitle("New Deal");
        dealPage.clickOnSaveButton();

    }
}
