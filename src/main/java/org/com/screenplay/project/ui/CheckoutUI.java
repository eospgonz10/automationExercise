package org.com.screenplay.project.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * Mapeo de localizadores vista CHECKOUT.
 */
public class CheckoutUI {

    private CheckoutUI() {}

    public static final Target BTN_PLACE_ORDER = Target.the("botón place order")
            .located(By.xpath("//*[@href='/payment']"));

    public static final Target TXT_ADDRESS_DETAILS = Target.the("detalles de dirección")
            .located(By.className("address_firstname"));
}
