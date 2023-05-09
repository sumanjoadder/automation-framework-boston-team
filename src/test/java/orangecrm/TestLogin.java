package orangecrm;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.orangehrm.HomePage;
import pages.orangehrm.LoginPage;
import utility.ConnectDB;
import utility.ReadFromExcel;
import java.io.File;

public class TestLogin extends CommonAPI {
    Logger LOG = LogManager.getLogger( TestLogin.class.getName());
    String userName= ConnectDB.getTableColumnData("select * from credentials","username").get(1);
    String password= ConnectDB.getTableColumnData("select * from credentials","password").get(1);
     @Test
    public void loginWithValidCredentials() {
        LoginPage loginPage=new LoginPage(getDriver());
        HomePage homePage=new HomePage(getDriver());
        Assert.assertTrue(loginPage.checkIfLoginLogoIsDisplayed());
        LOG.info("landed on login page success");
        loginPage.login(userName,password);
        Assert.assertTrue(homePage.checkIfDashBordIsDisplayedAsHeader());
        LOG.info("logged in success");
    }
    @Test(dataProvider = "InvalidCredentialsData")

    public void loginWithInvalidCredentials(String userName,String password) {
        LoginPage loginPage=new LoginPage(getDriver());
        HomePage homePage=new HomePage(getDriver());
        Assert.assertTrue(loginPage.checkIfLoginLogoIsDisplayed());
        LOG.info("landed on login page success");
        loginPage.login(userName,password);
        String actualTextErrorLogin=loginPage.getLoginError();
        Assert.assertEquals(actualTextErrorLogin,"Invalid credentials");
        LOG.info("the login with invalid credentials successfully denied ");
    }
    @DataProvider(name="InvalidCredentialsData")
    public Object[][] getData(){
        String filePath=System.getProperty("user.dir")+ File.separator+"data"+File.separator+"orangehrmData.xlsx";
        ReadFromExcel readFromExcel=new ReadFromExcel(filePath,"sheet2");
        int totalRows=3;
        int totalColumns=2;
        String[][] invalidCredentialsData =new String[totalRows][totalColumns];
        for (int i=1; i<=totalRows;i++){
            for (int j=0;j<totalColumns;j++){
                invalidCredentialsData[i-1][j]=readFromExcel.getDataFromCell(i,j);
            }
        }
        return invalidCredentialsData;
    }

    @Test
    public void forgotAndResetPasswordTest() {
        LoginPage loginPage=new LoginPage(getDriver());
        Assert.assertTrue(loginPage.checkIfLoginLogoIsDisplayed());
        LOG.info("landed on login page success");
        loginPage.resetPassWord(getDriver(),userName);
        String filePath=System.getProperty("user.dir")+ File.separator+"data"+File.separator+"orangehrmData.xlsx";
        ReadFromExcel readFromExcel=new ReadFromExcel(filePath,"sheet1");
        String title=readFromExcel.getCellValueForGivenHeaderAndKey("key","RestPasswordConfirmationText");
        String actualRestPasswordConfirmationText=loginPage.getResetPasswordText();
        Assert.assertEquals(actualRestPasswordConfirmationText,title);
        LOG.info("Reset Password link sent success ");
    }
    @Test
    public void cancelResettingAPasswordTest() {
        LoginPage loginPage=new LoginPage(getDriver());
        Assert.assertTrue(loginPage.checkIfLoginLogoIsDisplayed());
        LOG.info("landed on login page success");
        loginPage.cancelResetPassWord(getDriver(),userName);
        Assert.assertTrue(loginPage.checkIfLoginLogoIsDisplayed());
        LOG.info("back to the login page success");
    }
    @Test
    public void changeAPasswordTest() throws Exception {
        LoginPage loginPage=new LoginPage(getDriver());
        HomePage homePage=new HomePage(getDriver());
        Assert.assertTrue(loginPage.checkIfLoginLogoIsDisplayed());
        LOG.info("landed on login page success");
        loginPage.login(userName,password);
        Assert.assertTrue(homePage.checkIfDashBordIsDisplayedAsHeader());
        LOG.info("logged in success");
        String filePath=System.getProperty("user.dir")+ File.separator+"data"+File.separator+"orangehrmData.xlsx";
        ReadFromExcel readFromExcel=new ReadFromExcel(filePath,"sheet1");
        String newPassword=readFromExcel.getCellValueForGivenHeaderAndKey("key","password");
        homePage.updatePassword(password,newPassword);
        String confirmationToastMessage=readFromExcel.getCellValueForGivenHeaderAndKey("key","Update password confirmation");
        Assert.assertEquals(homePage.getToastMessage(),confirmationToastMessage);
        LOG.info("the password successfully changed");
    }
}
