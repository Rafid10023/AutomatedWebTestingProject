package webtests.WithoutGherkin;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import webtests.pages.LoginPage;
import webtests.pages.ViewCartPage;


@ExtendWith(SerenityJUnit5Extension.class)
public class ViewCartTests {

    @Managed
    ViewCartPage cartPage;

    @Test
    public void checkPageExists() {
        cartPage.open();
        cartPage.acceptConsentIfPresent();
        MatcherAssert.assertThat(
                cartPage.cartIsEmpty(),
                Matchers.is(true)
        );
    }

}
