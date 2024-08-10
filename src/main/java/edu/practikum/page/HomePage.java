package edu.practikum.page;

import com.codeborne.selenide.SelenideElement;
import edu.practikum.config.HomePageConfig;
import org.aeonbits.owner.ConfigFactory;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    private final HomePageConfig config = ConfigFactory.create(HomePageConfig.class);

    public SelenideElement title = $(config.homePageHeader());
    public SelenideElement searchInput = $(config.buttonLk());

}
