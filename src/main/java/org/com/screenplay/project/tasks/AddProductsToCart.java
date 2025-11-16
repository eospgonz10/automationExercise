package org.com.screenplay.project.tasks;

import lombok.AllArgsConstructor;
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
 * Task para agregar un producto al carrito siguiendo el flujo:
 * 1. Ver producto
 * 2. Add to cart
 * 3. Validar mensaje
 * 4. Continue shopping
 */
@AllArgsConstructor
public class AddProductsToCart implements Task {

    private final String productPosition;

    @Override
    @Step("{0} agrega producto al carrito")
    public <T extends Actor> void performAs(T actor) {
        // Paso 1: Hacer clic en "View Product"
        actor.attemptsTo(
                Click.on(BTN_VIEW_PRODUCT.of(productPosition)),
                WaitUntil.the(BTN_ADD_TO_CART_DETAIL, isVisible())
                        .forNoMoreThan(TIME_SHORT).seconds()
        );

        // Paso 2: Hacer clic en "Add to cart" en la página de detalle
        actor.attemptsTo(
                Click.on(BTN_ADD_TO_CART_DETAIL),
                WaitUntil.the(TXT_PRODUCT_ADDED_MESSAGE, isVisible())
                        .forNoMoreThan(TIME_SHORT).seconds()
        );

        // Paso 3: Esperar mensaje de confirmación (ya validado con WaitUntil)

        // Paso 4: Hacer clic en "Continue Shopping"
        actor.attemptsTo(
                Click.on(BTN_CONTINUE_SHOPPING_MODAL)
        );
    }

    public static AddProductsToCart atPosition(String position) {
        return Tasks.instrumented(AddProductsToCart.class, position);
    }

    public static AddProductsToCart firstProduct() {
        return Tasks.instrumented(AddProductsToCart.class, "3");
    }

    public static AddProductsToCart secondProduct() {
        return Tasks.instrumented(AddProductsToCart.class, "9");
    }
}
