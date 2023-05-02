package com.nopcommerce.pages;

import com.nopcommerce.utilities.Utility;
import org.openqa.selenium.By;

public class ShoppingCartPage extends Utility {

    By shoppingCartText = By.xpath("//h1[contains(text(),'Shopping cart')]");
    By quantity = By.className("qty-input");
    By updateButton = By.xpath("//button[@class='button-2 update-cart-button']");
    By totalPrice = By.xpath("//span[@class='value-summary']/strong");
    By termsOfService = By.xpath("//input[@name='termsofservice']");
    By checkout = By.xpath("//button[@name='checkout']");
    By shoppingCartMessage = By.xpath("//h1[contains(text(),'Shopping cart')]");



    public void verifyShoppingCartText(String expectedText){
        isTextDisplayed(shoppingCartText,expectedText);
    }
    public void clearQuantity(){
        driver.findElement(quantity).clear();
    }
    public void sendQuantity(String qunatityNum){
        sendTextToElement(quantity , qunatityNum);
    }
    public void clickOnUpdateShoppingCart(){
        clickOnElement(updateButton);
    }
    public void verifyTheTotal(String expectedTotal){
        isTextDisplayed(totalPrice,expectedTotal);
    }
       /* public String getTotalPriceShoppingCart() {
          return getTextFromElement(totalPrice);
         }
      */
       public void clickOnTermsOfService() {
           clickOnElement(termsOfService);
       }
    public void clickOnCheckout() {
        clickOnElement(checkout);
    }
    public String getShoppingCartMessage() {
        return getTextFromElement(shoppingCartMessage);
    }
    public String getQuantity() {
        return driver.findElement(quantity).getAttribute("value");
    }
    public String getTotalPriceShoppingCart() {
        return getTextFromElement(totalPrice);
    }



}

//span[@class='value-summary']//strong[contains(text(),'$2,960.00')]