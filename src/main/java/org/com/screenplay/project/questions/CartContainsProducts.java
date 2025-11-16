package org.com.screenplay.project.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

import static org.com.screenplay.project.ui.CartUI.TABLE_CART_PRODUCTS;

/**
 * Question para verificar que el carrito contiene productos.
 */
public class CartContainsProducts implements Question<Boolean> {

    @Override
    @Subject("la presencia de productos en el carrito")
    public Boolean answeredBy(Actor actor) {
        return TABLE_CART_PRODUCTS.resolveFor(actor).isVisible();
    }

    public static CartContainsProducts successfully() {
        return new CartContainsProducts();
    }
}
