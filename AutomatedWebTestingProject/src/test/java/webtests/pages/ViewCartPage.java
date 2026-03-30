package webtests.pages;

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

}
