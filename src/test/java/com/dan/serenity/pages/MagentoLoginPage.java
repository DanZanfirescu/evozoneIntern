package com.dan.serenity.pages;

import com.dan.serenity.utils.Constants;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;


@DefaultUrl(Constants.BASE_URL+"/admin")
public class MagentoLoginPage extends PageObject {

    @FindBy(css = "#username")
    private WebElementFacade adminUsernameField;
    @FindBy(css = "#login")
    private WebElementFacade adminPasswordField;
    @FindBy(css = ".form-button")
    private WebElementFacade adminLoginButton;
    @FindBy(css = "[title=close]")
    private WebElementFacade closeMessageButton;

    public void setAdminUsername(){
        typeInto(adminUsernameField, Constants.ADMIN_USERNAME);
    }

    public void setAdminPassword(){
        typeInto(adminPasswordField, Constants.ADMIN_PASSWORD);
    }

    public void clickAdminLoginButton(){
        evaluateJavascript("jQuery.noConflict();");
        clickOn(adminLoginButton);
    }

    public void clickCloseMessageButton(){
        clickOn(closeMessageButton);
    }
}
