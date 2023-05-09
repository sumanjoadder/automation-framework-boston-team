package freecrm;

import base.CommonAPI;
import pages.freecrmpages.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends CommonAPI{
    Logger LOG = LogManager.getLogger(SearchTest.class.getName());

    @Test
    public void SearchTextBoxTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.clickOnLoginBtn();
        String title = getCurrentTitle();
        Assert.assertEquals(title, "Cogmento CRM");
        LOG.info("login title page validation success");

        loginPage.typeEmailAddress("john.doe@gmail.com");
        loginPage.typePassword("johndoepassword");
        loginPage.clickOnLoginButton();

        loginPage.clickOnSearchTextBox();
        loginPage.typeItemToSearch("james");
    }
}
