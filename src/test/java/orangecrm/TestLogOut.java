package orangecrm;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.orangehrm.HomePage;
import pages.orangehrm.LoginPage;
import utility.ConnectDB;

public class TestLogOut extends CommonAPI {

    Logger LOG = LogManager.getLogger( TestLogOut.class.getName());
    @Test
    public void logoutTest() throws Exception {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        Assert.assertTrue(loginPage.checkIfLoginLogoIsDisplayed());
        LOG.info("landed on login page success");
        String userName = ConnectDB.getTableColumnData("select * from credentials", "username").get(1);
        String password = ConnectDB.getTableColumnData("select * from credentials", "password").get(1);
        loginPage.login(userName, password);
        Assert.assertTrue(homePage.checkIfDashBordIsDisplayedAsHeader());
        LOG.info("landed in the homepage success");
        homePage.logout();
        Assert.assertTrue(loginPage.checkIfLoginLogoIsDisplayed());
        LOG.info("logged out success");
    }
}
