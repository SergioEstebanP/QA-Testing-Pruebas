package com.stepDefinitions;

import com.serenitySteps.GoogleSearchSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

/**
 * Created by operador on 14/12/2016.
 */
public class GoogleSearchStepDefinitions {

    @Steps
    GoogleSearchSteps googleSearchSteps;

    @Given("^I want to search in Google$")
    public void iWantToSearchInGoogle() throws Throwable {
        googleSearchSteps.openGoogleSearchPage();
    }

    @When("^I search for '(.*)'$")
    public void iSearchFor(String searchRequest) throws Throwable {
        googleSearchSteps.searchFor(searchRequest);
    }

    @Then("^I should see link to '(.*)'$")
    public void iShouldSeeLinkTo(String searchResult) throws Throwable {
        googleSearchSteps.verifyResult(searchResult);
    }

    @And("^Other$")
    public void other() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

}
