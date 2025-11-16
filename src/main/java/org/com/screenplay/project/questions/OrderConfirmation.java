package org.com.screenplay.project.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Text;

import static org.com.screenplay.project.ui.OrderConfirmationUI.TXT_ORDER_PLACED;

/**
 * Question para verificar que la orden fue confirmada.
 */
public class OrderConfirmation implements Question<Boolean> {

    @Override
    @Subject("la confirmación de la orden")
    public Boolean answeredBy(Actor actor) {
        return TXT_ORDER_PLACED.resolveFor(actor).isVisible();
    }

    public static OrderConfirmation isDisplayed() {
        return new OrderConfirmation();
    }

    public static Question<String> message() {
        return actor -> Text.of(TXT_ORDER_PLACED).answeredBy(actor);
    }
}
