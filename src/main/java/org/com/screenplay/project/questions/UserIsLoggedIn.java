package org.com.screenplay.project.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

import static org.com.screenplay.project.ui.LoginUI.BTN_LOGOUT;

/**
 * Question para verificar si el usuario está logueado.
 */
public class UserIsLoggedIn implements Question<Boolean> {

    @Override
    @Subject("el estado de login del usuario")
    public Boolean answeredBy(Actor actor) {
        return BTN_LOGOUT.resolveFor(actor).isVisible();
    }

    public static UserIsLoggedIn successfully() {
        return new UserIsLoggedIn();
    }
}
