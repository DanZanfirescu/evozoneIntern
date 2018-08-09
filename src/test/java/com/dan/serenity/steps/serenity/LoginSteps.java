package com.dan.serenity.steps.serenity;

import com.dan.serenity.pages.LoginPage;
import com.dan.serenity.pages.MyAccountPage;
import com.dan.serenity.utils.Constants;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class LoginSteps extends ScenarioSteps {

    private LoginPage loginPage;
    private MyAccountPage myAccountPage;

    @Step
    public void openPage(){
        loginPage.open();
    }

    @Step
    public void typeIntoLoginFields(String email, String password){
        loginPage.setLoginEmailField(email);
        loginPage.setLoginPasswordField(password);
    }

    @Step
    public void clickOnLoginButton(){
        loginPage.clickLoginButton();
    }

    @Step
    public void checkMessage(String expected){
        loginPage.messages();
        for (int i = 0; i<loginPage.messages.size(); i++){
            Assert.assertTrue(loginPage.messages.get(i).equals(expected));
        }

    }
}
