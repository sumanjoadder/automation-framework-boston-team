package freecrm;

import base.CommonAPI;
import pages.freecrmpages.CreateNewTaskPage;
import pages.freecrmpages.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateNewTaskTest extends CommonAPI {
    Logger LOG = LogManager.getLogger(CreateNewTaskTest.class.getName());

    @Test
    public void CreateNewTaskVerify() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        CreateNewTaskPage taskPage = new CreateNewTaskPage(getDriver());

        loginPage.clickOnLoginBtn();
        String title = getCurrentTitle();
        Assert.assertEquals(title, "Cogmento CRM");
        LOG.info("login title page validation success");

        loginPage.typeEmailAddress("john.doe@gmail.com");
        loginPage.typePassword("johndoepassword");
        loginPage.clickOnLoginButton();

        taskPage.setHoverOverLeftMenu(getDriver());
        taskPage.clickOnTaskIcon();
        taskPage.clickOnCreateBtn();
        taskPage.typeTitle("New Task");
        taskPage.clickOnSaveButton();
    }
}
