package com.dan.serenity.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class CartPage extends PageObject {

    @FindBy(css = "#shopping-cart-table")
    private WebElementFacade cartProductTable;

    public String nameOfProductInCart;

    public void productInCart(){
       nameOfProductInCart =  cartProductTable.findElement(By.cssSelector(".product-cart-info .product-name")).getText();
    }






}
