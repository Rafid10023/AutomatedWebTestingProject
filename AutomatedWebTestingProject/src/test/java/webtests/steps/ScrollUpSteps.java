package webtests.steps;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import webtests.pages.HomePageRafid;

public class ScrollUpSteps {
    @Managed
    HomePageRafid homepage;

    @Given("I am on the home page")
    public void iAmOnTheHomePage() {
        homepage.open();
        homepage.acceptConsentIfPresent();
    }


    @And("I scroll to the bottom of the page")
    public void iScrollToTheBottomOfThePage() {
        JavascriptExecutor js = (JavascriptExecutor) homepage.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", homepage.find(By.id("subscribe")));
    }

    @When("I click on the arrow button on the bottom right")
    public void iClickOnTheArrowButtonOnTheBottomRight() {
        homepage.clickScrollUpButton();
    }

    @Then("I the page will scroll automatically to the top")
    public void iThePageWillScrollAutomaticallyToTheTop() {
        MatcherAssert.assertThat(homepage.isHeaderVisible(), Matchers.is(true));
    }
}
