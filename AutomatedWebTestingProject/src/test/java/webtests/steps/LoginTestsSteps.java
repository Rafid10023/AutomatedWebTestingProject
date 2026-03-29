package webtests.steps;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import webtests.pages.LoginPage;

public class LoginTestsSteps {

    @Managed
    LoginPage loginPage;


    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        // Write code here that turns the phrase above into concrete actions
        loginPage.open();
        loginPage.acceptConsentIfPresent();
    }

    @When("I enter the email address {string}")
    public void iEnterTheEmailAddress(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        loginPage.enterEmailLogin(arg0);
    }

    @And("I enter the password {string}")
    public void iEnterThePassword(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        loginPage.enterPass(arg0);
    }

    @And("I click the login button")
    public void iClickTheLoginButton() {
        // Write code here that turns the phrase above into concrete actions
        loginPage.loginButton();
    }

    @Then("I should see the logout button")
    public void iShouldSeeTheLogoutButton() {
        MatcherAssert.assertThat(
                loginPage.isLogoutVisible(),
                Matchers.is(true)
        );
    }
}
