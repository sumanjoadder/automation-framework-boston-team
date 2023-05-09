package freecrm;

import base.CommonAPI;
import pages.freecrmpages.CreateNewContactPage;
import pages.freecrmpages.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateNewContactTest extends CommonAPI {
    Logger LOG = LogManager.getLogger(CreateNewContactTest.class.getName());

    @Test
    public void CreateNewContactVerify() {
        LoginPage loginPage = new LoginPage(getDriver());
        CreateNewContactPage contactPage = new CreateNewContactPage(getDriver());

        //String email = ConnectDB.getTableColumnData("select * from cred","password").get(0);

        loginPage.clickOnLoginBtn();
        String title = getCurrentTitle();
        Assert.assertEquals(title, "Cogmento CRM");
        LOG.info("login title page validation success");

        loginPage.typeEmailAddress("john.doe@gmail.com");
        loginPage.typePassword("johndoepassword");
        loginPage.clickOnLoginButton();

        contactPage.setHoverOverLeftMenu(getDriver());
        contactPage.clickOnAddContactIcon();
        contactPage.clickOnCreateBtn();
        contactPage.typeFirstName("John");
        contactPage.typeLastName("Smith");
        contactPage.clickOnSaveButton();


    }
}
