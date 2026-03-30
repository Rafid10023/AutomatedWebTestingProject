package webtests.pages;


import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://automationexercise.com/")
public class HomePageRafid extends PageObject {

    @FindBy(css = "button[aria-label='Consent']")
    private WebElementFacade consentButton;

    @FindBy(xpath = "//p[text()='Blue Top']/ancestor::div[@class='product-image-wrapper']//a[contains(text(),'View Product')]")
    private WebElementFacade blueTopViewProduct;

    @FindBy(xpath = "//div[@class='product-information']/h2")
    private WebElementFacade productName;

    @FindBy(xpath = "//b[text()='Availability:']/parent::p")
    private WebElementFacade availabilityText;

    @FindBy(css = "a[href='#Women']")
    private WebElementFacade womenCategory;

    @FindBy(css = "div#Women a[href='/category_products/1']")
    private WebElementFacade womenDressCategory;

    @FindBy(xpath = "//h2[contains(text(),'Women - Dress Products')]")
    private WebElementFacade womenDressTitle;

    @FindBy(id = "subscribe_email")
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

    public void clickBlueTopViewProduct() {
        blueTopViewProduct.click();
    }

    public boolean isCorrectProductDisplayed(String expectedName) {
        try {
            return productName.isCurrentlyVisible() &&
                    productName.getText().equals(expectedName);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isProductInfoDisplayed() {
        try {
            return productName.isCurrentlyVisible();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isAvailabilityCorrect(String expectedAvailability) {
        try {
            return availabilityText.isCurrentlyVisible() &&
                    availabilityText.getText().contains(expectedAvailability);
        } catch (Exception e) {
            return false;
        }

    }
    public void clickWomenCategory() {
        womenCategory.waitUntilClickable().click();
    }
    public void clickDressCategory() {
        womenDressCategory.waitUntilClickable().click();
    }

    public boolean isWomenDressPageDisplayed() {
        try {
            return womenDressTitle.isCurrentlyVisible();
        } catch (Exception e) {
            return false;
        }
    }

    public void enterSubscriptionEmail(String email) {
        subscriptionEmailInput.waitUntilVisible().type(email);
    }

    public void clickSubscribeButton() {
        subscribeButton.waitUntilClickable().click();
    }

    public boolean didSubscriptionSucceed() {
        try {
            successMessage.waitUntilVisible(); // waits until it appears
            return successMessage.getText().contains("successfully subscribed");
        } catch (Exception e) {
            return false;
        }
    }
}
