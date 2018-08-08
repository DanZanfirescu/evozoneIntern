package com.dan.serenity.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class MagentoHeaderPage extends PageObject {


    @FindBy(css = "#nav .level0")
    private List<WebElementFacade> navBar;
    @FindBy(css = "#nav .level0  > ul >li:nth-child(1)")
    private WebElementFacade manageCustomersButton;
    @FindBy(css = ".header-top .super a")
    private WebElementFacade logoutLink;



    public void mouseOver(){
        navBar.get(3).getCoordinates();
        Actions hover = new Actions(getDriver());
        hover.moveToElement(navBar.get(3)).build().perform();
    }

    public void clickOnManageCustomers(){
        navBar.get(3).findBy("#nav .level0  > ul >li:nth-child(1)").click();
    }

    public void clickOnLogoutLink(){
        clickOn(logoutLink);
    }






}
