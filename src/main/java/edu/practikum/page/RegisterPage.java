package edu.practikum.page;

import com.codeborne.selenide.Condition;
import edu.practikum.page.config.RegisterPageConfig;
import org.aeonbits.owner.ConfigFactory;

import static com.codeborne.selenide.Selenide.$;

public class RegisterPage {
    private final RegisterPageConfig rpc = ConfigFactory.create(RegisterPageConfig.class);


    public void verifyHomePageIsDisplayed() {
        $(rpc.registerHeader()).shouldBe(Condition.visible);
    }

    public RegisterPage buttonLogin() {
        $(rpc.buttonLogin()).click();
        return this;
    }
}
