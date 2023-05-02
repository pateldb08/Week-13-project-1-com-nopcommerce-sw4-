package com.nopcommerce.pages;

import com.nopcommerce.utilities.Utility;
import org.openqa.selenium.By;

public class BuildYourOwnComputerPage extends Utility {

    By processor = By.xpath("//select[@name='product_attribute_1']");
    By ram = By.xpath("//select[@name='product_attribute_2']");
    By HDD = By.id("product_attribute_3_7");
    By OS = By.xpath("//label[text()='Vista Premium [+$60.00]']");
    //By microSoftOfficeSoftware = By.xpath("//input[@id='product_attribute_5_10'])");
    By totalCommander = By.xpath("//label[@for='product_attribute_5_12']");
    By price = By.xpath("//span[@id='price-value-1']");
    By addToCart = By.id("add-to-cart-button-1");
    By productHasBeenAddedText = By.xpath("//div[@class='bar-notification success']/p");
    By crossBtn = By.className("close");
    By shoppingCart = By.className("cart-label");
    By goToCart = By.xpath("//button[contains(text(),'Go to cart')]");


    public void selectProcessorName(String text)  {
        selectByVisibleTextFromDropDown(processor,text);
    }
    public void selectRam(String text){
        selectByVisibleTextFromDropDown(ram, "8GB [+$60.00]");
    }
    public void selectHDDOption(){
        clickOnElement(HDD);
    }
    public void selectOSOption(){
        clickOnElement(OS);
    }
   //    public void checkMicrosoftOfficeSoftware(){
   //        clickOnElement(microSoftOfficeSoftware);
   //    }
    public void selectSoftwareOptions(){
        clickOnElement(totalCommander);
    }
    public void verifyThePrice(String value ){
        isTextDisplayed(price,value);
    }
    public void clickOnAddToCartBtn(){
        clickOnElement(addToCart);
    }
    public void verifyTheTextProductHasbeenAdded(String expectedText){
        isTextDisplayed(productHasBeenAddedText,expectedText);
    }
    public void closeTheBar(){
        clickOnElement(crossBtn);
    }
    public void mouseHoverToShoppingCart(){
        mouseHoverToElement(shoppingCart);
    }
    public void clickOnGoToCart(){
        clickOnElement(goToCart);
    }




}
