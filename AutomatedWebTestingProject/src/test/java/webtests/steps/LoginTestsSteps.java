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

public class LoginTestsSteps {

    @Managed
    LoginPage loginPage;

    // Log in test
    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        loginPage.open();
        loginPage.acceptConsentIfPresent();
    }

    @When("I enter the email address {string}")
    public void iEnterTheEmailAddress(String arg0) {
        loginPage.enterEmailLogin(arg0);
    }

    @And("I enter the password {string}")
    public void iEnterThePassword(String arg0) {
        loginPage.enterPass(arg0);
    }

    @And("I click the login button")
    public void iClickTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("I should see the logout button")
    public void iShouldSeeTheLogoutButton() {
        MatcherAssert.assertThat(
                loginPage.isLogoutVisible(),
                Matchers.is(true)
        );
    }

    // Incorrect credentials test
    @Given("I am on the login page to put in wrong password")
    public void iAmOnTheLoginPageToPutInWrongPassword() {
        loginPage.open();
        loginPage.acceptConsentIfPresent();
    }

    @When("I enter an invalid email and password")
    public void iEnterAnInvalidEmailAndPassword() {
        loginPage.enterEmailLogin("Rafiduddin18@gmail.com");
        loginPage.enterPass("sdfighoias");
    }

    @And("I click the login button with wrong password")
    public void iClickTheLoginButtonWithWrongPassword() {
        loginPage.clickLoginButton();
    }

    @Then("I should see a login error message")
    public void iShouldSeeALoginErrorMessage() {
        loginPage.getErrorMessage();
        MatcherAssert.assertThat(loginPage.getErrorMessage(), Matchers.is("Your email or password is incorrect!"));

    }

    // Log out test
    @Given("I am logged in")
    public void iAmLoggedIn() {
        loginPage.open();
        loginPage.acceptConsentIfPresent();

        loginPage.enterEmailLogin("Rafiduddin18@gmail.com");
        loginPage.enterPass("zxcvasdf123");
        loginPage.clickLoginButton();
    }
    @When("I click the logout button")
    public void iClickTheLogoutButton() {
        loginPage.clickLogout();
    }

    @Then("I should be logged out")
    public void iShouldBeLoggedOut() {
        MatcherAssert.assertThat(
                loginPage.isLoginFieldVisible(),
                Matchers.is(true)
        );
    }
}
