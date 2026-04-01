package com.sparta.webtests.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import com.sparta.webtests.pages.HomePageRafid;

public class AddingToCartSteps {

    @Managed
    HomePageRafid addCart;

    @Given("I am on the homepage to buy something")
    public void iAmOnTheHomepageToBuySomething() {
        // Write code here that turns the phrase above into concrete actions
        addCart.open();
        addCart.acceptConsentIfPresent();
    }

    @When("I add the Blue Top product to the cart")
    public void iAddTheBlueTopProductToTheCart() {

        // Write code here that turns the phrase above into concrete actions
        addCart.clickAddToCart();
    }

    @Then("the product should be added to the cart")
    public void theProductShouldBeAddedToTheCart() {
        addCart.clickViewCart();
    }


    @And("When I go to the cart I should see the product there")
    public void whenIGoToTheCartIShouldSeeTheProductThere() {
        MatcherAssert.assertThat(
                addCart.isBlueTopInCart(),
                Matchers.is(true)
        );
    }

    @Then("the product should be added to the cart with a confirmation")
    public void theProductShouldBeAddedToTheCartWithAConfirmation() {

        MatcherAssert.assertThat(
                addCart.isAddToCartConfirmationDisplayed(),
                Matchers.is(true)
        );
    }

    @And("I can continue shopping")
    public void iCanContinueShopping() {
        // Write code here that turns the phrase above into concrete actions
        addCart.clickContinueShopping();
    }

    @When("I add the Blue Top product to the cart and the Men Tshirt")
    public void iAddTheBlueTopProductToTheCartAndTheMenTshirt() {
        // Write code here that turns the phrase above into concrete actions
        addCart.clickAddToCart();
        addCart.clickContinueShopping();
        addCart.clickMenTshirtAddToCart();
    }

    @Then("the products should be added to the cart with a confirmation")
    public void theProductsShouldBeAddedToTheCartWithAConfirmation() {
        // Write code here that turns the phrase above into concrete actions
        MatcherAssert.assertThat(
                addCart.isAddToCartConfirmationDisplayed(),
                Matchers.is(true)
        );

    }

    @And("I when i click on the carts the two products should be there")
    public void iWhenIClickOnTheCartsTheTwoProductsShouldBeThere() {
        // Write code here that turns the phrase above into concrete actions
        addCart.clickViewCartFromModal();
        MatcherAssert.assertThat(addCart.getTotalQuantity(), Matchers.is(2));

    }
}
