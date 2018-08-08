package com.dan.serenity.steps.serenity;

import com.dan.serenity.pages.CartPage;
import com.dan.serenity.pages.HomePage;
import com.dan.serenity.pages.ProductPage;
import com.dan.serenity.pages.ProductsSearchPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;

public class SelectRandomProductSteps extends ScenarioSteps {

    private HomePage homePage;
    private ProductsSearchPage productsSearchPage;
    private ProductPage productPage;
    private CartPage cartPage;
    @Step
    public void openPage(){
        homePage.open();
    }

    @Step
    public void selectRandomCategory(){
        homePage.selectCategory();
    }

    @Step
    public void selectRandomProduct(){
        productsSearchPage.selectRandomProduct();
        productPage.getProductName();
    }

    @Step
    public void addToCart(){
        productPage.setconfigurable();
    }
    @Step
    public void checkProductName(){
        cartPage.productInCart();
        Assert.assertTrue(productPage.nameOfTheProduct.equals(cartPage.nameOfProductInCart));
    }
}
