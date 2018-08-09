package com.dan.serenity.features;

import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    @Managed(uniqueSession = true)
    public WebDriver driver;
    @Before
    public void setDriver() {
        driver.manage().window().maximize();
    }
}
