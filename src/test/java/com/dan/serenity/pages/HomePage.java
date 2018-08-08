package com.dan.serenity.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@DefaultUrl("http://qa2.dev.evozon.com/")
public class HomePage extends PageObject {

    @FindBy(css = ".nav-primary > li")
    private List<WebElementFacade> categoryList;
    private List<WebElement> subCategory;

    private int randomSubCategory;
    private int randomCategory;

    public void selectCategory() {
        int min = 0;
        int max = categoryList.size();
        System.out.println(categoryList.size());
        randomCategory = ThreadLocalRandom.current().nextInt(min, max);
        System.out.println(randomCategory);
            if(randomCategory == 5){
                categoryList.get(randomCategory).click();
            }else {
                Actions hover = new Actions(getDriver());
                hover.moveToElement(categoryList.get(randomCategory)).build().perform();
                subCategory = categoryList.get(randomCategory).findElements(By.cssSelector(".nav-primary >li > ul >li"));
                System.out.println(subCategory.size());
                int mi = 1;
                int ma = subCategory.size();
                randomSubCategory = ThreadLocalRandom.current().nextInt(mi, ma);
                clickOn(subCategory.get(randomSubCategory));
        }
    }
}








