package com.dan.serenity.pages;

import com.dan.serenity.utils.Constants;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.interactions.Actions;

public class MagentoManageCustomers extends PageObject {

    @FindBy(css = "#customerGrid_filter_email")
    private WebElementFacade emailSearchField;
    @FindBy(css = ".filter-actions .task")
    private WebElementFacade searchButton;
    @FindBy(css = "#customerGrid_table .last a")
    private WebElementFacade editCustomerLink;
    @FindBy(css = "#customerGrid_table .even")
    private WebElementFacade userTable;
    @FindBy(css = ".side-col [name=account]")
    private WebElementFacade accountInfo;
    @FindBy(css = "#_accountemail")
    private WebElementFacade emailAccount;
    @FindBy(css = ".content-header .scalable.delete")
    private WebElementFacade deleteCustomerButton;


    public void setEmailSearchField(String email){
        typeInto(emailSearchField, email);
    }

    public void clickSearchButton(){
        clickOn(searchButton);
    }

    public void moveToUserTable(){
        Actions hover = new Actions(getDriver());
        hover.moveToElement(userTable).build().perform();
    }

    public void clickOnEditLink(){
        clickOn(editCustomerLink);
    }

    public void clickOnAccountInfo(){
        clickOn(accountInfo);
    }

    public String readAccountEmail(){
        System.out.println(emailAccount.getValue());
        return emailAccount.getValue();
    }

    public void clickOnDeleteCustomerButton(){
        clickOn(deleteCustomerButton);
        getDriver().switchTo().alert().accept();
    }
}
