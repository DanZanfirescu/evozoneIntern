package com.dan.serenity.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends PageObject {

    @FindBy(css = "#shopping-cart-table")
    private WebElementFacade cartProductTable;
    @FindBy(css = ".product-cart-price .cart-price .price")
    private List<WebElementFacade> cartProductsPriceList;
    @FindBy(css = ".product-cart-actions .input-text.qty")
    private List<WebElementFacade> quantityList;
    @FindBy(css= "#shopping-cart-totals-table tbody >tr:first-child span")
    private WebElementFacade subTotalPrice;

    public String nameOfProductInCart;
    private ArrayList<Double> unitPriceList = new ArrayList<>();
    private ArrayList<Double> unitQty = new ArrayList<>();
    private ArrayList<Double> finalProductPrice = new ArrayList<>();

    public void productInCart(){
       nameOfProductInCart =  cartProductTable.findElement(By.cssSelector(".product-cart-info .product-name")).getText();
    }


    public void productPricePerUnit(){
        for (int i = 0; i<cartProductsPriceList.size(); i++){
            String price = cartProductsPriceList.get(i).getText().replace("$","");
            double price1 = Double.parseDouble(price);
            System.out.println(price1);
            unitPriceList.add(price1);
        }
    }

    public void productQty(){
        for(int i = 0; i<quantityList.size(); i++){
            String qty = quantityList.get(i).getValue();
            double qty1 = Double.parseDouble(qty);
            unitQty.add(qty1);
        }
    }

    private double sum;
    public void calculateTotalPrice(){
        for(int i = 0; i<unitPriceList.size(); i++){
            double finPrice = unitPriceList.get(i)*unitQty.get(i);
            finalProductPrice.add(finPrice);
        }
        sum = 0;
        for (int i = 0; i<finalProductPrice.size(); i++){
            sum = sum + finalProductPrice.get(i);
        }
        System.out.println(sum);
    }

    private double subTotal;
    public void getSubTotalPrice(){
        String subTotal1 = subTotalPrice.getText().replace("$", "");
        if(subTotal1.contains(",")){
            subTotal = Double.parseDouble(subTotal1.replace(",", ""));
        }else
            subTotal = Double.parseDouble(subTotal1);
        System.out.println(subTotal);
    }

    public void checkTotalPrice(){
        Assert.assertTrue(sum == subTotal);
    }
}
