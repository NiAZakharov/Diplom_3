import edu.practikum.dto.ButtonLoginName;
import edu.practikum.dto.User;
import edu.practikum.page.HomePage;
import edu.practikum.page.LoginPage;
import edu.practikum.page.RegisterPage;
import edu.practikum.page.RestorePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.page;

public class TestStep {

    private final LoginPage loginPage = page(LoginPage.class);
    private final HomePage homePage = page(HomePage.class);
    private final RegisterPage registerPage = page(RegisterPage.class);
    private final RestorePage restorePage = page(RestorePage.class);


    @Step("Открыть личный кабинет")
    public TestStep openLk() {
        homePage.buttonLk();
        return this;
    }

    @Step("Перейти на страницу регистрации")
    public TestStep goToRegisterPage() {
        loginPage.registerButtonClick();
        return this;
    }

    @Step("Зарегистрировать нового пользователя")
    public TestStep registerUser(User user) {
        registerPage
                .verifyRegisterPageIsDisplayed()
                .fillRegisterData(user)
                .buttonRegister();
        return this;
    }

    @Step("Входим в систему пользователем")
    public TestStep authUserFromAuthPage(User user) {
        loginPage
                .verifyLoginPageIsDisplayed()
                .authorizationLoginForm(user)
                .loginButtonClick()
                .verifyLoginPageIsNotDisplayed();
        return this;
    }

    @Step("Проверка отображения главной страницы")
    public TestStep verifyHomePageIsActive() {
        homePage.verifyHomePageIsDisplayed();
        return this;
    }

    @Step("Проверка отображения главной страницы")
    public TestStep verifyRegisterErrorIsActive() {
        registerPage
                .verifyExceptionPasswordIsDisplayed()
                .verifyRegisterPageIsDisplayed();
        return this;
    }
    @Step("Клик по кнопке {0}")
    public TestStep openAuthPage(ButtonLoginName buttonLoginName) {

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
        return this;
    }

}
