package edu.practikum.config;

import org.aeonbits.owner.Config;
import org.openqa.selenium.By;

import static org.aeonbits.owner.ConfigFactory.getProperty;

@Config.Sources("classpath:userPage/userPage.properties")
public interface UserPageConfig extends Config {

    @Key("profileButton")
    default By profileButton() {
        return By.xpath(getProperty("profileButton"));
    }

    @Key("allUserFields")
    default By allUserFields() {
        return By.xpath(getProperty("allUserFields"));
    }

    @Key("logoButton")
    default By logoButton() {
        return By.xpath(getProperty("logoButton"));
    }

    @Key("exitButton")
    default By exitButton() {
        return By.xpath(getProperty("exitButton"));
    }

    @Key("constructorButton")
    default By constructorButton() {
        return By.linkText(getProperty("constructorButton"));
    }
}
