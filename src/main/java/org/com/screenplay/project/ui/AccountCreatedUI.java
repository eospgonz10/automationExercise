package org.com.screenplay.project.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * Mapeo de localizadores para la página de confirmación de cuenta creada.
 */
public class AccountCreatedUI {

    private AccountCreatedUI() {}

    public static final Target TXT_ACCOUNT_CREATED = Target.the("mensaje de cuenta creada")
            .located(By.xpath("//*[@data-qa='account-created']"));

    public static final Target BTN_CONTINUE = Target.the("botón continuar después de crear cuenta")
            .located(By.xpath("//*[@data-qa='continue-button']"));

    public static final Target TXT_CONGRATULATIONS = Target.the("mensaje de felicitaciones")
            .locatedBy("//p[contains(text(),'Congratulations')]");
}
