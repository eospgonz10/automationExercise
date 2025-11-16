package org.com.screenplay.project.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.com.screenplay.project.ui.ProductsUI.BTN_VIEW_CART;
import static org.com.screenplay.project.utils.Constants.TIME_SHORT;

/**
 * Task para ver el carrito de compras.
 */
public class ViewCart implements Task {

    @Override
    @Step("{0} visualiza el carrito de compras")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_VIEW_CART),
                WaitUntil.the(BTN_VIEW_CART, isVisible())
                        .forNoMoreThan(TIME_SHORT).seconds()
        );
    }

    public static ViewCart page() {
        return Tasks.instrumented(ViewCart.class);
    }
}
