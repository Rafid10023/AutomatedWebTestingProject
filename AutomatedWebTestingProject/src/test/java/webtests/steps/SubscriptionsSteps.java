package webtests.steps;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import webtests.pages.HomePageRafid;

public class SubscriptionsSteps {

    @Managed
    HomePageRafid homePage;

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
}
