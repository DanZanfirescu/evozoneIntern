package com.dan.serenity.features.search;

import com.dan.serenity.pages.MyAccountPage;
import com.dan.serenity.steps.serenity.RegisterSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;



@RunWith(SerenityRunner.class)
public class RegisterTest extends BaseTest{

    @Steps
    private RegisterSteps registerSteps;



    @Test
    public void registerTestValidCredentials(){
        registerSteps.openPage();
        registerSteps.setUserFields();
        registerSteps.clickRegButton();
        registerSteps.checkSuccessMessage();
        registerSteps.navigateToMagentoLoginPage();
        registerSteps.typeIntoAdminLoginFields();
        registerSteps.clickLoginButton();
        registerSteps.closeMessagePopUp();
        registerSteps.hoverCustomers();
        registerSteps.clickManageCustomersButton();
        registerSteps.typeIntoSearchField();
        registerSteps.clickSearchButton();
        registerSteps.hoverUserTable();
        registerSteps.clickEditLink();
        registerSteps.clickAccountInfo();
        registerSteps.checkEmailAccount();
        registerSteps.clickDeleteCustomer();
    }




}
