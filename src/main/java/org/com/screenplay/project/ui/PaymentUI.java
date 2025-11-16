package org.com.screenplay.project.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * Mapeo de localizadores vista PAGO.
 */
public class PaymentUI {

    private PaymentUI() {}

    public static final Target INPUT_NAME_ON_CARD = Target.the("campo nombre en tarjeta")
            .located(By.xpath("//*[@data-qa='name-on-card']"));

    public static final Target INPUT_CARD_NUMBER = Target.the("campo número de tarjeta")
            .located(By.xpath("//*[@data-qa='card-number']"));

    public static final Target INPUT_CVC = Target.the("campo CVC")
            .located(By.xpath("//*[@data-qa='cvc']"));

    public static final Target INPUT_EXPIRY_MONTH = Target.the("campo mes de expiración")
            .located(By.xpath("//*[@data-qa='expiry-month']"));

    public static final Target INPUT_EXPIRY_YEAR = Target.the("campo año de expiración")
            .located(By.xpath("//*[@data-qa='expiry-year']"));

    public static final Target BTN_PAY = Target.the("botón pagar y confirmar orden")
            .located(By.xpath("//*[@data-qa='pay-button']"));
}
