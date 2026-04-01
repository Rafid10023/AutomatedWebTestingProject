package com.sparta.webtests.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://automationexercise.com/view_cart")
public class ViewCartPage extends PageObject {

    // Consent button
    @FindBy(css = "button[aria-label='Consent']")
    private WebElementFacade consentButton;

    // Proceed to checkout button
    @FindBy(css = "a.check_out")
    private WebElementFacade checkoutButton;

    // Empty cart object
    @FindBy(id = "empty_cart")
    private WebElementFacade emptyCart;

    // Full cart object
    @FindBy(id = "cart_info_table")
    private WebElementFacade shoppingCart;

    @FindBy(id = "susbscribe_email")
    private WebElementFacade subscriptionEmailInput;

    @FindBy(id = "subscribe")
    private WebElementFacade subscribeButton;

    @FindBy(css = "div.alert-success")
    private WebElementFacade successMessage;

    public void acceptConsentIfPresent() {
        try {
            if (consentButton.isCurrentlyVisible()) {
                consentButton.click();
            }
        } catch (Exception e) {
            // ignore if not present
        }
    }

    public void checkoutButton() { checkoutButton.click(); }

    public boolean cartIsEmpty() { return emptyCart.isDisplayed(); }

    public void enterSubscriptionEmail(String email) {
        evaluateJavascript("window.scrollTo(0, document.body.scrollHeight);");
        subscriptionEmailInput.type(email);
    }

    public void clickSubscribeButton() {
        subscribeButton.waitUntilClickable().click();
    }

    public boolean didSubscriptionSucceed() {
        try {
            return successMessage.waitUntilVisible()
                    .containsText("successfully subscribed");
        } catch (Exception e) {
            return false;
        }
    }

}
