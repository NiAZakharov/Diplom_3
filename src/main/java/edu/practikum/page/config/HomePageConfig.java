package edu.practikum.page.config;

import org.aeonbits.owner.Config;
import org.openqa.selenium.By;

@Config.Sources("classpath:homePage/homePage.properties")
public interface HomePageConfig extends Config {

    @Key("homePageHeader")
    By.ByXPath homePageHeader();

    @Key("buttonLk")
    By.ByXPath buttonLk();//Личный Кабинет

    @Key("buttonLogin")
    By.ByXPath buttonLogin();//Войти в аккаунт

    @Key("sectionBun")
    By.ByXPath sectionBun();

    @Key("sectionSauce")
    By.ByXPath sectionSauce();

    @Key("sectionFilling")
    By.ByXPath sectionFilling();

}
