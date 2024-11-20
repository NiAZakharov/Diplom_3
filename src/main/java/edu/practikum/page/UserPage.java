package edu.practikum.page;

import edu.practikum.page.config.UserPageConfig;
import org.aeonbits.owner.ConfigFactory;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class UserPage {
    private final UserPageConfig upc = ConfigFactory.create(UserPageConfig.class);

    public UserPage constructorButton() {
        $(upc.constructorButton()).click();
        return this;
    }

    public UserPage logoButton() {
        $(upc.logoButton()).click();
        return this;
    }

    public UserPage exitButton() {
        $(upc.exitButton()).click();
        return this;
    }

    public String getUserName() {
        return $$(upc.allUserFields())
                .get(0)
                .getValue();
    }

    public String getUserLogin() {
        return $$(upc.allUserFields())
                .get(1)
                .getValue();
    }
}
