import edu.practikum.dto.ButtonConstructEnum;
import edu.practikum.dto.ButtonLoginEnum;
import edu.practikum.dto.User;
import edu.practikum.page.HomePage;
import edu.practikum.page.LoginPage;
import edu.practikum.page.RegisterPage;
import edu.practikum.page.RestorePage;
import edu.practikum.page.UserPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.page;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestStep {

    private final LoginPage loginPage = page(LoginPage.class);
    private final HomePage homePage = page(HomePage.class);
    private final RegisterPage registerPage = page(RegisterPage.class);
    private final RestorePage restorePage = page(RestorePage.class);
    private final UserPage userPage = page(UserPage.class);


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
    public TestStep registerUserFromRegisterPage(User user) {
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
    public TestStep openAuthPage(ButtonLoginEnum buttonLoginEnum) {

        switch (buttonLoginEnum) {
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

    @Step("Клик по кнопке {0}")
    public TestStep openConstructOrderPage(ButtonConstructEnum buttonConstrEnum) {

        switch (buttonConstrEnum) {
            case CONSTRUCTOR:
                userPage.constructorButton();
                break;
            case LOGO_STELLAR_BURGER:
                userPage.logoButton();
                break;
        }
        return this;
    }


    @Step("Проверка отображения данных пользователя в личном кабинете")
    public TestStep validateUserDataOnUserPage(User user) {
        assertEquals(user.getName(), userPage.getUserName());
        assertEquals(user.getEmail(), userPage.getUserLogin());
        return this;
    }

    @Step("Нажать выход в личном кабинете и проверить что отображается страница логина")
    public TestStep exitFromUserPage() {
        userPage.exitButton();
        loginPage.verifyLoginPageIsDisplayed();
        return this;
    }

    @Step("Переход на вкладку Соусы и проверка активности вкладки")
    public TestStep switchConstructSauceTab() {
        homePage
                .sectionSauceClick()
                .validateSectionSauceIsActive();
        return this;
    }

    @Step("Переход на вкладку Булки и проверка активности вкладки")
    public TestStep switchConstructBunTab() {
        homePage
                .sectionBunClick()
                .validateSectionBunIsActive();
        return this;
    }

    @Step("Переход на вкладку Начинки и проверка активности вкладки")
    public TestStep switchConstructFillingTab() {
        homePage
                .sectionFillingClick()
                .validateSectionFillingIsActive();
        return this;
    }
}
