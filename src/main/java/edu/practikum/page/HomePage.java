package edu.practikum.page;

import com.codeborne.selenide.Condition;
import edu.practikum.page.config.HomePageConfig;
import org.aeonbits.owner.ConfigFactory;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    private final HomePageConfig hpc = ConfigFactory.create(HomePageConfig.class);

    public HomePage loginClick() {
        $(hpc.buttonLogin()).click();
        return this;
    }
    public HomePage buttonLk() {
        $(hpc.buttonLk()).click();
        return this;
    }

    public HomePage sectionSauceClick() {
        $(hpc.sectionSauce()).click();
        return this;
    }

    public HomePage validateSectionSauceIsActive() {
        $(hpc.sectionSauce())
                .shouldHave(Condition.attributeMatching("class",hpc.nameActiveTabClassPattern()));
        return this;
    }

    public HomePage sectionBunClick() {
        $(hpc.sectionBun()).click();
        return this;
    }

    public HomePage validateSectionBunIsActive() {
        $(hpc.sectionBun())
                .shouldHave(Condition.attributeMatching("class",hpc.nameActiveTabClassPattern()));
        return this;
    }

    public HomePage sectionFillingClick() {
        $(hpc.sectionFilling()).click();
        return this;
    }

    public HomePage validateSectionFillingIsActive() {
        $(hpc.sectionFilling())
                .shouldHave(Condition.attributeMatching("class",hpc.nameActiveTabClassPattern()));
        return this;
    }

    public void verifyHomePageIsDisplayed() {
        $(hpc.homePageHeader()).shouldBe(Condition.visible);
    }
}
