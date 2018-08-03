package com.page;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;

import java.util.concurrent.TimeUnit;

import static io.vavr.API.$;

/**
 * Created by operador on 14/12/2016.
 */
@DefaultUrl("https://google.com")
public class GoogleSearchPage extends PageObject {

    //ATRIBUTOS
    @CacheLookup
    @FindBy(id = "lst-ib")
    private WebElement searchInputField;

    //CONSTRUCTOR
    public GoogleSearchPage(WebDriver driver) {
        super(driver);
        max(driver);
    }

    public static void max(WebDriver driver){
        driver.manage().window().maximize();
    }

    @WhenPageOpens
    public void waitUntilGoogleLogoAppears() {
        $("#hplogo").waitUntilVisible();
    }

    public GoogleResultsPage searchFor(String searchRequest) {
        element(searchInputField).clear();
        element(searchInputField).typeAndEnter(searchRequest);
        return new GoogleResultsPage(getDriver());
    }
}
