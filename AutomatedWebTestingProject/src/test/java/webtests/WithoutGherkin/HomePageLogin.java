package webtests.WithoutGherkin;


import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import webtests.pages.HomePageRafid;
import webtests.pages.LoginPage;


@ExtendWith(SerenityJUnit5Extension.class)
public class HomePageLogin {
    @Managed
    HomePageRafid homePage;

    @Test
    public void CheckingTheBlueShirt(){
        homePage.open();
        homePage.acceptConsentIfPresent();
        homePage.clickBlueTopViewProduct();

        MatcherAssert.assertThat(
                homePage.isCorrectProductDisplayed("Blue Top"),
                Matchers.is(true)
        );

    }
}
