package freecrm;

import base.CommonAPI;
import pages.freecrmpages.CreateNewCasePage;
import pages.freecrmpages.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateNewCaseTest extends CommonAPI {
    Logger LOG = LogManager.getLogger(CreateNewTaskTest.class.getName());

    @Test
    public void CreateNewCaseVerify() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        CreateNewCasePage casePage = new CreateNewCasePage(getDriver());

        loginPage.clickOnLoginBtn();
        String title = getCurrentTitle();
        Assert.assertEquals(title, "Cogmento CRM");
        LOG.info("login title page validation success");

        loginPage.typeEmailAddress("john.doe@gmail.com");
        loginPage.typePassword("johndoepassword");
        loginPage.clickOnLoginButton();

        casePage.setHoverOverLeftMenu(getDriver());
        casePage.clickOnTaskIcon();
        casePage.clickOnCreateBtn();
        casePage.typeTitle("New Case");
        casePage.clickOnSaveButton();





    }
}
