package com.dan.serenity.features;

import com.dan.serenity.steps.serenity.LoginSteps;
import com.dan.serenity.utils.Constants;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = Constants.CSV_PATH+"TestLoginData.csv",separator = Constants.SEPARATOR)
public class LoginTests extends BaseTest {

    @Steps
    private LoginSteps loginSteps;
    String email, password, expected;
    @Test
    public void loginTest(){
        loginSteps.openPage();
        loginSteps.typeIntoLoginFields(email, password);
        loginSteps.clickOnLoginButton();
        loginSteps.checkMessage(expected);
    }

}
