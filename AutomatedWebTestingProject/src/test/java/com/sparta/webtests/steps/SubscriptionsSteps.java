package com.sparta.webtests.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Managed;
import com.sparta.webtests.pages.HomePageRafid;
import com.sparta.webtests.pages.ViewCartPage;

public class SubscriptionsSteps {

    @Managed
    HomePageRafid homePage;
    ViewCartPage contactUsPage;

    @Given("I am on the homepage to find the subscriptions")
    public void iAmOnTheHomepageToFindTheSubscriptions() {
        homePage.open();
        homePage.acceptConsentIfPresent();
    }

    @When("I enter a valid email address")
    public void iEnterAValidEmailAddress() {
        // Write code here that turns the phrase above into concrete actions
        homePage.enterSubscriptionEmail("rafiduddin18@gmail.com");
    }

    @And("I click the subscribe button")
    public void iClickTheSubscribeButton() {
        homePage.clickSubscribeButton();
    }
    @Then("I should see a success message confirming my subscription")
    public void iShouldSeeASuccessMessageConfirmingMySubscription() {
        homePage.didSubscriptionSucceed();
    }

    @Given("I am on the cart page to find the subscriptions")
    public void iAmOnTheCartPageToFindTheSubscriptions() {
        contactUsPage.open();
        contactUsPage.acceptConsentIfPresent();
    }

    @When("I enter a valid email address on the cart page")
    public void iEnterAValidEmailAddressOnTheCartPage() {
        // Write code here that turns the phrase above into concrete actions
        contactUsPage.enterSubscriptionEmail("rafiduddin18@gmail.com");
    }

    @And("I click the subscribe button on the cart page")
    public void iClickTheSubscribeButtonOnTheCartPage() {
        // Write code here that turns the phrase above into concrete actions
        contactUsPage.clickSubscribeButton();
    }

    @Then("I should see a success message confirming my subscription on the cart page")
    public void iShouldSeeASuccessMessageConfirmingMySubscriptionOnTheCartPage() {
        // Write code here that turns the phrase above into concrete actions
        contactUsPage.didSubscriptionSucceed();
    }
}
