package com.sparta.webtests.pages;


import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.Alert;

@DefaultUrl("https://automationexercise.com/contact_us")
public class ContactUsPage extends PageObject {

    @FindBy(name = "name")
    private WebElementFacade nameField;

    @FindBy(name = "email")
    private WebElementFacade emailField;

    @FindBy(name = "subject")
    private WebElementFacade subjectField;

    @FindBy(name = "message")
    private WebElementFacade messageField;

    @FindBy(name = "submit")
    private WebElementFacade submitButton;

    @FindBy(xpath = "//div[@class='status alert alert-success']")
    private WebElementFacade successVerification;

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

    public void enterSubject(String subject) {
        subjectField.type(subject);
    }

    public void enterMessage(String message) {
        messageField.type(message);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public void accecptAlert() {
        Alert alert = getDriver().switchTo().alert();
        alert.accept();
    }

    public boolean getConfirmationMessage() {
        return successVerification.isCurrentlyVisible();
    }
}
