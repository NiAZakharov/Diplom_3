import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginTest extends BaseScenario {


    @Test
    public void check() {
        $(By.xpath(".//h2[text() = 'Регистрация']")).click();
    }
}
