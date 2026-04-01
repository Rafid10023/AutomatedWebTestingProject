package com.sparta.webtests.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import com.sparta.webtests.pages.HomePageRafid;

public class FiltersSteps {

    @Managed
    HomePageRafid homePage;


    @Given("I am on the homepage to find filters by category")
    public void iAmOnTheHomepageToFindFiltersByCategory() {
        homePage.open();
        homePage.acceptConsentIfPresent();
    }

    @When("I expand the woman category")
    public void iExpandTheCategory() {
        homePage.clickWomenCategory();
    }

    @And("I select a category option")
    public void iSelectACategoryOption() {
        homePage.clickDressCategory();
    }

    @Then("I should see only products related to that category")
    public void iShouldSeeOnlyProductsRelatedToThatCategory() {
        // Write code here that turns the phrase above into concrete actions
        MatcherAssert.assertThat(
                homePage.isWomenDressPageDisplayed(),
                Matchers.is(true)
        );
    }
}
