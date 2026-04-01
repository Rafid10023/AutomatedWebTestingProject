package com.sparta.webtests.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://automationexercise.com/payment")
public class PaymentPage extends PageObject{

    // Consent button
    @FindBy(css = "button[aria-label='Consent']")
    private WebElementFacade consentButton;

    @FindBy(name = "name_on_card")
    private WebElementFacade nameOnCardField;

    @FindBy(name = "card_number")
    private WebElementFacade cardNumberField;

    @FindBy(name = "cvc")
    private WebElementFacade CVCField;

    @FindBy(name = "expiry_month")
    private WebElementFacade expiryMonthField;

    @FindBy(name = "expiry_year")
    private WebElementFacade expiryYearField;

    @FindBy(id = "submit")
    private WebElementFacade submitButton;


    public void acceptConsentIfPresent() {
        try {
            if (consentButton.isCurrentlyVisible()) {
                consentButton.click();
            }
        } catch (Exception e) {}
    }

    public void enterNameOnCard(String name) { nameOnCardField.type(name); }

    public void enterCardNumber(String number) { cardNumberField.type(number); }

    public void enterCVC(String cvc) { CVCField.type(cvc); }

    public void enterExpiryMonth(String expiryMonth) { expiryMonthField.type(expiryMonth); }

    public void enterExpiryYear(String expiryYear) { expiryYearField.type(expiryYear); }

    public void submitButton() { submitButton.click(); }

}