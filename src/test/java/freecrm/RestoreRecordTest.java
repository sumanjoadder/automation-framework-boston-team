package freecrm;

import base.CommonAPI;
import pages.freecrmpages.LoginPage;
import pages.freecrmpages.RestoreRecordPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RestoreRecordTest extends CommonAPI {
    Logger LOG = LogManager.getLogger(RestoreRecordTest.class.getName());

    @Test
    public void RestoreRecordVerifyTest() throws InterruptedException{
        LoginPage loginPage = new LoginPage(getDriver());
        RestoreRecordPage recordPage = new RestoreRecordPage(getDriver());

        loginPage.clickOnLoginBtn();
        String title = getCurrentTitle();
        Assert.assertEquals(title, "Cogmento CRM");
        LOG.info("login title page validation success");

        loginPage.typeEmailAddress("john.doe@gmail.com");
        loginPage.typePassword("johndoepassword");
        loginPage.clickOnLoginButton();

        loginPage.clickOnSettingsIcon();
        loginPage.clickOnTrashIcon();

        recordPage.clickOnCompany();
        recordPage.clickOnCheckBox();
        recordPage.clickOnRestoreButton();
        recordPage.clickOnOkButton();
    }
}
