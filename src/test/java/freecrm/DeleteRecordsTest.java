package freecrm;

import base.CommonAPI;
import pages.freecrmpages.DeleteRecordsPage;
import pages.freecrmpages.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteRecordsTest extends CommonAPI {
    Logger LOG = LogManager.getLogger(DeleteRecordsTest.class.getName());

    @Test
    public void DeleteRecordVerify() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        DeleteRecordsPage deleteRecordPage = new DeleteRecordsPage(getDriver());

        loginPage.clickOnLoginBtn();
        String title = getCurrentTitle();
        Assert.assertEquals(title, "Cogmento CRM");
        LOG.info("login title page validation success");

        loginPage.typeEmailAddress("john.doe@gmail.com");
        loginPage.typePassword("johndoepassword");
        loginPage.clickOnLoginButton();

        deleteRecordPage.clickOnTrashIcon();
        deleteRecordPage.clickOnContactIcon();
        deleteRecordPage.clickOnSelectIcon();
        deleteRecordPage.clickOnRemoveIcon();
        deleteRecordPage.clickOnOkButton();
    }
}
