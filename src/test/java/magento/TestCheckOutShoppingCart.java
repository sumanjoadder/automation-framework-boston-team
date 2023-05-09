package magento;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.magentopages.*;
import utility.ConnectDB;

public class TestCheckOutShoppingCart extends CommonAPI {
    Logger LOG = LogManager.getLogger(TestCheckOutShoppingCart.class.getName());


    @Test
    public void ShoppingandAddToWishList() throws InterruptedException {
        HomePageMagento homePage = new HomePageMagento(getDriver());
        SigninPageMagento signinPageMagento = new SigninPageMagento(getDriver());
        homePage.clickOnSigninButton();
        String title = getCurrentTitle();
        Assert.assertEquals(title, "Customer Login Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites");
        LOG.info("Sign in title page validation success");

        String email = ConnectDB.getTableColumnData("select * from cred","email").get(0);
        signinPageMagento.typeEmailAddress(email);
        String password = ConnectDB.getTableColumnData("select * from cred","password").get(0);
        signinPageMagento.typePassword(password);
        signinPageMagento.clickOnSigninButton();
        LOG.info("Signin success");
        String title1 = getCurrentTitle();
        Assert.assertEquals(title1, "Home Page - Magento eCommerce - website to practice selenium | demo website for automation testing | selenium practice sites | selenium demo sites | best website to practice selenium automation | automation practice sites Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites");
        LOG.info("Sign in title page validation success");
        homePage.ClickOnSaleButton();

        String title2= getCurrentTitle();
        Assert.assertEquals(title2, "Sale Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites");
        LOG.info("Sale title page validation success");
        SaleMagentoPage saleMagentoPage = new SaleMagentoPage(getDriver());
        saleMagentoPage.clickOnShopWomensDealButton();
        String title3 = getCurrentTitle();
        Assert.assertEquals(title3, "Women Sale Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites");
        LOG.info("Women's Deal title page validation success");
        //add a product"Wayfarer Messenger Bag" to the cart
        WomensDealPageMagento womensDealPageMagento = new WomensDealPageMagento(getDriver());
        womensDealPageMagento.hoverOverJosieYogaJacket(getDriver());
        womensDealPageMagento.clickOnSizeM();
        womensDealPageMagento.ClickOnColorBlackButton();
        womensDealPageMagento.ClickAddToCartButton();
        Thread.sleep(3000);
        womensDealPageMagento.ClickOnCartButton();
        Thread.sleep(3000);
        womensDealPageMagento.ClickOnViewAndEditCart(getDriver());

        String title4= getCurrentTitle();
        Assert.assertEquals(title4, "Shopping Cart Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites");
        LOG.info("Shopping Cart title page validation success");
        ShoppingCartPageMagento shoppingCartPageMagento = new ShoppingCartPageMagento(getDriver());
        Thread.sleep(3000);
        shoppingCartPageMagento.ClickOnMoveToWishListButton();
        shoppingCartPageMagento.ClickOnLUMAButton();
        String title5 = getCurrentTitle();
        Assert.assertEquals(title5, "Home Page - Magento eCommerce - website to practice selenium | demo website for automation testing | selenium practice sites | selenium demo sites | best website to practice selenium automation | automation practice sites Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites");
        LOG.info("login title page validation success");
    }


    @Test
    public void UpdateShoppingCartAndCheckout() throws InterruptedException {
        HomePageMagento homePage = new HomePageMagento(getDriver());
        SigninPageMagento signinPageMagento = new SigninPageMagento(getDriver());
        SuccessPurchasePage successPurchasePage =new SuccessPurchasePage(getDriver());
        homePage.clickOnSigninButton();
        String title = getCurrentTitle();
        Assert.assertEquals(title, "Customer Login Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites");
        LOG.info("Sign in title page validation success");

        String email = ConnectDB.getTableColumnData("select * from cred","email").get(0);
        signinPageMagento.typeEmailAddress(email);
        String password = ConnectDB.getTableColumnData("select * from cred","password").get(0);
        signinPageMagento.typePassword(password);
        signinPageMagento.clickOnSigninButton();
        LOG.info("Signin success");
        String title1 = getCurrentTitle();
        Assert.assertEquals(title1, "Home Page - Magento eCommerce - website to practice selenium | demo website for automation testing | selenium practice sites | selenium demo sites | best website to practice selenium automation | automation practice sites Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites");
        LOG.info("Sign in title page validation success");

        homePage.hoverOverFloatingMenu(getDriver());
        homePage.clickOnFitnessEquipment();

        String title2= getCurrentTitle();
        Assert.assertEquals(title2, "Fitness Equipment - Gear Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites");
        LOG.info("Fitness equipment title page validation success");
        FitnessEquipmentMagentoPage fitnessEquipmentMagentoPage = new FitnessEquipmentMagentoPage(getDriver());
        fitnessEquipmentMagentoPage.hoverOverItem1(getDriver());
        fitnessEquipmentMagentoPage.clickOnAddToCart1();

        fitnessEquipmentMagentoPage.hoverOverItem2(getDriver());
        Thread.sleep(3000);
        fitnessEquipmentMagentoPage.clickOnAddToCart2();

        fitnessEquipmentMagentoPage.clickOnCartButton();
        Thread.sleep(3000);
        fitnessEquipmentMagentoPage.clickOnViewAndEditCart(getDriver());

        String title3= getCurrentTitle();
        Assert.assertEquals(title3, "Shopping Cart Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites");
        LOG.info("Shopping Cart title page validation success");
        ShoppingCartPageMagento shoppingCartPageMagento = new ShoppingCartPageMagento(getDriver());
        shoppingCartPageMagento.typeOnQuantityField();
        LOG.info("update quantity success");
        shoppingCartPageMagento.ClickOnRemoveButton();
        LOG.info("update quantity success");
        shoppingCartPageMagento.ClickOnUpdateShoppingCart();
        Thread.sleep(3000);

        shoppingCartPageMagento.ClickOnProceedToCheckOutButton();
        Thread.sleep(3000);
        CheckOutPageMagento checkOutPageMagento = new CheckOutPageMagento(getDriver());
        String title4= getCurrentTitle();
        Assert.assertEquals(title4, "Checkout Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites");
        LOG.info("checkout title page validation success");
        Thread.sleep(1000);

        checkOutPageMagento.clickOnShipingMethodBtn();
        checkOutPageMagento.clickOnNextButton();
        Thread.sleep(3000);
        checkOutPageMagento.clickOnPlaceOrderButton();
        String title5= getCurrentTitle();
        Assert.assertEquals(title5, "Checkout Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites");
        LOG.info("success purchase title page validation success");
        String confirmation = successPurchasePage.getconfirmationMessage();
        Assert.assertEquals(confirmation, "Thank you for your purchase!");
    }

}
