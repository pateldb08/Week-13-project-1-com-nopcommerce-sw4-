package com.nopcommerce.pages;

import com.nopcommerce.utilities.Utility;
import org.openqa.selenium.By;

public class SignInPage extends Utility {
    By signInText = By.xpath("//div[@class='page-title']/h1");
    By checkoutAsGuest = By.xpath("//button[@class='button-1 checkout-as-guest-button']");
    By registerButton = By.xpath("//button[contains(text(),'Register')]");
    By welcomeText = By.xpath("//div[@class='page-title']/h1");



    public void verifyWelcomeText(String expectedText){
    isTextDisplayed(signInText, expectedText);
}
    public void clickCheckoutAsGuest() throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(checkoutAsGuest);
    }
//    public void clickOnRegister() {
//        clickOnElement(registerButton);
//    }

    public String getWelcomeText() {
        return getTextFromElement(welcomeText);
    }
    public void clickOnRegister() {
        clickOnElement(registerButton);
    }


}
