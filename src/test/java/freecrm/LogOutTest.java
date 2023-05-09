package freecrm;

import base.CommonAPI;
import pages.freecrmpages.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;




public class LogOutTest extends CommonAPI {
    Logger LOG = LogManager.getLogger(LogOutTest.class.getName());

    @Test
    public void LogOutButtonVerifyTest() throws InterruptedException  {
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.clickOnLoginBtn();
        String title = getCurrentTitle();
        Assert.assertEquals(title, "Cogmento CRM");
        LOG.info("login title page validation success");

        loginPage.typeEmailAddress("john.doe@gmail.com");
        loginPage.typePassword("johndoepassword");
        loginPage.clickOnLoginButton();

        loginPage.clickOnSettingsIcon();
        loginPage.clickOnLogOutButton();
    }
}
