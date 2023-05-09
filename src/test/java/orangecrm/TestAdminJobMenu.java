package orangecrm;

import base.CommonAPI;
import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import pages.orangehrm.AdminPage;
import pages.orangehrm.LoginPage;
import utility.ConnectDB;

public class TestAdminJobMenu extends CommonAPI {
    Logger LOG = LogManager.getLogger(TestAdminJobMenu.class.getName());
    String userName= ConnectDB.getTableColumnData("select * from credentials","username").get(1);
    String password= ConnectDB.getTableColumnData("select * from credentials","password").get(1);

    @Test
    public void  addJobTitleTest() throws Exception {
        LoginPage loginPage=new LoginPage(getDriver());
        AdminPage adminPage=new AdminPage(getDriver());
        Faker faker=new Faker();
        loginPage.login(userName,password);
        adminPage. addJobTitle(faker.job().title());

    }
    @Test
    public void  addPayGradeTest() throws Exception {
        LoginPage loginPage=new LoginPage(getDriver());
        Faker faker=new Faker();
        AdminPage adminPage=new AdminPage(getDriver());
        loginPage.login(userName,password);
        adminPage.addPayGrade("Grade"+faker.number().numberBetween(15,40));
    }
}
