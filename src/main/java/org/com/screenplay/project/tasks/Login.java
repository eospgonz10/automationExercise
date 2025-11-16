package org.com.screenplay.project.tasks;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.com.screenplay.project.ui.LoginUI.*;
import static org.com.screenplay.project.utils.Constants.TIME_SHORT;

/**
 * Task para realizar login.
 */
@AllArgsConstructor
public class Login implements Task {

    private final String email;
    private final String password;

    @Override
    @Step("{0} inicia sesión con email {1}")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_LOGIN),
                WaitUntil.the(INPUT_LOGIN_EMAIL, isVisible())
                        .forNoMoreThan(TIME_SHORT).seconds(),
                Enter.theValue(email).into(INPUT_LOGIN_EMAIL),
                Enter.theValue(password).into(INPUT_LOGIN_PASSWORD),
                Click.on(BTN_LOGIN_SUBMIT)
        );
    }

    public static Login withCredentials(String email, String password) {
        return Tasks.instrumented(Login.class, email, password);
    }
}
