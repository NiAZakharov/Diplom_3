import edu.practikum.BaseScenario;
import edu.practikum.page.HomePage;
import edu.practikum.page.LoginPage;
import edu.practikum.page.RegisterPage;
import edu.practikum.page.RestorePage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static com.codeborne.selenide.Selenide.page;

public class LoginTest extends BaseScenario {

    private final LoginPage loginPage = page(LoginPage.class);
    private final HomePage homePage = page(HomePage.class);
    private final RegisterPage registerPage = page(RegisterPage.class);
    private final RestorePage restorePage = page(RestorePage.class);

    @ParameterizedTest(name="Вход через кнопку {0}")
    @EnumSource(ButtonLoginName.class)
    public void userCanLoginTest(ButtonLoginName buttonLoginName) {

        switch (buttonLoginName) {
            case HOME:
                homePage.loginClick();
                break;
            case LK:
                homePage.buttonLk();
                break;
            case REGISTER:
                homePage.buttonLk();
                loginPage.registerButtonClick();
                registerPage.buttonLogin();
                break;
            case RECOVERY:
                homePage.buttonLk();
                loginPage.restorePasswordClick();
                restorePage.buttonLogin();
                break;
        }

        loginPage
                .authorizationLoginForm(user)
                .loginButtonClick()
                .verifyLoginPageIsNotDisplayed();
        homePage.verifyHomePageIsDisplayed();
    }

    private enum ButtonLoginName {
        HOME,
        LK,
        REGISTER,
        RECOVERY
    }
}
