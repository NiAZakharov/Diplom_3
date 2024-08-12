import com.github.javafaker.Faker;
import edu.practikum.BaseScenario;
import edu.practikum.dto.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Locale;

public class RegistrationTest extends BaseScenario {

    private final static Faker FAKER = new Faker(new Locale("ru_Ru", "RU"));
    private final TestStep testStep = new TestStep();
    private User newUser;

    @BeforeEach
    public void generateNewUserData() {
        newUser = User
                .builder()
                .email(FAKER.internet().emailAddress())
                .password(FAKER.internet().password())
                .name(FAKER.name().username())
                .build();
    }

    @Test
    public void successRegistration() {

        testStep
                .openLk()
                .goToRegisterPage()
                .registerUser(newUser)
                .authUserFromAuthPage(newUser)
                .verifyHomePageIsActive();
    }

    @Test
    public void registerWithShortPasswordTest() {
        //изменили пароль на рандомный короткий
        newUser.setPassword(RandomStringUtils.randomAlphanumeric(5));

        testStep
                .openLk()
                .goToRegisterPage()
                .registerUser(newUser)
                .verifyRegisterErrorIsActive();
    }
}
