package edu.practikum;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import edu.practikum.dto.User;
import edu.practikum.page.config.BaseConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Locale;
import java.util.Optional;

import static io.restassured.RestAssured.given;

public class BaseScenario {

    private final static Faker FAKER = new Faker(new Locale("ru_Ru", "RU"));
    protected static RequestSpecification requestSpecification;

    private final BaseConfig config = ConfigFactory.create(BaseConfig.class);
    private final String URL = config.baseUrl();
    private final String YANDEX_BROWSER_PATH = config.yandexBrowserPath();
    private final String YANDEX_STABLE_VERSION = config.yandexStableVersion();

    protected User user;
    //    protected Response response;
    private String token;


    @BeforeEach
    public void initialize() {

        String browser = Optional.ofNullable(System.getProperty("browser")).orElse("chrome");

        switch (browser.toLowerCase()) {
            case "yandex":
                WebDriverManager.chromedriver().driverVersion(YANDEX_STABLE_VERSION).setup();
                ChromeOptions yandexOptions = new ChromeOptions();
                yandexOptions.setBinary(YANDEX_BROWSER_PATH);
                yandexOptions.addArguments("--remote-allow-origins=*");
                Configuration.browser = "chrome";
                Configuration.browserCapabilities = yandexOptions;
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                Configuration.browser = "firefox";
                Configuration.browserCapabilities = firefoxOptions;
                break;
            case "chrome":
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                Configuration.browser = "chrome";
                Configuration.browserCapabilities = chromeOptions;
                break;
        }

        Configuration.headless = Optional.ofNullable(System.getProperty("headless"))
                .map(Boolean::parseBoolean)
                .orElse(false);
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Selenide.open(URL);

        requestSpecification = RestAssured
                .given()
                .baseUri(config.baseUrl())
                .basePath(config.baseApiPath())
                .contentType(ContentType.JSON).accept(ContentType.JSON)
                .filter(new AllureRestAssuredFilter())
                .log().all();

        RestAssured.requestSpecification = requestSpecification;

        user = createUniqueUser();
    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWindow();

        if (user != null) {
            deleteUser(user);
        }
    }

    @Step(value = "Удаление пользователя/Очистка данных")
    public Response deleteUser(User userResponse) {

        User deleteUser = User
                .builder()
                .email(userResponse.getEmail())
                .password(userResponse.getPassword())
                .name(userResponse.getName())
                .build();

        return given()
                .header("Authorization", token)
                .body(deleteUser)
                .when()
                .delete(config.userDeletePath());
    }

    @Step(value = "Создание нового уникального пользователя")
    public User createUniqueUser() {
        User newUser = User
                .builder()
                .email(FAKER.internet().emailAddress())
                .password(FAKER.internet().password())
                .name(FAKER.name().username())
                .build();

        token = given()
                .body(newUser)
                .when()
                .post(config.userRegisterPath()).header("Authorization");

        return newUser;
    }
}