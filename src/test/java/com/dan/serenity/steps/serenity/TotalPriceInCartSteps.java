package com.dan.serenity.steps.serenity;

import com.dan.serenity.pages.CartPage;
import com.dan.serenity.pages.HomePage;
import com.dan.serenity.pages.ProductPage;
import com.dan.serenity.pages.ProductsSearchPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class TotalPriceInCartSteps extends ScenarioSteps {

    SelectRandomProductSteps selectRandomProductSteps;
    HomePage homePage;
    ProductsSearchPage productsSearchPage;
    ProductPage productPage;
    CartPage cartPage;
    @Step
    public void addProductsToCart(int numberOfProducts){
        for(int i = 0; i<numberOfProducts; i++){
            homePage.selectCategory();
            productsSearchPage.selectRandomProduct();
            productPage.setconfigurable();
        }
    }

    @Step
    public void getUnitPrice(){
        cartPage.productPricePerUnit();
    }

    @Step
    public void getQty(){
        cartPage.productQty();
    }

    @Step
    public void calculateTotalPrice(){
        cartPage.calculateTotalPrice();
    }

    @Step
    public void getSubTotalPrice(){
        cartPage.getSubTotalPrice();
    }
    @Step
    public void checkPrice(){
        cartPage.checkTotalPrice();
    }
}
