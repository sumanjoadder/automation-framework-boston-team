package freecrm;

import base.CommonAPI;
import pages.freecrmpages.DropDownPage;
import pages.freecrmpages.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropDownMenuTest extends CommonAPI {
    Logger LOG = LogManager.getLogger(DropDownMenuTest.class.getName());

    @Test
    public void DropDownMenuVerifyTest() throws InterruptedException {
        DropDownPage dropDownPage = new DropDownPage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());

        String title = getCurrentTitle();
        Assert.assertEquals(title, "Cogmento CRM and Business Cloud Solutions");
        LOG.info("login title page validation success");

        dropDownPage.hoverOverCrm(getDriver());
        dropDownPage.clickOnDropDown();
    }
}
