package com.nopcommerce.pages;

import com.nopcommerce.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopPage extends Utility {

    By Desktop = By.xpath("//body[1]/div[6]/div[3]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]");
    By SortByDropDown = By.xpath("//select[@id='products-orderby']");
    By addToCart = By.xpath("//button[@class='button-2 product-box-add-to-cart-button']");
    By buildYourOwnComputer = By.xpath("//h1[contains(text(),'Build your own computer')]");


    public void clickOnDesktop() {
        clickOnElement(Desktop);
    }
    public void arrangeProducts(String sortBy) {
        selectByVisibleTextFromDropDown(SortByDropDown,sortBy);
    }
    public void verifyProductsInDescendingOrder(){
        List<WebElement> productNames = driver.findElements(By.xpath("//h2[@class ='product-title']//a"));
        // Declare Two Arraylists to store the product names
        //System.out.println(productsName.size()+"........................");
        List<String> actualProductList = new ArrayList<>();
        List<String> expectedSortedProductList = new ArrayList<>();
        for(WebElement product: productNames){
            actualProductList.add(product.getText());    // add product from ProductsName to ArrayList and also get name by get() method
            expectedSortedProductList.add(product.getText());
            System.out.println(product.getText()+"..................") ;
        }
        //sort the expected product list by Collections.sort();
        Collections.sort(expectedSortedProductList);
        // Asssert.
        // isArrayListsorted(actualProductList,expectedSortedProductList);
    }

    // Click on add to cart
    public void addProductToCart(){
        clickOnElement(addToCart);
    }
    //verify the text 'Build your own computer'
    public void verifyTextBuildYourOwnComputer(String expectedText){
        isTextDisplayed(buildYourOwnComputer, expectedText);
    }






}
