package org.com.screenplay.project.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

import static org.com.screenplay.project.ui.ProductsUI.TXT_PRODUCT_ADDED_MESSAGE;

/**
 * Question para verificar si el producto fue agregado al carrito.
 */
public class ProductAddedToCart implements Question<Boolean> {

    @Override
    @Subject("el mensaje de producto agregado")
    public Boolean answeredBy(Actor actor) {
        return TXT_PRODUCT_ADDED_MESSAGE.resolveFor(actor).isVisible();
    }

    public static ProductAddedToCart isDisplayed() {
        return new ProductAddedToCart();
    }
}
