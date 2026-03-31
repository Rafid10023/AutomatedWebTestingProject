package webtests.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://automationexercise.com/login")
public class LoginPage extends PageObject {

    // -------- Elements --------

    // Consent button (if popup appears)
    @FindBy(css = "button[aria-label='Consent']")
    private WebElementFacade consentButton;

    // Login fields
    @FindBy(name = "email")
    private WebElementFacade emailLoginField;

    @FindBy(name = "password")
    private WebElementFacade passwordField;

    @FindBy(css = "button[data-qa='login-button']")
    private WebElementFacade loginButton;

    // Logout button
    @FindBy(css = "a[href='/logout']")
    private WebElementFacade logoutButton;

    // Error message
    @FindBy(css = "p[style='color: red;']")
    private WebElementFacade errorMessage;

    @FindBy(css = "input[data-qa='signup-name']")
    private WebElementFacade signupNameField;

    @FindBy(css = "input[data-qa='signup-email']")
    private WebElementFacade signupEmailField;

    @FindBy(css = "button[data-qa='signup-button']")
    private WebElementFacade signupButton;

    @FindBy(css = "p[style='color: red;']")
    private WebElementFacade emailExistsError;


    // -------- Actions --------

    public void acceptConsentIfPresent() {
        try {
            if (consentButton.isCurrentlyVisible()) {
                consentButton.click();
            }
        } catch (Exception e) {
            // ignore if not present
        }
    }

    public void enterEmailLogin(String email) {
        emailLoginField.type(email);
    }

    public void enterPass(String password) {
        passwordField.type(password);
    }

    public void enterSignupName(String name) {
        signupNameField.type(name);
    }

    public void enterSignupEmail(String email) {
        signupEmailField.type(email);
    }

    public void clickSignupButton() {
        signupButton.click();
    }

    public String getEmailExistsErrorMessage() {
        return emailExistsError.getText();
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void clickLogout() {
        logoutButton.click();
    }


    // -------- Validations --------

    public boolean isLogoutVisible() {
        try {
            return logoutButton.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isLoginFieldVisible() {
        try {
            return emailLoginField.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public boolean isErrorVisible() {
        try {
            return errorMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}