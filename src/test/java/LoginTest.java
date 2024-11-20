import edu.practikum.BaseScenario;
import edu.practikum.dto.ButtonLoginEnum;
import io.qameta.allure.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@DisplayName("Авторизация пользователя")
public class LoginTest extends BaseScenario {

    private final TestStep testStep = new TestStep();

    @BeforeEach
    public void getExistUser() {
        user = createUniqueUser();
    }

    @ParameterizedTest(name = "Вход через кнопку {0}")
    @DisplayName("Авторизация используя кнопку {0}")
    @Description("Авторизация используя кнопку {0}")
    @EnumSource(ButtonLoginEnum.class)
    public void userCanLoginTest(ButtonLoginEnum buttonLoginEnum) {

        testStep
                .openAuthPage(buttonLoginEnum)
                .authUserFromAuthPage(user)
                .verifyHomePageIsActive();
    }
}
