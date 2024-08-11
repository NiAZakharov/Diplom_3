package edu.practikum.config;

import org.aeonbits.owner.Config;
import org.openqa.selenium.By;

import static org.aeonbits.owner.ConfigFactory.getProperty;

@Config.Sources("classpath:loginPage/loginPage.properties")
public interface LoginPageConfig extends Config {

    @Key("loginHeader")
    default By loginHeader() {
        return By.xpath(getProperty("loginHeader"));
    }

    @Key("allFieldsLoginForm")
    default By allFieldsLoginForm() {
        return By.xpath(getProperty("allFieldsLoginForm"));
    }

    @Key("loginButton")
    default By loginButton() {
        return By.xpath(getProperty("loginButton"));
    }

    @Key("registerButton")
    default By registerButton() {
        return By.linkText(getProperty("registerButton"));
    }

    @Key("restorePassword")
    default By restorePassword() {
        return By.linkText(getProperty("restorePassword"));
    }
}
