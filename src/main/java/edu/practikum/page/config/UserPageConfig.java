package edu.practikum.page.config;

import org.aeonbits.owner.Config;
import org.openqa.selenium.By;

@Config.Sources("classpath:userPage/userPage.properties")
public interface UserPageConfig extends Config {

    @Key("allUserFields")
    By.ByXPath allUserFields();

    @Key("logoButton")
    By.ByXPath logoButton();

    @Key("exitButton")
    By.ByXPath exitButton();

    @Key("constructorButton")
    By.ByLinkText constructorButton();
}
