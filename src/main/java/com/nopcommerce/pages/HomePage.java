package com.nopcommerce.pages;

import com.nopcommerce.utilities.Utility;
import org.openqa.selenium.By;

public class HomePage extends Utility {
    By Computer = By.xpath("//ul[@class='top-menu notmobile']/li/a[text()='Computers ']");
    By welcomeToOurStoreText = By.xpath("//div[@class='topic-block-title']/h2");
    By electronicsTab = By.xpath("//ul[@class='top-menu notmobile']/li/a[text()='Electronics ']");
    By cellPhonesTab = By.xpath("//ul[@class='top-menu notmobile']/li/ul[@class='sublist first-level']/li/a[text()='Cell phones ']");

    public void selectMenu(String menu){
        By topMenu = By.xpath("//a[text()='" + menu + " '] ");  //Dynamically find topmenu as we need to pass dynamic value for menu
        clickOnElement(topMenu);
        By topMenuHeader = By.xpath("//h1[contains(text(),'" + menu + "')]");  // made xpath dynamic to pass different value of menu and verify them
        isTextDisplayed(topMenuHeader,menu);
    }
    public void clickOnComputer() {
        clickOnElement(Computer);
    }

    public String getWelcomeToOurStoreText() {
        return getTextFromElement(welcomeToOurStoreText);
    }
    public void hoverOnElectronics() {
        mouseHoverToElement(electronicsTab);
    }

    public void clickOnCellPhones() {
        clickOnElement(cellPhonesTab);
    }





}
