package com.page;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.WhenPageOpens;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by operador on 14/12/2016.
 */
public class GoogleResultsPage extends PageObject {
    //ATRIBUTOS
    @CacheLookup
    @FindBy(xpath = "//h3")
    private List<WebElement> linkTitlesList;

    //CONSTRUCTOR
    public GoogleResultsPage(WebDriver driver) {
        super(driver);

    }

    @WhenPageOpens
    public void waitForPage() {
        // wait for google sub menu: Web | Images | Videos | ...
        $("#hdtb-msb").waitUntilVisible();
    }

    public List<String> getResultsList() {
        List<String> resultList = new ArrayList<>();
        for (WebElement element : linkTitlesList) {
            resultList.add(element.getText());
        }
        return resultList;
    }
}
