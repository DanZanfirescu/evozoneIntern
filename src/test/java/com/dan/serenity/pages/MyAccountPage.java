package com.dan.serenity.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class MyAccountPage extends PageObject {

    @FindBy(css = ".success-msg span")
    private WebElementFacade successMessage;
    @FindBy(css = ".welcome-msg strong")
    public WebElementFacade helloMessage;


    public String successMessageIsDisplayed() {
        System.out.println(successMessage.getText());
        return successMessage.getText();
    }
}
