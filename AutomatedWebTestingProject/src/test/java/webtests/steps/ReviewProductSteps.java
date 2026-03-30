package webtests.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import webtests.pages.ProductDetailsPage;

public class ReviewProductSteps {
    @Managed
    ProductDetailsPage productDetailsPage;

    @Given("I am on a product page")
    public void iAmOnAProductPage() {
        productDetailsPage.open();
        productDetailsPage.acceptConsentIfPresent();
    }

    @And("I have entered a name {string}")
    public void iHaveEnteredTheName(String name) {
        productDetailsPage.enterName(name);
    }

    @And("I have entered an email address {string}")
    public void iHaveEnteredTheEmail(String email) {
        productDetailsPage.enterEmail(email);
    }

    @And("I have entered the review {string}")
    public void iHaveEnteredTheSubject(String review) {
        productDetailsPage.enterReview(review);
    }

    @When("I click the Submit Review button")
    public void iClickTheSubmitReviewButton() {
        productDetailsPage.clickSubmitReviewButton();
    }

    @Then("I should see the verification message")
    public void iShouldSeeTheVerificationMessage() {
        MatcherAssert.assertThat(productDetailsPage.getValidationMessage(), Matchers.is(true));
    }
}
