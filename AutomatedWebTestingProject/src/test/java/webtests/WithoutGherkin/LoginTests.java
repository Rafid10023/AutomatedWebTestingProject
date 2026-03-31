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
public class LoginTests {

    @Managed
    HomePageRafid loginPage;

    @Test
    public void successEnterUser() {
        loginPage.open();
        loginPage.acceptConsentIfPresent();
        loginPage.enterEmailLogin("Rafiduddin18@gmail.com");
        loginPage.enterPass("sdfighoias");
        loginPage.clickLoginButton();
        loginPage.getErrorMessage();
        loginPage.enterSubscriptionEmail("rafiduddin18@gmail.com");
        loginPage.clickSubscribeButton();


        MatcherAssert.assertThat(
                loginPage.didSubscriptionSucceed(),
                Matchers.is(true)
        );

            MatcherAssert.assertThat(loginPage.getErrorMessage(), Matchers.is("Your email or password is incorrect!"));

    }


    @Test
    public void logoutTest(){
        // Step 1: Login
        loginPage.open();
        loginPage.acceptConsentIfPresent();

        loginPage.enterEmailLogin("Rafiduddin18@gmail.com");
        loginPage.enterPass("zxcvasdf123");
        loginPage.clickLoginButton();

        // Step 2: Logout
        loginPage.clickLogout();

        // Step 3: Verify user is logged out
        MatcherAssert.assertThat(
                loginPage.isLoginFieldVisible(),
                Matchers.is(true)
        );
    }
}
