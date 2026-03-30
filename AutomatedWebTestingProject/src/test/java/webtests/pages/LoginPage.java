package webtests.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://automationexercise.com/login")
public class LoginPage extends PageObject{

    // Consent button
    @FindBy(css = "button[aria-label='Consent']")
    private WebElementFacade consentButton;

    @FindBy(name = "email")
    private WebElementFacade emailLoginField;

    @FindBy(name = "password")
    private WebElementFacade passField;

    @FindBy(css = "button[data-qa='login-button']")
    private WebElementFacade loginButton;

    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    private WebElementFacade logoutButton;

    @FindBy(xpath = "//p[text()='Blue Top']/ancestor::div[@class='product-image-wrapper']//a[contains(text(),'View Product')]")
    private WebElementFacade blueTopViewProduct;






    public void acceptConsentIfPresent() {
        try {
            if (consentButton.isCurrentlyVisible()) {
                consentButton.click();
            }
        } catch (Exception e) {
            // ignore if not present
        }
    }


    public void enterEmailLogin(String emailLogin) {
        emailLoginField.type(emailLogin);
    }

    public void enterPass(String pass) { passField.type(pass); }

    public void loginButton() { loginButton.click(); }

    public boolean isLogoutVisible() { return logoutButton.isDisplayed(); }


}
