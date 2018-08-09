package com.dan.serenity.steps.serenity;

import com.dan.serenity.entity.User;
import com.dan.serenity.factories.Factory;
import com.dan.serenity.pages.*;
import com.dan.serenity.utils.Constants;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;

public class RegisterSteps extends ScenarioSteps {
    User user = Factory.generateUser();
    private RegisterPage registerPage;
    private MyAccountPage myAccountPage;
    private MagentoLoginPage magentoLoginPage;
    private MagentoHeaderPage magentoHeaderPage;
    private MagentoManageCustomers magentoManageCustomers;

    @Step
    public void openPage(){
        registerPage.open();
    }

    @Step
    public User setUserFields(){
        registerPage.setFirstNameField(user.getFirstname());
        registerPage.setLastNameField(user.getLastname());
        registerPage.setEmailField(user.getEmail());
        registerPage.setPasswordField(user.getPassword());
        registerPage.setConfirmPasswordField(user.getPassword());
        return user;
    }

    @Step
    public void clickRegButton(){
        registerPage.clickRegisterButton();
    }

    @Step
    public void checkSuccessMessage(){
        Assert.assertTrue(myAccountPage.successMessageIsDisplayed().equals("Thank you for registering with Madison Island."));
    }

    @Step
    public void navigateToMagentoLoginPage(){
        magentoLoginPage.open();
    }

    @Step
    public void typeIntoAdminLoginFields(){
        magentoLoginPage.setAdminUsername();
        magentoLoginPage.setAdminPassword();
    }

    @Step
    public void clickLoginButton(){
        magentoLoginPage.clickAdminLoginButton();
    }
    @Step
    public void closeMessagePopUp(){
        magentoLoginPage.clickCloseMessageButton();
    }

    @Step
    public void hoverCustomers(){
        magentoHeaderPage.mouseOver();
    }

    @Step
    public void clickManageCustomersButton(){
        magentoHeaderPage.clickOnManageCustomers();
    }

    @Step
    public void typeIntoSearchField(){
        magentoManageCustomers.setEmailSearchField(user.toString());
    }

    @Step
    public void clickSearchButton(){
        magentoManageCustomers.clickSearchButton();
    }

    @Step
    public void hoverUserTable(){
        magentoManageCustomers.moveToUserTable();
    }

    @Step
    public void clickEditLink(){
        magentoManageCustomers.clickOnEditLink();
    }

    @Step
    public void clickAccountInfo(){
        magentoManageCustomers.clickOnAccountInfo();
    }

    @Step
    public void checkEmailAccount(){
        Assert.assertTrue(magentoManageCustomers.readAccountEmail().equals(user.toString()));
    }

    @Step
    public void clickDeleteCustomer(){
        magentoManageCustomers.clickOnDeleteCustomerButton();
    }

    @StepGroup
    public void loginToMagento(){
        typeIntoAdminLoginFields();
        clickLoginButton();
    }
}
