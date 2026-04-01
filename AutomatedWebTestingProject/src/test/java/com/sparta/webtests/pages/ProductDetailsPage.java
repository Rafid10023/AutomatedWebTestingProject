package com.sparta.webtests.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://automationexercise.com/product_details/1")
public class ProductDetailsPage extends PageObject {

    @FindBy(id = "name")
    private WebElementFacade nameField;

    @FindBy(id = "email")
    private WebElementFacade emailField;

    @FindBy(id = "review")
    private WebElementFacade reviewField;

    @FindBy(id = "button-review")
    private WebElementFacade buttonSubmitReview;

    @FindBy(xpath = "//span[text()='Thank you for your review.']")
    private WebElementFacade reviewValidation;

    @FindBy(css = "button[aria-label='Consent']")
    private WebElementFacade consentButton;

    public void acceptConsentIfPresent() {
        try {
            if (consentButton.isCurrentlyVisible()) {
                consentButton.click();
            }
        } catch (Exception e) {
            // ignore if not present
        }
    }

    public void enterName(String name) {
        nameField.type(name);
    }

    public void enterEmail(String email) {
        emailField.type(email);
    }

    public void enterReview(String review) { reviewField.type(review); }

    public void clickSubmitReviewButton() { buttonSubmitReview.click(); }

    public boolean getValidationMessage() { return reviewValidation.isVisible(); }
}
