package com.nopcommerce.testsuite;

import com.nopcommerce.pages.*;
import com.nopcommerce.testbase.BaseTest;
//import org.checkerframework.checker.units.qual.C;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ComputerPageTest extends BaseTest {
    HomePage homePage = new HomePage();
    DesktopPage desktopPage = new DesktopPage();
    BuildYourOwnComputerPage buildYourOwnComputerPage = new BuildYourOwnComputerPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    SignInPage signInPage = new SignInPage();
    CheckoutPage checkoutPage = new CheckoutPage();


    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {
        homePage.clickOnComputer();
        desktopPage.clickOnDesktop();
        desktopPage.arrangeProducts("Name: Z to A");
        desktopPage.verifyProductsInDescendingOrder();

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        homePage.clickOnComputer();
        desktopPage.clickOnDesktop();
        desktopPage.arrangeProducts("Name: A to Z");
        Thread.sleep(3000);
        desktopPage.addProductToCart();
        desktopPage.verifyTextBuildYourOwnComputer("Build your own computer");
        buildYourOwnComputerPage.selectProcessorName("2.2 GHz Intel Pentium Dual-Core E2200");
        buildYourOwnComputerPage.selectRam("8GB [+$60.00]");
        buildYourOwnComputerPage.selectHDDOption();
        buildYourOwnComputerPage.selectOSOption();
        buildYourOwnComputerPage.selectSoftwareOptions();
        buildYourOwnComputerPage.verifyThePrice("$1,300.00");
        buildYourOwnComputerPage.clickOnAddToCartBtn();
        buildYourOwnComputerPage.verifyTheTextProductHasbeenAdded("The product has been added to your shopping cart");
        buildYourOwnComputerPage.closeTheBar();
        buildYourOwnComputerPage.mouseHoverToShoppingCart();
        buildYourOwnComputerPage.clickOnGoToCart();
        shoppingCartPage.verifyShoppingCartText("Shopping cart");
        shoppingCartPage.clearQuantity();
        shoppingCartPage.sendQuantity("2");
        shoppingCartPage.clickOnUpdateShoppingCart();
        //2.17 Verify the Total"$2,950.00"
        shoppingCartPage.verifyTheTotal("$2,950.00");
        shoppingCartPage.clickOnTermsOfService();
        shoppingCartPage.clickOnCheckout();
        //Assert.assertEquals(shoppingCartPage.getTotalPriceShoppingCart(), "$2,950.00", "Price not $2,950.00");
        Assert.assertEquals(signInPage.getWelcomeText(), "Welcome, Please Sign In!", "Welcome text not displayed");
        signInPage.verifyWelcomeText("Welcome, Please Sign In!");
        signInPage.clickCheckoutAsGuest();


        //2.22 Fill the all mandatory field

        checkoutPage.sendFirstName("Xyz");
        checkoutPage.sendLastName("Patel");
        checkoutPage.sendEmail("abcxyz");
        checkoutPage.selectCountryName("United Kingdom");
        checkoutPage.sendCityName("London");
        checkoutPage.sendAddressName("129 Pinner Road");
        checkoutPage.sendPostCode("NW11AD");
        checkoutPage.sendPhoneNumber("01234567890");
        //2.23 Click on “CONTINUE”
        checkoutPage.clickContinue();
        //2.24 Click on Radio Button “Next Day Air($0.00)”
        checkoutPage.chooseShipping();
        //2.25 Click on “CONTINUE”
        checkoutPage.clickContinueFromShipping();
        //2.26 Select Radio Button “Credit Card”
        checkoutPage.selectPaymentTypeRadioButton();
        //click continue
        checkoutPage.clickContinueAfterPaymentMethod();
        //2.27 Select “Master card” From Select credit card dropdown
        checkoutPage.selectCardType("Master card");
        //2.28 Fill all the details
        checkoutPage.sendCardholderName("MR NO ONE");
        checkoutPage.sendCardNumber("5100 0000 0000 0511");
        checkoutPage.selectExpiryMonth("01");
        checkoutPage.selectExpiryYear("2026");
        checkoutPage.sendCVVCode("123");
        //2.29 Click on “CONTINUE”
        checkoutPage.clickContinueAfterBilling();
        //2.30 Verify “Payment Method” is “Credit Card”
        Assert.assertEquals(checkoutPage.getTextPaymentMethod(), "Credit Card", "Payment method not credit card");
        //2.32 Verify “Shipping Method” is “Next Day Air”
        Assert.assertEquals(checkoutPage.getTextShippingMethod(), "Next Day Air", "Shipping method not Next Day Air");
        //2.33 Verify Total is “$2,950.00”
        Assert.assertEquals(checkoutPage.getTextExpectedTotalAmount(), "$2,950.00", "total not $2,950.00");
        //2.34 Click on “CONFIRM”
        checkoutPage.clickConfirm();
        //2.35 Verify the Text “Thank You”
        Assert.assertEquals(checkoutPage.getTextThankYou(), "Thank you", "thank you not displayed");
        //2.36 Verify the message “Your order has been successfully processed!”
        Assert.assertEquals(checkoutPage.getTextOrderSuccessfullyPlaced(), "Your order has been successfully processed!", "order success message not displayed");
        //2.37 Click on “CONTINUE”
        checkoutPage.clickContinueAfterOrderPlaced();
        //2.37 Verify the text “Welcome to our store”
        Assert.assertEquals(homePage.getWelcomeToOurStoreText(), "Welcome to our store", "Welcome text not displayed");
    }


}


