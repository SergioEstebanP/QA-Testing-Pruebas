package com.serenitySteps;

import com.page.GoogleResultsPage;
import com.page.GoogleSearchPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import java.util.List;

/**
 * Created by operador on 14/12/2016.
 */
public class GoogleSearchSteps {

    GoogleSearchPage searchPage;
    GoogleResultsPage resultsPage;

    @Step
    public void openGoogleSearchPage() {
        searchPage.open();
    }

    @Step
    public void searchFor(String searchRequest) {
        resultsPage = searchPage.searchFor(searchRequest);
    }

    @Step
    public void verifyResult(String searchResult) {
        List<String> results = resultsPage.getResultsList();
        Assert.assertTrue("no se ha encontrado el avion" , results.contains(searchResult));
    }
}
