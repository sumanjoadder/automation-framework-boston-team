package orangecrm;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.orangehrm.HomePage;
import pages.orangehrm.LeavePage;
import pages.orangehrm.LoginPage;
import utility.ConnectDB;

public class  TestLeaveList extends CommonAPI {
    Logger LOG = LogManager.getLogger( TestLeaveList.class.getName());
    String userName= ConnectDB.getTableColumnData("select * from credentials","username").get(1);
    String password= ConnectDB.getTableColumnData("select * from credentials","password").get(1);

    @Test(priority=1)
    public void TestVisibilityApproveButton() throws InterruptedException {
        LoginPage loginPage=new LoginPage(getDriver());
        HomePage homePage=new HomePage(getDriver());
        LeavePage leavePage=new LeavePage(getDriver());
        loginPage.login(userName,password);
        leavePage.checkTheVisibilityOfApproveButton();
    }
    @Test(priority=2)
    public void TestVisibilityRejectButton() throws InterruptedException {
        LoginPage loginPage=new LoginPage(getDriver());
        HomePage homePage=new HomePage(getDriver());
        LeavePage leavePage=new LeavePage(getDriver());
        loginPage.login(userName,password);
        leavePage.checkTheVisibilityOfRejectButton();
    }
    @Test(priority=3)
    public void TestVisibilityCancelButton() throws InterruptedException {
        LoginPage loginPage=new LoginPage(getDriver());
        HomePage homePage=new HomePage(getDriver());
        LeavePage leavePage=new LeavePage(getDriver());
        loginPage.login(userName,password);
        leavePage.checkTheVisibilityOfCancelButton();
    }
    @Test(priority=4)
    public void ApproveLeaveRequestTest() throws Exception {
        LoginPage loginPage=new LoginPage(getDriver());
        HomePage homePage=new HomePage(getDriver());
        LeavePage leavePage=new LeavePage(getDriver());
        Assert.assertTrue(loginPage.checkIfLoginLogoIsDisplayed());
        LOG.info("we are in the login page ");
        loginPage.login(userName,password);
        Assert.assertTrue(homePage.checkIfDashBordIsDisplayedAsHeader());
        LOG.info("we are successfully logged in ");
        leavePage.approveLeaveTheFifthInTheLeaveList();
    }
    @Test(priority=5)
    public void RejectLeaveRequestTest() throws Exception {
        LoginPage loginPage=new LoginPage(getDriver());
        HomePage homePage=new HomePage(getDriver());
        LeavePage leavePage=new LeavePage(getDriver());
        Assert.assertTrue(loginPage.checkIfLoginLogoIsDisplayed());
        LOG.info("landed on login page success");
        loginPage.login(userName,password);
        Assert.assertTrue(homePage.checkIfDashBordIsDisplayedAsHeader());
        LOG.info("logged in success");
        leavePage.rejectLeaveTheSecondInTheLeaveList();
    }
    @Test(priority=6)
    public void RejectMultipleLeaveRequestsTest() throws Exception {
        LoginPage loginPage=new LoginPage(getDriver());
        HomePage homePage=new HomePage(getDriver());
        LeavePage leavePage=new LeavePage(getDriver());
        Assert.assertTrue(loginPage.checkIfLoginLogoIsDisplayed());
        LOG.info("landed on login page success");
        loginPage.login(userName,password);
        Assert.assertTrue(homePage.checkIfDashBordIsDisplayedAsHeader());
        LOG.info("logged in success");
        leavePage.rejectMultipleLeaveRequestsUsingRejectButtonAboveLeaveList();
    }
    @Test(priority=7)
    public void ApproveMultipleLeaveTest() throws Exception {
        LoginPage loginPage=new LoginPage(getDriver());
        HomePage homePage=new HomePage(getDriver());
        LeavePage leavePage=new LeavePage(getDriver());
        Assert.assertTrue(loginPage.checkIfLoginLogoIsDisplayed());
        LOG.info("landed on login page success");
        loginPage.login(userName,password);
        Assert.assertTrue(homePage.checkIfDashBordIsDisplayedAsHeader());
        LOG.info("logged in success");
        leavePage.approveMultipleLeaveRequestsUsingRejectButtonAboveLeaveList();
    }
    @Test(priority=8)
   public void CancelApproveMultipleLeaveRequestsTest() throws Exception {
        LoginPage loginPage=new LoginPage(getDriver());
        HomePage homePage=new HomePage(getDriver());
        LeavePage leavePage=new LeavePage(getDriver());
        Assert.assertTrue(loginPage.checkIfLoginLogoIsDisplayed());
        LOG.info("landed on login page success");
        loginPage.login(userName,password);
        Assert.assertTrue(homePage.checkIfDashBordIsDisplayedAsHeader());
        LOG.info("logged in success");
    }
    @Test(priority=9)
    public void CancelRejectMultipleLeaveRequestsTest() throws Exception {
        LoginPage loginPage=new LoginPage(getDriver());
        HomePage homePage=new HomePage(getDriver());
        LeavePage leavePage=new LeavePage(getDriver());
        Assert.assertTrue(loginPage.checkIfLoginLogoIsDisplayed());
        LOG.info("landed on login page success");
        loginPage.login(userName,password);
        Assert.assertTrue(homePage.checkIfDashBordIsDisplayedAsHeader());
        LOG.info("logged in success");
        leavePage.CancelRejectMultipleLeaveRequests();
    }
    @Test(priority=10)
    public void RejectAllLeaveRequestsTest() throws Exception {
        LoginPage loginPage=new LoginPage(getDriver());
        HomePage homePage=new HomePage(getDriver());
        LeavePage leavePage=new LeavePage(getDriver());
        Assert.assertTrue(loginPage.checkIfLoginLogoIsDisplayed());
        LOG.info("landed on login page success");
        loginPage.login(userName,password);
        Assert.assertTrue(homePage.checkIfDashBordIsDisplayedAsHeader());
        LOG.info("logged in success");
        leavePage.RejectAllLeaveRequests();
    }
    @Test (priority=12)
    public void ApproveAllLeaveRequestsTest() throws Exception {
        LoginPage loginPage=new LoginPage(getDriver());
        HomePage homePage=new HomePage(getDriver());
        LeavePage leavePage=new LeavePage(getDriver());
        Assert.assertTrue(loginPage.checkIfLoginLogoIsDisplayed());
        LOG.info("landed on login page success");
        loginPage.login(userName,password);
        Assert.assertTrue(homePage.checkIfDashBordIsDisplayedAsHeader());
        LOG.info("logged in success");
        leavePage.ApproveAllLeaveRequests();
    }

}
