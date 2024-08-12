package edu.practikum.page;

import com.codeborne.selenide.Condition;
import edu.practikum.dto.User;
import edu.practikum.page.config.LoginPageConfig;
import org.aeonbits.owner.ConfigFactory;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class LoginPage {

    private final LoginPageConfig lpc = ConfigFactory.create(LoginPageConfig.class);

    public LoginPage restorePasswordClick() {
        $(lpc.restorePassword()).click();
        return this;
    }

    public LoginPage registerButtonClick() {
        $(lpc.registerButton()).click();
        return this;
    }

     public LoginPage loginButtonClick() {
        $(lpc.loginButton()).click();
        return this;
    }

     public LoginPage authorizationLoginForm(User userResponse) {
        //вводим логин и пароль
        $$(lpc.allFieldsLoginForm())
                .get(0)
                .setValue(userResponse.getEmail());
        $$(lpc.allFieldsLoginForm())
                .get(1)
                .setValue(userResponse.getPassword());
        return this;
    }

     public LoginPage getLoginHeaderText() {
        $(lpc.loginHeader()).getText();
        return this;
    }

    public LoginPage verifyLoginPageIsNotDisplayed(){
        $(lpc.loginHeader()).shouldNotBe(Condition.visible);
        return this;
    }

    public LoginPage verifyLoginPageIsDisplayed(){
        $(lpc.loginHeader()).shouldBe(Condition.visible);
        return this;
    }



}
