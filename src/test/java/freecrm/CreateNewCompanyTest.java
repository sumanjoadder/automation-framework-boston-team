package freecrm;

import base.CommonAPI;
import pages.freecrmpages.CreateNewCompanyPage;
import pages.freecrmpages.CreateNewContactPage;
import pages.freecrmpages.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateNewCompanyTest extends CommonAPI {
    Logger LOG = LogManager.getLogger(CreateNewCompanyTest.class.getName());

    @Test
    public void CreateNewCompanyVerify() throws InterruptedException{
        LoginPage loginPage = new LoginPage(getDriver());
        CreateNewContactPage contactPage = new CreateNewContactPage(getDriver());
        CreateNewCompanyPage companyPage = new CreateNewCompanyPage(getDriver());
        //String email = ConnectDB.getTableColumnData("select * from cred","password").get(0);

        loginPage.clickOnLoginBtn();
        String title = getCurrentTitle();
        Assert.assertEquals(title, "Cogmento CRM");
        LOG.info("login title page validation success");

        loginPage.typeEmailAddress("john.doe@gmail.com");
        loginPage.typePassword("johndoepassword");
        loginPage.clickOnLoginButton();

        contactPage.setHoverOverLeftMenu(getDriver());

        companyPage.clickOnAddCompanyButton();
        companyPage.clickOnCompanyCreateBtn();
        companyPage.typeName("Will Smith");
        companyPage.clickOnSaveButton();
        companyPage.clickOnAddCompanyButton();
    }
}
