package orangecrm;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import pages.orangehrm.HomePage;
import pages.orangehrm.LoginPage;
import pages.orangehrm.TimePage;
import utility.ConnectDB;
import utility.ReadFromExcel;

import java.io.File;

public class TestTimeTimeSheets extends CommonAPI {
    Logger LOG = LogManager.getLogger(TestTimeTimeSheets.class.getName());
    @Test
    public void viewTimeSheetsOfAnEmployeeTest() throws Exception {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        TimePage timePage = new TimePage(getDriver());
        String userName = ConnectDB.getTableColumnData("select * from credentials", "username").get(1);
        String password = ConnectDB.getTableColumnData("select * from credentials", "password").get(1);
        loginPage.login(userName, password);
        String filePath=System.getProperty("user.dir")+ File.separator+"data"+File.separator+"orangehrmData.xlsx";
        ReadFromExcel readFromExcel=new ReadFromExcel(filePath,"sheet1");
        String  employeeName=readFromExcel.getCellValueForGivenHeaderAndKey("key","Employee Name");
        timePage.viewTimeSheetsOfAnEmployee(employeeName);
    }
}
