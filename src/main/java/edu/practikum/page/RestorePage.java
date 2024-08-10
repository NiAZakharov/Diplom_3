package edu.practikum.page;

import edu.practikum.page.config.RestorePageConfig;
import org.aeonbits.owner.ConfigFactory;

import static com.codeborne.selenide.Selenide.$;

public class RestorePage {
    private final RestorePageConfig rpc = ConfigFactory.create(RestorePageConfig.class);

    public RestorePage buttonLogin() {
        $(rpc.loginButton()).click();
        return this;
    }
}
