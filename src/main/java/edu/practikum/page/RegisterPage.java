package edu.practikum.page;

import com.codeborne.selenide.Condition;
import edu.practikum.dto.User;
import edu.practikum.page.config.RegisterPageConfig;
import org.aeonbits.owner.ConfigFactory;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class RegisterPage {
    private final RegisterPageConfig rpc = ConfigFactory.create(RegisterPageConfig.class);


    public RegisterPage verifyRegisterPageIsDisplayed() {
        $(rpc.registerHeader()).shouldBe(Condition.visible);
        return this;
    }

    public RegisterPage verifyExceptionPasswordIsDisplayed() {
        $(rpc.exceptionPassword()).shouldBe(Condition.visible);
        return this;
    }

    public RegisterPage buttonLogin() {
        $(rpc.buttonLogin()).click();
        return this;
    }

    public RegisterPage buttonRegister() {
        $(rpc.registerButton()).click();
        return this;
    }

    public RegisterPage fillRegisterData(User userRegistry) {
        $$(rpc.allFieldsRegistrationForm())
                .get(0)
                .setValue(userRegistry.getName());
        $$(rpc.allFieldsRegistrationForm())
                .get(1)
                .setValue(userRegistry.getEmail());
        $$(rpc.allFieldsRegistrationForm())
                .get(2)
                .setValue(userRegistry.getPassword());
        return this;
    }
}
