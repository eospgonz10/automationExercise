package org.com.screenplay.project.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * Mapeo de localizadores vista CONFIRMACIÓN DE ORDEN.
 */
public class OrderConfirmationUI {

    private OrderConfirmationUI() {}

    public static final Target TXT_ORDER_PLACED = Target.the("mensaje confirmación de orden")
            .located(By.xpath("//*[@data-qa='order-placed']"));

    public static final Target BTN_CONTINUE = Target.the("botón continuar")
            .located(By.xpath("//*[@data-qa='continue-button']"));

    public static final Target TXT_CONGRATULATIONS = Target.the("mensaje de felicitaciones")
            .locatedBy("//p[contains(text(),'Congratulations')]");
}
