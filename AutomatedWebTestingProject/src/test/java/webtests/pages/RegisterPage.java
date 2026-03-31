package webtests.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://automationexercise.com/login")
public class RegisterPage extends PageObject {

    // -------- Signup (first step on login page) --------

    @FindBy(name = "name")
    private WebElementFacade signupNameField;

    @FindBy(css = "input[data-qa='signup-email']")
    private WebElementFacade signupEmailField;

    @FindBy(css = "button[data-qa='signup-button']")
    private WebElementFacade signupButton;

    @FindBy(css = "p[style='color: red;']")
    private WebElementFacade emailExistsError;


    // -------- Account creation page --------

    @FindBy(id = "name")
    private WebElementFacade nameField;

    @FindBy(id = "email")
    private WebElementFacade emailField;

    @FindBy(id = "password")
    private WebElementFacade passwordField;

    @FindBy(id = "first_name")
    private WebElementFacade firstNameField;

    @FindBy(id = "last_name")
    private WebElementFacade lastNameField;

    @FindBy(id = "address1")
    private WebElementFacade addressField;

    @FindBy(id = "country")
    private WebElementFacade countryDropdown;

    @FindBy(id = "state")
    private WebElementFacade stateField;

    @FindBy(id = "city")
    private WebElementFacade cityField;

    @FindBy(id = "zipcode")
    private WebElementFacade zipCodeField;

    @FindBy(id = "mobile_number")
    private WebElementFacade mobileField;

    @FindBy(css = "button[data-qa='create-account']")
    private WebElementFacade createAccountButton;

    @FindBy(css = "button[aria-label='Consent']")
    private WebElementFacade consentButton;


    // -------- Success message (after account creation) --------

    @FindBy(css = "h2[data-qa='account-created']")
    private WebElementFacade accountCreatedMessage;


    // -------- Actions --------

    public void enterPassword(String password) {
        passwordField.type(password);
    }

    public void enterFirstName(String firstName) {
        firstNameField.type(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameField.type(lastName);
    }

    public void enterAddress(String address) {
        addressField.type(address);
    }

    public void selectCountry(String country) {
        countryDropdown.selectByVisibleText(country);
    }

    public void enterState(String state) {
        stateField.type(state);
    }

    public void enterCity(String city) {
        cityField.type(city);
    }

    public void enterZipCode(String zip) {
        zipCodeField.type(zip);
    }

    public void enterMobile(String mobile) {
        mobileField.type(mobile);
    }

    public void clickCreateAccount() {
        createAccountButton.click();
    }

    public void acceptConsentIfPresent() {
        try {
            if (consentButton.isCurrentlyVisible()) {
                consentButton.click();
            }
        } catch (Exception e) {
            // ignore if not present
        }
    }


    // -------- Combined method (cleaner for tests) --------

    public void fillRegistrationForm() {
        enterPassword("Password123");
        enterFirstName("John");
        enterLastName("Doe");
        enterAddress("123 Test Street");
        selectCountry("Singapore");
        enterState("Thisisntamerica");
        enterCity("London");
        enterZipCode("90001");
        enterMobile("07123456789");
    }


    // -------- Validations --------

    public boolean isAccountCreatedVisible() {
        try {
            return accountCreatedMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getAccountCreatedText() {
        return accountCreatedMessage.getText();
    }

    public String getEmailExistsErrorMessage() {
        return emailExistsError.getText();
    }

    public boolean isEmailExistsErrorVisible() {
        try {
            return emailExistsError.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}