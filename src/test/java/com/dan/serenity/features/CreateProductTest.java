package com.dan.serenity.features;

import com.dan.serenity.steps.serenity.RegisterSteps;
import com.dan.serenity.utils.Constants;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityParameterizedRunner.class)
//@UseTestDataFrom(value = Constants.CSV_PATH+"TestLoginData.csv",separator = Constants.SEPARATOR)
public class CreateProductTest extends BaseTest{

    @Steps
    private RegisterSteps registerSteps;


    @Test
    public void createProduct(){
        registerSteps.loginToMagento();
    }



}
