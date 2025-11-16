package org.com.screenplay.project.tasks;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.com.screenplay.project.ui.PaymentUI.*;
import static org.com.screenplay.project.utils.Constants.TIME_SHORT;

/**
 * Task para procesar el pago.
 */
@AllArgsConstructor
public class ProcessPayment implements Task {

    private final String nameOnCard;
    private final String cardNumber;
    private final String cvc;
    private final String expiryMonth;
    private final String expiryYear;

    @Override
    @Step("{0} procesa el pago con tarjeta")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(INPUT_NAME_ON_CARD, isVisible())
                        .forNoMoreThan(TIME_SHORT).seconds(),
                Enter.theValue(nameOnCard).into(INPUT_NAME_ON_CARD),
                Enter.theValue(cardNumber).into(INPUT_CARD_NUMBER),
                Enter.theValue(cvc).into(INPUT_CVC),
                Enter.theValue(expiryMonth).into(INPUT_EXPIRY_MONTH),
                Enter.theValue(expiryYear).into(INPUT_EXPIRY_YEAR),
                Scroll.to(BTN_PAY),
                WaitUntil.the(BTN_PAY, isVisible()).forNoMoreThan(TIME_SHORT).seconds(),
                Click.on(BTN_PAY)
        );
    }

    public static ProcessPayment withCardData(String nameOnCard, String cardNumber,
                                                String cvc, String expiryMonth, String expiryYear) {
        return Tasks.instrumented(ProcessPayment.class, nameOnCard, cardNumber,
                cvc, expiryMonth, expiryYear);
    }
}
