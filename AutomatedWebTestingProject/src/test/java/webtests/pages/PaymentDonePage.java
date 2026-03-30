package webtests.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://automationexercise.com/payment_done/{id}")
public class PaymentDonePage extends PageObject{

    // Consent button
    @FindBy(css = "button[aria-label='Consent']")
    private WebElementFacade consentButton;

    // Proceed to checkout button
    @FindBy(css = "a.check_out")
    private WebElementFacade downloadInvoiceButton;

    // Proceed to checkout button
    @FindBy(css = "a.btn-primary")
    private WebElementFacade continueButton;

    public void acceptConsentIfPresent() {
        try {
            if (consentButton.isCurrentlyVisible()) {
                consentButton.click();
            }
        } catch (Exception e) {}
    }

    public void downloadInvoice() { downloadInvoiceButton.click(); }

    public void continueButton() { continueButton.click(); }

}