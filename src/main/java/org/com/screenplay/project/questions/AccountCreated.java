package org.com.screenplay.project.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.com.screenplay.project.ui.AccountCreatedUI.TXT_ACCOUNT_CREATED;
import static org.com.screenplay.project.utils.Constants.TIME_SHORT;

/**
 * Question para verificar si la cuenta fue creada exitosamente.
 */
public class AccountCreated implements Question<Boolean> {

    @Override
    @Subject("el mensaje de cuenta creada")
    public Boolean answeredBy(Actor actor) {
        try {
            // Esperar a que el elemento sea visible antes de verificar
            actor.attemptsTo(
                    WaitUntil.the(TXT_ACCOUNT_CREATED, isVisible())
                            .forNoMoreThan(TIME_SHORT).seconds()
            );
            return TXT_ACCOUNT_CREATED.resolveFor(actor).isVisible();
        } catch (Exception e) {
            return false;
        }
    }

    public static AccountCreated successfully() {
        return new AccountCreated();
    }
}
