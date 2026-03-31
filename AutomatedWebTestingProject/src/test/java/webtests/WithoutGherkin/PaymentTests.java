package webtests.WithoutGherkin;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import webtests.pages.PaymentDonePage;
import webtests.pages.PaymentPage;


@ExtendWith(SerenityJUnit5Extension.class)
public class PaymentTests {

    @Managed
    PaymentPage paymentPage;

    @Managed
    PaymentDonePage paymentDonePage;

    @Test
    public void successPayment(){
        paymentPage.open();
        paymentPage.acceptConsentIfPresent();
        paymentPage.enterNameOnCard("Alex Staicu");
        paymentPage.enterCardNumber("1111 2222 3333 4444");
        paymentPage.enterCVC("123");
        paymentPage.enterExpiryMonth("12");
        paymentPage.enterExpiryYear("36");
        paymentPage.submitButton();

        paymentDonePage.downloadInvoice();
        paymentDonePage.continueButton();

    }

}