package edu.practikum.config;

import org.aeonbits.owner.Config;
import org.openqa.selenium.By;

import static org.aeonbits.owner.ConfigFactory.getProperty;

@Config.Sources("classpath:restorePage/restorePage.properties")
public interface RestorePageConfig extends Config {

    @Key("loginButton")
    default By loginButton() {
        return By.linkText(getProperty("loginButton"));
    }
}
