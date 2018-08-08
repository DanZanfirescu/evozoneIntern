package com.dan.serenity.pages;


import com.dan.serenity.utils.Constants;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;


@DefaultUrl(Constants.BASE_URL+"/customer/account/create/")
public class RegisterPage extends PageObject {

    @FindBy(css = "#firstname")
    private WebElementFacade firstNameField;
    @FindBy(css = "#lastname#lastname")
    private WebElementFacade lastNameField;
    @FindBy(css = "#email_address")
    private WebElementFacade emailField;
    @FindBy(css = "#password")
    private WebElementFacade passwordField;
    @FindBy(css = "#confirmation")
    private WebElementFacade confirmPasswordField;
    @FindBy(css = ".buttons-set .button")
    private WebElementFacade registerButton;



    public void setFirstNameField(String firstName){
        typeInto(firstNameField, firstName);
    }

    public void setLastNameField(String lastName){
        typeInto(lastNameField, lastName);
    }

    public void setEmailField(String email){
        typeInto(emailField, email);
    }

    public void setPasswordField(String password){
        typeInto(passwordField, password);
    }

    public void setConfirmPasswordField(String password){
        typeInto(confirmPasswordField, password);
    }
    public void clickRegisterButton(){
        clickOn(registerButton);
    }
}

