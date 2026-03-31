package webtests.pages;


import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.ScrollTo;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.JavascriptExecutor;

import java.util.List;

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

    @FindBy(id = "susbscribe_email")
    private WebElementFacade subscriptionEmailInput;

    @FindBy(id = "subscribe")
    private WebElementFacade subscribeButton;

    @FindBy(css = "div.alert-success")
    private WebElementFacade successMessage;

    @FindBy(css = "a.add-to-cart")
    private WebElementFacade addToCartButton;

    @FindBy(css = "a[href='/view_cart']")
    private WebElementFacade viewCartLink;

    @FindBy(css = "td.cart_description h4 a")
    private WebElementFacade productNameInCart;

    @FindBy(id = "cartModal")
    private WebElementFacade cartModal;

    @FindBy(xpath = "//h4[contains(text(),'Added!')]")
    private WebElementFacade addedModalTitle;

    @FindBy(css = "button.close-modal")
    private WebElementFacade continueShoppingButton;
    @FindBy(id = "scrollUp")
    private WebElementFacade scrollUp;

    @FindBy(id = "header")
    private WebElementFacade header;

    @FindBy(xpath = "//p[text()='Men Tshirt']/ancestor::div[@class='product-image-wrapper']//a[contains(@class,'add-to-cart')]")
    private WebElementFacade menTshirtAddToCartButton;

    @FindBy(css = "td.cart_quantity button")
    private List<WebElementFacade> quantityElements;

    @FindBy(css = "#cartModal a[href='/view_cart']")
    private WebElementFacade viewCartModalLink;

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
        evaluateJavascript("window.scrollTo(0, document.body.scrollHeight);");
        subscriptionEmailInput.type(email);
    }

    public void clickSubscribeButton() {
        subscribeButton.waitUntilClickable().click();
    }

    public boolean didSubscriptionSucceed() {
        try {
            return successMessage.waitUntilVisible()
                    .containsText("successfully subscribed");
        } catch (Exception e) {
            return false;
        }
    }
    public void clickAddToCart() {

        evaluateJavascript("window.scrollBy(0, 300);");
        addToCartButton.click();
    }

    public void clickViewCart() {
        viewCartLink.click();
    }
    public boolean isBlueTopInCart() {
        return productNameInCart.getText().equalsIgnoreCase("Blue Top");
    }

    public boolean isAddToCartConfirmationDisplayed() {
        try {
            return cartModal.waitUntilVisible().isCurrentlyVisible()
                    && addedModalTitle.containsText("Added!");
        } catch (Exception e) {
            return false;
        }
    }

    public void clickContinueShopping() {
        continueShoppingButton.waitUntilClickable().click();
    }

    public void clickScrollUpButton() {
        scrollUp.click();
    }

    public boolean isHeaderVisible(){
        return header.isDisplayed();
    }
    public void clickMenTshirtAddToCart() {
        menTshirtAddToCartButton.waitUntilClickable().click();
    }

    public int getTotalQuantity() {
        int total = 0;

        for (WebElementFacade quantity : quantityElements) {
            String text = quantity.getText().trim();
            total += Integer.parseInt(text);
        }

        return total;
    }

    public void clickViewCartFromModal() {
        viewCartModalLink.waitUntilClickable().click();
    }
}

