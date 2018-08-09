package com.dan.serenity.features;

import com.dan.serenity.steps.serenity.SelectRandomProductSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class RandomSelectProductTest extends BaseTest {

    @Steps
    private SelectRandomProductSteps selectRandomCategorySteps;


    @Test
    public void selectRandomProduct(){
        selectRandomCategorySteps.openPage();
        selectRandomCategorySteps.selectRandomCategory();
        selectRandomCategorySteps.selectRandomProduct();
        selectRandomCategorySteps.addToCart();
        selectRandomCategorySteps.checkProductName();

    }



}
