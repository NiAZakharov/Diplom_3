import edu.practikum.BaseScenario;
import edu.practikum.dto.ButtonLoginName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class LoginTest extends BaseScenario {

    private final TestStep testStep = new TestStep();

    @ParameterizedTest(name = "Вход через кнопку {0}")
    @EnumSource(ButtonLoginName.class)
    public void userCanLoginTest(ButtonLoginName buttonLoginName) {

        testStep
                .openAuthPage(buttonLoginName)
                .authUserFromAuthPage(user)
                .verifyHomePageIsActive();
    }
}
