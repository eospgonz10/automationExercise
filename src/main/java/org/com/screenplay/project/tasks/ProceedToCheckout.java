package org.com.screenplay.project.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.com.screenplay.project.ui.CartUI.BTN_CHECKOUT;
import static org.com.screenplay.project.ui.CheckoutUI.BTN_PLACE_ORDER;
import static org.com.screenplay.project.utils.Constants.TIME_SHORT;

/**
 * Task para proceder al checkout.
 */
public class ProceedToCheckout implements Task {

    @Override
    @Step("{0} procede al checkout")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_CHECKOUT),
                WaitUntil.the(BTN_PLACE_ORDER, isVisible())
                        .forNoMoreThan(TIME_SHORT).seconds(),
                Click.on(BTN_PLACE_ORDER)
        );
    }

    public static ProceedToCheckout now() {
        return Tasks.instrumented(ProceedToCheckout.class);
    }
}
