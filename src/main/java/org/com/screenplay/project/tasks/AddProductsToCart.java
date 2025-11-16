package org.com.screenplay.project.tasks;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import java.util.List;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.com.screenplay.project.ui.ProductsUI.*;
import static org.com.screenplay.project.utils.Constants.TIME_SHORT;

/**
 * Task para agregar productos al carrito.
 */
@AllArgsConstructor
public class AddProductsToCart implements Task {

    private final List<String> productIds;

    @Override
    @Step("{0} agrega productos al carrito")
    public <T extends Actor> void performAs(T actor) {
        for (String productId : productIds) {
            actor.attemptsTo(
                    Click.on(ADD_TO_CART.of(productId)),
                    WaitUntil.the(BTN_CONTINUE_SHOPPING, isVisible())
                            .forNoMoreThan(TIME_SHORT).seconds(),
                    Click.on(BTN_CONTINUE_SHOPPING)
            );
        }
    }

    public static AddProductsToCart withIds(List<String> productIds) {
        return Tasks.instrumented(AddProductsToCart.class, productIds);
    }

    public static AddProductsToCart withId(String productId) {
        return Tasks.instrumented(AddProductsToCart.class, List.of(productId));
    }
}
