package com.dan.serenity.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ProductsSearchPage extends PageObject {

    @FindBy(css = ".products-grid >li")
    private List<WebElementFacade> productsList;





    private int randomProduct;

    public void selectRandomProduct(){
        int min = 0;
        int max = productsList.size();
        System.out.println(productsList.size());
        randomProduct = ThreadLocalRandom.current().nextInt(min, max);
        productsList.get(randomProduct).findElement(By.cssSelector(".products-grid >li a")).click();
        System.out.println(randomProduct);
    }






}
