package edu.practikum.page.config;

import org.aeonbits.owner.Config;
import org.openqa.selenium.By;

@Config.Sources("classpath:registerPage/registerPage.properties")
public interface RegisterPageConfig extends Config {

    @Key("registerHeader")
    By.ByXPath registerHeader();

    @Key("allFieldsRegistrationForm")
    By.ByXPath allFieldsRegistrationForm();

    @Key("registerButton")
    By.ByXPath registerButton();

    @Key("exceptionPassword")
    By.ByXPath exceptionPassword();

    @Key("buttonLogin")
    By.ByLinkText buttonLogin();
}
