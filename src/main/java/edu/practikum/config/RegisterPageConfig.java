package edu.practikum.config;

import org.aeonbits.owner.Config;
import org.openqa.selenium.By;

import static org.aeonbits.owner.ConfigFactory.getProperty;

@Config.Sources("classpath:registerPage/registerPage.properties")
public interface RegisterPageConfig extends Config {

    @Key("registerHeader")
    default By registerHeader() {
        return By.xpath(getProperty("registerHeader"));
    }

    @Key("allFieldsRegistrationForm")
    default By allFieldsRegistrationForm() {
        return By.xpath(getProperty("allFieldsRegistrationForm"));
    }

    @Key("registerButton")
    default By registerButton() {
        return By.xpath(getProperty("registerButton"));
    }

    @Key("exceptionPassword")
    default By exceptionPassword() {
        return By.xpath(getProperty("exceptionPassword"));
    }

    @Key("buttonLogin")
    default By buttonLogin() {
        return By.linkText(getProperty("buttonLogin"));
    }
}
