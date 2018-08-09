package com.dan.serenity.pages;

import com.dan.serenity.utils.Constants;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

import java.util.ArrayList;


@DefaultUrl(Constants.BASE_URL + "/customer/account/login/")
public class LoginPage extends PageObject {

    @FindBy(css = ".form-list .input-box .validate-email")
    private WebElementFacade loginEmailField;
    @FindBy(css = ".form-list .input-box .validate-password")
    private WebElementFacade loginPasswordField;
    @FindBy(css = ".registered-users .buttons-set")
    private WebElementFacade loginButton;
    @FindBy(css = "#advice-required-entry-email")
    private WebElementFacade emailRequiredMessage;
    @FindBy(css = "#advice-required-entry-pass")
    private WebElementFacade passwordRequiredMessage;
    @FindBy(css = ".error-msg span")
    private WebElementFacade errorMessage;
    private MyAccountPage myAccountPage;

    public ArrayList<String> messages = new ArrayList<>();

    public void setLoginEmailField (String email){
        typeInto(loginEmailField, email);
    }

    public void setLoginPasswordField(String password){
        typeInto(loginPasswordField, password);
    }

    public void clickLoginButton(){
        clickOn(loginButton);
    }

    public String getEmailRequiredMessage(){
        return emailRequiredMessage.getText();
    }

    public String getPasswordRequiredMessage(){
        return passwordRequiredMessage.getText();
    }

    public String getErrorMessage(){
        return errorMessage.getText();
    }

    public void messages(){
        if(emailRequiredMessage.isPresent()){
            messages.add(getEmailRequiredMessage());
        }
        if(passwordRequiredMessage.isPresent()){
            messages.add(getPasswordRequiredMessage());
        }
        if(errorMessage.isPresent()){
            messages.add(getErrorMessage());
       }
       if(myAccountPage.helloMessage.isPresent()){
           messages.add(myAccountPage.helloMessage.getText());
        }
    }
}
