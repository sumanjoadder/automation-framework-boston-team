package freecrm;

import base.CommonAPI;
import pages.freecrmpages.CreateNewDocumentPage;
import pages.freecrmpages.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateNewDocumentTest extends CommonAPI {
    Logger LOG = LogManager.getLogger(CreateNewDocumentTest.class.getName());

    @Test
    public void CreateNewDocumentVerify() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        CreateNewDocumentPage documentPage = new CreateNewDocumentPage(getDriver());

        loginPage.clickOnLoginBtn();
        String title = getCurrentTitle();
        Assert.assertEquals(title, "Cogmento CRM");
        LOG.info("login title page validation success");

        loginPage.typeEmailAddress("john.doe@gmail.com");
        loginPage.typePassword("johndoepassword");
        loginPage.clickOnLoginButton();

        documentPage.setHoverOverLeftMenu(getDriver());
        documentPage.clickOnDocuments();
        documentPage.clickOnCreateBtn();
        documentPage.clickOnCancelButton();
        documentPage.clickOnCreateBtn();
        documentPage.typeTitleName("All Documents of 2022");
        documentPage.clickOnSaveButton();
    }
}
