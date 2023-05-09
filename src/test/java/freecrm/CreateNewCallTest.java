package freecrm;

import base.CommonAPI;
import pages.freecrmpages.CreateNewCallPage;
import pages.freecrmpages.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateNewCallTest extends CommonAPI {
    Logger LOG = LogManager.getLogger(CreateNewCallTest.class.getName());

    @Test
    public void CreateNewCallVerify() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        CreateNewCallPage callPage = new CreateNewCallPage(getDriver());

        loginPage.clickOnLoginBtn();
        String title = getCurrentTitle();
        Assert.assertEquals(title, "Cogmento CRM");
        LOG.info("login title page validation success");

        loginPage.typeEmailAddress("john.doe@gmail.com");
        loginPage.typePassword("johndoepassword");
        loginPage.clickOnLoginButton();

        callPage.setHoverOverLeftMenu(getDriver());
        callPage.clickOnCallIcon();
        callPage.clickOnCreateBtn();
        callPage.ClickOnCallTimeBox();
        callPage.enterDateAndTime("31/12/8764 23:00");
        callPage.clickOnSaveButton();
    }
}
