package orangecrm;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.orangehrm.HomePage;
import pages.orangehrm.LeavePage;
import pages.orangehrm.LoginPage;
import utility.ConnectDB;
import utility.ReadFromExcel;

import java.io.File;

public class TestAssignLeave extends CommonAPI {
    Logger LOG = LogManager.getLogger( TestAssignLeave.class.getName());
    String userName= ConnectDB.getTableColumnData("select * from credentials","username").get(1);
    String password= ConnectDB.getTableColumnData("select * from credentials","password").get(1);

    @Test(dataProvider = "LeaveRequestData",priority = 11)
    public void assignLeaveRequestTest(String EmployeeName,String LeaveType,String ToDate,String FromDate) throws Exception {
        LoginPage loginPage=new LoginPage(getDriver());
        HomePage homePage=new HomePage(getDriver());
        LeavePage leavePage=new LeavePage(getDriver());
        Assert.assertTrue(loginPage.checkIfLoginLogoIsDisplayed());
        LOG.info("login page success");
        loginPage.login(userName,password);
        Assert.assertTrue(homePage.checkIfDashBordIsDisplayedAsHeader());
        LOG.info("logged in success");
        leavePage.assignLeaveRequest(EmployeeName,LeaveType,FromDate,ToDate);
    }
    @DataProvider(name="LeaveRequestData")
    public Object[][] getData(){
        String filePath=System.getProperty("user.dir")+ File.separator+"data"+File.separator+"orangehrmData.xlsx";
        ReadFromExcel readFromExcel=new ReadFromExcel(filePath,"sheet4");
        int totalRows=3;
        int totalColumns=4;
        String[][] leaveRequestData =new String[totalRows][totalColumns];
        for (int i=1; i<=totalRows;i++){
            for (int j=0;j<totalColumns;j++){
                leaveRequestData[i-1][j]=readFromExcel.getDataFromCell(i,j);
            }
        }
        return leaveRequestData;
    }
}
