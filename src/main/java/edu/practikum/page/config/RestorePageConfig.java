package edu.practikum.page.config;

import org.aeonbits.owner.Config;
import org.openqa.selenium.By;

@Config.Sources("classpath:restorePage/restorePage.properties")
public interface RestorePageConfig extends Config {

    @Key("loginButton")
    By.ByLinkText loginButton();
}
