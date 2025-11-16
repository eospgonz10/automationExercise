package org.com.screenplay.project.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * Mapeo de localizadores vista PRODUCTOS.
 */
public class ProductsUI {

    private ProductsUI() {}

    public static final Target BTN_PRODUCTS = Target.the("botón Products en header")
            .located(By.xpath("//*[@href='/products']"));

    /**
     * Locator dinámico para agregar productos por ID.
     * Uso: ADD_TO_CART.of("1") para producto con id=1
     */
    public static final Target ADD_TO_CART = Target.the("botón agregar producto al carrito con id {0}")
            .locatedBy("//*[@data-product-id='{0}']");

    public static final Target TXT_PRODUCT_ADDED = Target.the("mensaje producto agregado")
            .locatedBy("//h4[contains(text(),'Added!')]");

    public static final Target BTN_CONTINUE_SHOPPING = Target.the("botón continuar comprando")
            .located(By.xpath("//*[@class='btn btn-success close-modal btn-block']"));

    public static final Target BTN_VIEW_CART = Target.the("botón ver carrito")
            .located(By.xpath("//*[@href='/view_cart']"));
}
