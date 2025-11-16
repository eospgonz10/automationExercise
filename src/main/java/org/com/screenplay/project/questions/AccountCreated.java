package org.com.screenplay.project.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

import static org.com.screenplay.project.ui.AccountCreatedUI.TXT_ACCOUNT_CREATED;

/**
 * Question para verificar si la cuenta fue creada exitosamente.
 */
public class AccountCreated implements Question<Boolean> {

    @Override
    @Subject("el mensaje de cuenta creada")
    public Boolean answeredBy(Actor actor) {
        return TXT_ACCOUNT_CREATED.resolveFor(actor).isVisible();
    }

    public static AccountCreated successfully() {
        return new AccountCreated();
    }
}
