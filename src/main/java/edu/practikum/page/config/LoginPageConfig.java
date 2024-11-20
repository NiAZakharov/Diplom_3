package edu.practikum.page.config;

import org.aeonbits.owner.Config;
import org.openqa.selenium.By;

@Config.Sources("classpath:loginPage/loginPage.properties")
public interface LoginPageConfig extends Config {

    @Key("loginHeader")
    By.ByXPath loginHeader();

    @Key("allFieldsLoginForm")
    By.ByXPath allFieldsLoginForm();

    @Key("loginButton")
    By.ByXPath loginButton();

    @Key("registerButton")
    By.ByLinkText registerButton();

    @Key("restorePassword")
    By.ByLinkText restorePassword();

}
