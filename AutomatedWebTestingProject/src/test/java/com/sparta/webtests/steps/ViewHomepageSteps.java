package com.sparta.webtests.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import com.sparta.webtests.pages.HomePageRafid;

public class ViewHomepageSteps {

    @Managed
    HomePageRafid homePage;

    @Given("I am on the homepage")
    public void iAmOnTheHomepage() {
        homePage.open();
        homePage.acceptConsentIfPresent();
    }


    @When("I click on a product")
    public void iClickOnFor() {
        // Write code here that turns the phrase above into concrete actions
        homePage.clickBlueTopViewProduct();

    }

    @Then("I should be redirected to the product details page")
    public void iShouldBeRedirectedToTheProductDetailsPage() {
        MatcherAssert.assertThat(
                homePage.isCorrectProductDisplayed("Blue Top"),
                Matchers.is(true)
        );
    }


    @And("I should be able to see the Availability")
    public void iShouldBeAbleToSeeTheAvailability() {
        // Write code here that turns the phrase above into concrete actions
        Assertions.assertTrue(homePage.isAvailabilityCorrect("In Stock"));
    }
}
