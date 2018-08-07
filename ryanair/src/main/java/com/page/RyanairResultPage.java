package com.page;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by operador on 14/12/2016.
 */
public class RyanairResultPage extends PageObject {
    WebDriver driver2 = this.getDriver();
    //ATRIBUTOS
    @CacheLookup
    @FindBy(css = "div[class='direct']")
    private WebElement fly;

    //CONSTRUCTOR
    public RyanairResultPage(WebDriver driver) {
        super(driver);
    }

    @WhenPageOpens
    public void waitForPage() {
        element(fly).waitUntilVisible();
        System.out.println("Visible");
    }

    public boolean verifyResults () {
        while (!isDisplayed(fly)) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        driver2.quit();
        return true;
    }

    public static boolean isDisplayed(WebElement element) {
        try {
            if(element.isDisplayed())
                return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
        return false;
    }
}
