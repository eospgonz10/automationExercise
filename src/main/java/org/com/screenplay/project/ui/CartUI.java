package org.com.screenplay.project.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * Mapeo de localizadores vista CARRITO.
 * Cumple con principio de responsabilidad única (SRP).
 */
public class CartUI {

    private CartUI() {}

    public static final Target BTN_CHECKOUT = Target.the("botón checkout")
            .located(By.xpath("//*[@class='btn btn-default check_out']"));

    public static final Target BTN_PROCEED_TO_CHECKOUT = Target.the("botón proceder al checkout")
            .located(By.xpath("//*[contains(text(),'Proceed To Checkout')]"));

    public static final Target TABLE_CART_PRODUCTS = Target.the("tabla de productos en carrito")
            .located(By.id("cart_info_table"));
}
