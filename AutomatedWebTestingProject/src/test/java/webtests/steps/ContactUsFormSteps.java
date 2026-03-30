package webtests.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import webtests.pages.ContactUsPage;

public class ContactUsFormSteps {
    @Managed
    ContactUsPage contactUsPage;

    @Given("I am on the Contact Us page")
    public void iAmOnTheContactUsPage() {
        contactUsPage.open();
        contactUsPage.acceptConsentIfPresent();
    }

    @And("I have entered the name {string}")
    public void iHaveEnteredTheName(String name) {
        contactUsPage.enterName(name);
    }

    @And("I have entered the email address {string}")
    public void iHaveEnteredTheEmail(String email) {
        contactUsPage.enterEmail(email);
    }


    @And("I have entered the subject {string}")
    public void iHaveEnteredTheSubject(String subject) {
        contactUsPage.enterSubject(subject);
    }

    @And("I have entered the message {string}")
    public void iHaveEnteredTheMessage(String message) {
        contactUsPage.enterMessage(message);
    }

    @When("I click the Submit button")
    public void iClickTheSubmitButton() {
        contactUsPage.clickSubmitButton();
    }

    @And("I click the OK button")
    public void iClickTheOKButton() {
        contactUsPage.accecptAlert();
    }

    @Then("I should see the verification message \"Success! Your details have been submitter successfully\"")
    public void iShouldSeeTheVerificationMessageSuccessYourDetailsHaveBeenSubmitterSuccessfully(){
        MatcherAssert.assertThat(contactUsPage.getConfirmationMessage(), Matchers.is(true));
    }


}
