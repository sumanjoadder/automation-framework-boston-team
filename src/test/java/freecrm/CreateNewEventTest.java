package freecrm;

import base.CommonAPI;
import pages.freecrmpages.CreateNewEventPage;
import pages.freecrmpages.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateNewEventTest extends CommonAPI {
    Logger LOG = LogManager.getLogger(CreateNewEventTest.class.getName());

    @Test
    public void CreateNewEventVerify() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        CreateNewEventPage eventPage = new CreateNewEventPage(getDriver());

        loginPage.clickOnLoginBtn();
        String title = getCurrentTitle();
        Assert.assertEquals(title, "Cogmento CRM");
        LOG.info("login title page validation success");

        loginPage.typeEmailAddress("john.doe@gmail.com");
        loginPage.typePassword("johndoepassword");
        loginPage.clickOnLoginButton();

        eventPage.setHoverOverLeftMenu(getDriver());
        eventPage.clickOnCalenderIcon();
        eventPage.clickOnCreateBtn();
        eventPage.clickOnCancelButton();
        eventPage.clickOnCreateBtn();
        eventPage.typeOnTitleField("New Year Event");
        eventPage.clickOnSaveButton();
    }

}
