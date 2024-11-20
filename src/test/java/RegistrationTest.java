import com.github.javafaker.Faker;
import edu.practikum.BaseScenario;
import edu.practikum.dto.User;
import io.qameta.allure.Description;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Locale;

@DisplayName("Регистрация нового пользователя")
public class RegistrationTest extends BaseScenario {

    private final static Faker FAKER = new Faker(new Locale("ru_Ru", "RU"));
    private final TestStep testStep = new TestStep();

    @BeforeEach
    public void generateNewUserData() {
        user = User
                .builder()
                .email(FAKER.internet().emailAddress())
                .password(FAKER.internet().password())
                .name(FAKER.name().username())
                .build();
    }

    @Test
    @DisplayName("Регистрация нового пользователя")
    @Description("Регистрация нового пользователя")
    public void successRegistrationTest() {

        testStep
                .openLk()
                .goToRegisterPage()
                .registerUserFromRegisterPage(user)
                .authUserFromAuthPage(user)
                .verifyHomePageIsActive();
    }

    @Test
    @DisplayName("Проверка валидации на длину пароля при регистрации")
    @Description("Проверка валидации на длину пароля при регистрации")
    public void registerWithShortPasswordTest() {
        //изменили пароль на рандомный короткий
        user.setPassword(RandomStringUtils.randomAlphanumeric(5));

        testStep
                .openLk()
                .goToRegisterPage()
                .registerUserFromRegisterPage(user)
                .verifyRegisterErrorIsActive();
    }
}
