package com.dan.serenity.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ProductPage extends PageObject {

    @FindBy(css = "#configurable_swatch_color > li")
    private List<WebElementFacade> colorOptions;
    @FindBy(css = "#configurable_swatch_size > li")
    private List<WebElementFacade> sizeOption;
    @FindBy(css = "#downloadable-links-list > li .checkbox")
    private List<WebElementFacade> checkList;
    @FindBy(css = "#options_4_text")
    private WebElementFacade monogramming;
    @FindBy(css = "#attribute190 option")
    private List<WebElementFacade> dropDownOptions;
    @FindBy(css = "#configurable_swatch_shoe_size > li")
    private List<WebElementFacade> shoeSizeOption;
    @FindBy(css = ".add-to-cart .btn-cart")
    private WebElementFacade addToCartButton;
    @FindBy (css = ".qty-wrapper .input-text.qty")
    private List<WebElementFacade> qtyInput;
    @FindBy(css = "#product-options-wrapper")
    private WebElementFacade productOptions;
    @FindBy(css = ".product-shop .product-name")
    private WebElementFacade productName;
    @FindBy(css = "#super-product-table")
    private WebElementFacade productTable;


    private int randomColor;
    private int randomSize;
    private int randomCheck;
    private int randomDropSelect;
    private int randomShoeSize;
    private int randomQtyField;
    public String nameOfTheProduct;

    public void setconfigurable() {

        if (productOptions.isPresent()) {
            if (productOptions.findElements(By.cssSelector("#configurable_swatch_color > li")).size() != 0) {
                boolean repeat = true;
                do {
                    int min = 0;
                    int max = colorOptions.size();
                    randomColor = ThreadLocalRandom.current().nextInt(min, max);
                    colorOptions.get(randomColor).click();
                    if (addToCartButton.isCurrentlyEnabled()) {
                        repeat = false;
                    } else repeat = true;
                } while (repeat);
            }
            if (productOptions.findElements(By.cssSelector("#configurable_swatch_size > li")).size() != 0) {
                boolean repeat = true;
                do {
                    int min = 0;
                    int max = sizeOption.size();
                    randomSize = ThreadLocalRandom.current().nextInt(min, max);
                    sizeOption.get(randomSize).click();
                    if (addToCartButton.isCurrentlyEnabled()) {
                        repeat = false;
                    } else repeat = true;
                } while (repeat);
            }
            if (productOptions.findElements(By.cssSelector("#downloadable-links-list > li .checkbox")).size() != 0) {
                int min = 0;
                int max = checkList.size();
                randomCheck = ThreadLocalRandom.current().nextInt(min, max);
                checkList.get(randomCheck).click();
            }
            if (productOptions.findElements(By.cssSelector("#options_4_text")).size() != 0) {
                typeInto(monogramming, "ceva");
            }
            if (productOptions.findElements(By.cssSelector("#attribute190 option")).size() != 0) {
                int min = 1;
                int max = dropDownOptions.size();
                randomDropSelect = ThreadLocalRandom.current().nextInt(min, max);
                Select drop = new Select((WebElement) dropDownOptions);
                drop.selectByIndex(randomDropSelect);
            }
            if (productOptions.findElements(By.cssSelector("#configurable_swatch_shoe_size > li")).size() != 0) {
                boolean repeat = true;
                do {

                    int min = 0;
                    int max = shoeSizeOption.size();
                    randomShoeSize = ThreadLocalRandom.current().nextInt(min, max);
                    shoeSizeOption.get(randomShoeSize).click();
                    if (addToCartButton.isCurrentlyEnabled()) {
                        repeat = false;
                    } else repeat = true;
                } while (repeat);
            }
            addToCartButton.click();
        } else if (productTable.isPresent()) {
            if (productTable.findElements(By.cssSelector(".qty-wrapper .input-text.qty")).size() != 0) {
                int min = 0;
                int max = qtyInput.size();
                randomQtyField = ThreadLocalRandom.current().nextInt(min, max);
                typeInto(qtyInput.get(randomQtyField), "1");
            }
            addToCartButton.click();
        } else if (addToCartButton.isPresent()) {
            addToCartButton.click();
        }
    }


    public void getProductName(){
       nameOfTheProduct = productName.getText();
    }



}
