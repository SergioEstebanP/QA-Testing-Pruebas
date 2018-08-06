package com.stepDefinitions;

import com.serenitySteps.RyanairSearchSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class RyanairSearchStepDefinitions {

    @Steps
    RyanairSearchSteps ryanairSearchSteps;

    @Given("^I have ryanair webpage open in Chrome$")
    public void iWantToBookingOnRyanair() throws Throwable {
        ryanairSearchSteps.openRyanairPage();
    }

    @And("^I close cookies politics$")
    public void closeCookiesPolitics () {
        ryanairSearchSteps.closeCookiesPolitics();
    }

    @When("^I click for ida$")
    public void iSelectTheDirection() throws Throwable {
        ryanairSearchSteps.selectDirection();
    }

    @And("^I want to go from '(.*)'$")
    public void iWantToGoFrom (String fromCity) {
        ryanairSearchSteps.typeSourceCity(fromCity);
    }

    @And("^I want to go to '(.*)'$")
    public void iWantToGoTo (String destinyCity) {
        ryanairSearchSteps.typeDestinyCity(destinyCity);
    }

    @And("^I want to go in date '(.*)'$")
    public void iWantToGoToNextDayFromToday (String fechaViaje) {
        ryanairSearchSteps.typeDateTrip(fechaViaje);
    }

    @And("^The trip is for '(.*)' adults$")
    public void theTripIsForNumberOfAdultsAdults(String adults) {
        ryanairSearchSteps.selectNumberOfAdults(adults);
    }


    @And("^I click in go button$")
    public void iClickInGoButton () {
        ryanairSearchSteps.selectGo();
    }

    @And("^Close rooms window$")
    public void  closeRoomsWindows () {
        ryanairSearchSteps.closeRoomsWindows();
    }

    @Then("^I see the result page with almost one flight$")
    public void seeTheResultPage () {
        ryanairSearchSteps.seeTheResultPage();
    }

}
