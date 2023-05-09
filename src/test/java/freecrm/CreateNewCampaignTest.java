package freecrm;

import base.CommonAPI;
import pages.freecrmpages.CreateNewCampaignPage;
import pages.freecrmpages.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateNewCampaignTest extends CommonAPI {
    Logger LOG = LogManager.getLogger(CreateNewCampaignTest.class.getName());

    @Test
    public void CreateNewCampaignVerify() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        CreateNewCampaignPage campaignPage = new CreateNewCampaignPage(getDriver());

        loginPage.clickOnLoginBtn();
        String title = getCurrentTitle();
        Assert.assertEquals(title, "Cogmento CRM");
        LOG.info("login title page validation success");

        loginPage.typeEmailAddress("john.doe@gmail.com");
        loginPage.typePassword("johndoepassword");
        loginPage.clickOnLoginButton();

        campaignPage.setHoverOverLeftMenu(getDriver());
        campaignPage.clickOnCampaigns();
        campaignPage.clickOnCreateBtn();
        campaignPage.typeOnNameField("My New Campaign");
        campaignPage.clickOnSaveButton();
    }
}
