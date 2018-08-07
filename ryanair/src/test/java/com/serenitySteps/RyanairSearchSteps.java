package com.serenitySteps;

import com.page.RyanairSearchPage;
import com.page.RyanairResultPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.List;

public class RyanairSearchSteps {

    RyanairSearchPage searchPage;
    RyanairResultPage resultsPage;

    @Step
    public void openRyanairPage() {
        searchPage.open();
    }

    @Step
    public void closeCookiesPolitics () {
        searchPage.closeCookiesPolitics();
    }

    @Step
    public void selectTheDirection(String searchRequest) {
        searchPage.selectTheDirection(searchRequest);
    }

    @Step
    public void typeSourceCity(String searchRequest) {
        searchPage.typeSourceCity(searchRequest);
    }

    @Step
    public void typeDestinyCity(String searchRequest) {
        searchPage.typeDestinyCity(searchRequest);
    }

    @Step
    public void typeDateTrip(String searchRequest) {
        searchPage.typeDateTrip(searchRequest);
    }

    @Step
    public void typeDateTripReturn(String searchRequest) {
        searchPage.typeDateTripReturn(searchRequest);
    }

    @Step
    public void selectNumberOfAdults(String searchRequest) {
        searchPage.selectNumberOfAdults(searchRequest);
    }

    @Step
    public void selectGo() {
        searchPage.selectGo();
    }

    @Step
    public void tabToResult() {
        searchPage.tabToResult();
    }

    @Step
    public void seeTheResultPage() {
        Assert.assertTrue("No se ha encontrado vuelo para la fecha pedida" , resultsPage.verifyResults());
    }

}
