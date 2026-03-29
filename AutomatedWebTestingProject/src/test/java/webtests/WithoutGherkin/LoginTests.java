package webtests.WithoutGherkin;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import webtests.pages.LoginPage;


@ExtendWith(SerenityJUnit5Extension.class)
public class LoginTests {

    @Managed
    LoginPage loginPage;

    @Test
    public void successEnterUser(){
        loginPage.open();
        loginPage.acceptConsentIfPresent();
        loginPage.enterEmailLogin("Rafiduddin18@gmail.com");
        loginPage.enterPass("zxcvasdf123");
        loginPage.loginButton();


        MatcherAssert.assertThat(
                loginPage.isLogoutVisible(),
                Matchers.is(true)
        );

    }

}
