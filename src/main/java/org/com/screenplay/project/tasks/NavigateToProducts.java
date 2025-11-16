package org.com.screenplay.project.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.com.screenplay.project.ui.ProductsUI.*;
import static org.com.screenplay.project.utils.Constants.TIME_SHORT;

/**
 * Task para navegar a productos.
 */
public class NavigateToProducts implements Task {

    @Override
    @Step("{0} navega a la sección de productos")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_PRODUCTS),
                WaitUntil.the(BTN_PRODUCTS, isVisible())
                        .forNoMoreThan(TIME_SHORT).seconds()
        );
    }

    public static NavigateToProducts page() {
        return Tasks.instrumented(NavigateToProducts.class);
    }
}
