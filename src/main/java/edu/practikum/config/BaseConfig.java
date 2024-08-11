package edu.practikum.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config.properties")
public interface BaseConfig extends Config {

    @Key("baseUrl")
    String baseUrl();
    @Key("yandexStableVersion")
    String yandexStableVersion();
    @Key("yandexBrowserPath")
    String yandexBrowserPath();

}
