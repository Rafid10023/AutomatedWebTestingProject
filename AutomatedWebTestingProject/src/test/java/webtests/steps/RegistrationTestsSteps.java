package webtests.steps;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import webtests.pages.LoginPage;
import webtests.pages.RegisterPage;



public class RegistrationTestsSteps {

    @Managed
    RegisterPage registerPage;

    @Managed
    LoginPage loginPage;

    // Successful user registration
    @When("I enter valid registration details")
    public void iEnterValidRegistrationDetails() {
        loginPage.open();
        loginPage.acceptConsentIfPresent();
    }

    @And("It takes me to the registration page")
    public void itTakesMeToTheRegistrationPage() {
        loginPage.enterSignupName("Tester Case");
        loginPage.enterSignupEmail("Tester@zmail.com");
        loginPage.clickSignupButton();
    }

    @And("I fill in all details")
    public void iFillInAllDetails() {
        registerPage.fillRegistrationForm();
    }

    @And("I click create account")
    public void iClickCreateAccount() {
        registerPage.clickCreateAccount();
    }

    @Then("I should be logged in")
    public void iShouldBeLoggedIn() {
        MatcherAssert.assertThat(
                registerPage.isAccountCreatedVisible(),
                Matchers.is(true));
    }


    // Register with existing email
    @Given("I already have an account")
    public void iAlreadyHaveAnAccount() {
        loginPage.open();
    }

    @When("I enter an existing email")
    public void iEnterAnExistingEmail() {
        loginPage.enterSignupName("Test case");
        loginPage.enterSignupEmail("Rafiduddin18@gmail.com");
        loginPage.clickSignupButton();
    }

    @Then("I should see an email already exists error")
    public void iShouldSeeAnEmailAlreadyExistsError() {
        MatcherAssert.assertThat(
                registerPage.isEmailExistsErrorVisible(),
                Matchers.is(true));
        MatcherAssert.assertThat(
                registerPage.getEmailExistsErrorMessage(),
                Matchers.containsString("Email Address already exist!"));


    }


}