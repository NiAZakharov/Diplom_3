import edu.practikum.BaseScenario;
import edu.practikum.dto.ButtonConstructEnum;
import io.qameta.allure.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@DisplayName("Переходы по страницам")
public class TransitionPageTest extends BaseScenario {

    private final TestStep testStep = new TestStep();

    @BeforeEach
    public void getExistUser() {
        user = createUniqueUser();
    }

    @Test
    @DisplayName("Переход в личный кабинет")
    @Description("Переход в личный кабинет")
    public void transitionPersonalPageTest() {

        testStep
                .openLk()
                .authUserFromAuthPage(user)
                .openLk()
                .validateUserDataOnUserPage(user);
    }

    @Test
    @DisplayName("Выход из личного кабинета")
    @Description("Выход из личного кабинета")
    public void transitionExitPersonalPageTest() {

        testStep
                .openLk()
                .authUserFromAuthPage(user)
                .openLk()
                .exitFromUserPage();
    }

    @ParameterizedTest(name = "Вход через кнопку {0}")
    @DisplayName("Переход из личного кабинета в конструктор заказов {0}")
    @Description("Переход из личного кабинета в конструктор заказов {0}")
    @EnumSource(ButtonConstructEnum.class)
    public void transitionConstructorPageTest(ButtonConstructEnum buttonConstrEnum) {
        testStep
                .openLk()
                .authUserFromAuthPage(user)
                .openLk()
                .openConstructOrderPage(buttonConstrEnum)
                .verifyHomePageIsActive();
    }

    @Test
    @DisplayName("Переключение по вкладкам в конструкторе")
    @Description("Переключение по вкладкам в конструкторе")
    public void switchConstructTabsTest() {
        //проверка что переключение произошло -  внутри шагов
        testStep
                .switchConstructSauceTab()
                .switchConstructFillingTab()
                .switchConstructBunTab();
    }
}
