package freecrm;

import base.CommonAPI;
import pages.freecrmpages.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BlankUsernameAndPasswordTest extends CommonAPI {
    Logger LOG = LogManager.getLogger(LoginTest.class.getName());


    @Test
    public void blankUsernameAndPassword() {
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.clickOnLoginBtn();
        String title = getCurrentTitle();
        Assert.assertEquals(title, "Cogmento CRM");
        LOG.info("login title page validation success");

        loginPage.typeEmailAddress("");
        loginPage.typePassword("");
        loginPage.clickOnLoginButton();

        String error = loginPage.getErrorMessage();
        Assert.assertEquals(error, "Something went wrong...");
        LOG.info("error message validation success");
    }
}
