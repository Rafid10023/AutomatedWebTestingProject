package com.sparta.webtests.steps;

import com.sparta.webtests.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import webtests.pages.*;

public class CheckoutSteps {
    @Managed
    LoginPage loginPage;
    HomePageRafid homePage;
    ViewCartPage viewCart;
    CheckoutPage checkoutPage;
    PaymentPage paymentPage;

    @Given("I am logged in as a customer")
    public void iAmLoggedInAsACustomer() {
        loginPage.open();
        loginPage.acceptConsentIfPresent();

        loginPage.enterEmailLogin("Rafiduddin18@gmail.com");
        loginPage.enterPass("zxcvasdf123");
        loginPage.clickLoginButton();
    }

    @And("I have added a product to the cart")
    public void iHaveAddedAProductToTheCart() {
        homePage.clickAddToCart();
    }

    @And("I click on the cart button")
    public void iClickOnTheCartButton() {
       homePage.clickViewCart();
    }

    @And("I click proceed to checkout")
    public void iClickProceedToCheckout() {
        viewCart.checkoutButton();
    }

    @And("I click Place Order")
    public void iClickPlaceOrder() {
        checkoutPage.placeOrderButton();
    }

    @And("I enter Name on Card")
    public void iEnterNameOnCardString() {
        paymentPage.enterNameOnCard("John");
    }

    @And("I enter Card Number")
    public void iEnterCardNumberString() {
        paymentPage.enterCardNumber("1234");
    }

    @And("I enter CVC")
    public void iEnterCVCString() {
        paymentPage.enterCVC("123");
    }

    @And("I enter Expiration date")
    public void iEnterExpirationDateString() {
       paymentPage.enterExpiryMonth("11");
    }

    @And("I enter Year")
    public void iEnterYearString() {
        paymentPage.enterExpiryYear("2029");
    }

    @When("I click Pay and Confirm Order button")
    public void iClickPayAndConfirmOrderButton() {
        paymentPage.submitButton();
    }

    @Then("I should see the verification message for an order being placed")
    public void iShouldSeeTheVerificationMessageForAnOrderBeingPlaced() {
        MatcherAssert.assertThat(paymentPage.getDriver().getCurrentUrl(), Matchers.containsString("https://automationexercise.com/payment_done"));
    }


}
