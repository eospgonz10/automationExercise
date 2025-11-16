package org.com.screenplay.project.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * Mapeo de localizadores vista LOGIN.
 */
public class LoginUI {

    private LoginUI() {}

    public static final Target BTN_LOGIN = Target.the("botón Login en header")
            .located(By.xpath("//*[@href='/login']"));

    public static final Target INPUT_LOGIN_EMAIL = Target.the("campo email de login")
            .located(By.xpath("//*[@data-qa='login-email']"));

    public static final Target INPUT_LOGIN_PASSWORD = Target.the("campo password de login")
            .located(By.xpath("//*[@data-qa='login-password']"));

    public static final Target BTN_LOGIN_SUBMIT = Target.the("botón para enviar login")
            .located(By.xpath("//*[@data-qa='login-button']"));

    public static final Target TXT_LOGIN_ERROR = Target.the("mensaje de error en login")
            .locatedBy("//p[contains(text(),'Your email or password is incorrect!')]");

    public static final Target BTN_LOGOUT = Target.the("botón Logout")
            .located(By.xpath("//*[@href='/logout']"));
}
