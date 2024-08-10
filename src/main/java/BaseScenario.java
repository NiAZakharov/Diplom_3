import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import edu.practikum.config.BaseConfig;
import edu.practikum.config.HomePageConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Optional;

public class BaseScenario {

    private final BaseConfig config = ConfigFactory.create(BaseConfig.class);
    public final String URL= config.baseUrl();
    private final String YANDEX_BROWSER_PATH = config.yandexBrowserPath();
    private final String YANDEX_STABLE_VERSION = config.yandexStableVersion();

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
        Selenide. open(URL);
    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWindow();
    }
}
