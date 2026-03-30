package webtests.WithoutGherkin;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import webtests.pages.CheckoutPage;
import webtests.pages.LoginPage;
import webtests.pages.ViewCartPage;


@ExtendWith(SerenityJUnit5Extension.class)
public class CheckoutTests {

    @Managed
    CheckoutPage checkoutPage;

    @Test
    public void progressToPayment() {
        checkoutPage.open();
        checkoutPage.acceptConsentIfPresent();
        checkoutPage.checkoutButton();
    }

}
