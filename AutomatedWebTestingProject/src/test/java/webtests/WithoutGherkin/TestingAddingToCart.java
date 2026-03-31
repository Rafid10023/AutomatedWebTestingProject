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
public class TestingAddingToCart {


    HomePageRafid loginPage;
    @Test
    public void successEnterUser(){
        loginPage.open();
        loginPage.acceptConsentIfPresent();
        System.out.println("done 2");
        loginPage.clickAddToCart();
        System.out.println("done 3");

        loginPage.clickViewCart();
        System.out.println("done 4");


        MatcherAssert.assertThat(
                loginPage.isBlueTopInCart(),
                Matchers.is(true)
        );

}}
