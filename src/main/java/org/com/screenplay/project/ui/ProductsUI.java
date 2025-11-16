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

    // Botón "View Product" del primer producto
    public static final Target BTN_VIEW_PRODUCT_1 = Target.the("botón ver producto 1")
            .located(By.xpath("/html/body/section[2]/div/div/div[2]/div/div[3]/div/div[2]/ul/li/a"));

    // Botón "View Product" del segundo producto
    public static final Target BTN_VIEW_PRODUCT_2 = Target.the("botón ver producto 2")
            .located(By.xpath("/html/body/section[2]/div/div/div[2]/div/div[9]/div/div[2]/ul/li/a"));

    // Botón "Add to cart" en la página de detalle del producto
    public static final Target BTN_ADD_TO_CART_DETAIL = Target.the("botón agregar al carrito en detalle")
            .located(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/button"));

    // Mensaje de confirmación "Your product has been added to cart."
    public static final Target TXT_PRODUCT_ADDED_MESSAGE = Target.the("mensaje producto agregado al carrito")
            .located(By.xpath("//*[@id='cartModal']/div/div/div[2]/p[1]"));

    // Botón "Continue Shopping" en el modal de confirmación
    public static final Target BTN_CONTINUE_SHOPPING_MODAL = Target.the("botón continuar comprando en modal")
            .located(By.xpath("//*[@id='cartModal']//button[contains(@class, 'btn-success')]"));

    public static final Target BTN_VIEW_CART = Target.the("botón ver carrito")
            .located(By.xpath("//*[@href='/view_cart']"));

    /**
     * Locator dinámico para botón "View Product" por posición.
     * Uso: BTN_VIEW_PRODUCT.of("3") para producto en posición 3
     */
    public static final Target BTN_VIEW_PRODUCT = Target.the("botón ver producto en posición {0}")
            .locatedBy("/html/body/section[2]/div/div/div[2]/div/div[{0}]/div/div[2]/ul/li/a");
}
