package com.dan.serenity.features;

import com.dan.serenity.features.BaseTest;
import com.dan.serenity.steps.serenity.SelectRandomProductSteps;
import com.dan.serenity.steps.serenity.TotalPriceInCartSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class TotalPriceInCartTest extends BaseTest {

    @Steps
    TotalPriceInCartSteps totalPriceInCartSteps;

    @Steps
    SelectRandomProductSteps selectRandomProductSteps;


    @Test
    public void totalPriceTest(){
        selectRandomProductSteps.openPage();
        totalPriceInCartSteps.addProductsToCart(5);
        totalPriceInCartSteps.getUnitPrice();
        totalPriceInCartSteps.getQty();
        totalPriceInCartSteps.calculateTotalPrice();
        totalPriceInCartSteps.getSubTotalPrice();
        totalPriceInCartSteps.checkPrice();
    }
}
