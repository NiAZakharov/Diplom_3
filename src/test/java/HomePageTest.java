import edu.practikum.page.HomePage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class HomePageTest {
    @Test
    public void testSearch() {
        HomePage homePage = new HomePage();
        open("https://example.com");

        homePage.searchInput.setValue("Selenide").pressEnter();
        // Ваши проверки здесь
    }
}
