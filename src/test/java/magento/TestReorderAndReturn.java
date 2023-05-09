package magento;

import base.CommonAPI;
import pages.magentopages.HomePageMagento;
import pages.magentopages.OrderAndRuternPage;
import pages.magentopages.Order000017128Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.ReadFromExcel;

public class TestReorderAndReturn extends CommonAPI {

    Logger LOG = LogManager.getLogger(TestReorderAndReturn.class.getName());

    ReadFromExcel read = new ReadFromExcel("../data/titles.xlsx", "Magento");

    @Test
    public void orderAndReturn() throws InterruptedException {
        HomePageMagento homePage = new HomePageMagento(getDriver());
        OrderAndRuternPage orderAndRuternPage = new OrderAndRuternPage(getDriver());
        Order000017128Page order000017128Page = new Order000017128Page(getDriver());
        homePage.clickOnOrderAndRuters();

        String title= getCurrentTitle();
        Assert.assertEquals(title, "Orders and Returns Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites");
        LOG.info("Orders and Returns  title page validation success");
        orderAndRuternPage.typeOrderID("000017128");
        orderAndRuternPage.typeBillingLastname("John");
        orderAndRuternPage.typeEmail("john.doe@gmail.com");
        orderAndRuternPage.clickOnContinueButton();

        String title1= getCurrentTitle();
        Assert.assertEquals(title1, "Order # 000017128 Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites");
        LOG.info("Order # 000017128  title page validation success");
        order000017128Page.clickOnPrintOrder();

    }
}
