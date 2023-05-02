package com.nopcommerce.pages;

import com.nopcommerce.utilities.Utility;
import org.openqa.selenium.By;


public class CellPhonesPage extends Utility {

        By cellPhonesText = By.xpath("//div[@class='page-title']/h1");
        By listTab = By.xpath("//a[@class='viewmode-icon list']");
        By productNokiaLumiaLink = By.linkText("Nokia Lumia 1020");

        public String getCellPhonesText() {
            return getTextFromElement(cellPhonesText);
        }
        public void clickListTab(){
            clickOnElement(listTab);
        }
        public void clickOnNokiaLumia(){
            clickOnElement(productNokiaLumiaLink);
        }


}
