package com.sparta.webtests.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://automationexercise.com/checkout")
public class CheckoutPage extends PageObject {

    // Consent button
    @FindBy(css = "button[aria-label='Consent']")
    private WebElementFacade consentButton;

    // Proceed to checkout button
    @FindBy(css = "a.check_out")
    private WebElementFacade placeOrder;



    public void acceptConsentIfPresent() {
        try {
            if (consentButton.isCurrentlyVisible()) {
                consentButton.click();
            }
        } catch (Exception e) {
            // ignore if not present
        }
    }

    public void placeOrderButton() { placeOrder.click(); }

}
