package edu.practikum.config;

import org.aeonbits.owner.Config;
import org.openqa.selenium.By;

import static org.aeonbits.owner.ConfigFactory.getProperty;

@Config.Sources("classpath:homePage/homePage.properties")
public interface HomePageConfig extends Config {

    @Key("homePageHeader")
    default By homePageHeader() {
        return By.xpath(getProperty("homePageHeader"));
    }

    @Key("buttonLk")
    default By buttonLk() {
        return By.xpath(getProperty("buttonLk"));
    }

    @Key("buttonLogin")
    default By buttonLogin() {
        return By.xpath(getProperty("buttonLogin"));
    }

    @Key("sectionBun")
    default By sectionBun() {
        return By.xpath(getProperty("sectionBun"));
    }

    @Key("sectionSauce")
    default By sectionSauce() {
        return By.xpath(getProperty("sectionSauce"));
    }

    @Key("sectionFilling")
    default By sectionFilling() {
        return By.xpath(getProperty("sectionFilling"));
    }

}
