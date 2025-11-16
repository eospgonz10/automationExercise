package org.com.screenplay.project.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * Mapeo de localizadores vista SIGNUP.
 */
public class SignupUI {

    private SignupUI() {}

    public static final Target INPUT_SIGNUP_NAME = Target.the("campo name del signup")
            .located(By.xpath("//*[@data-qa='signup-name']"));

    public static final Target INPUT_SIGNUP_EMAIL = Target.the("campo email del signup")
            .located(By.xpath("//*[@data-qa='signup-email']"));

    public static final Target BTN_SIGNUP = Target.the("botón de signup")
            .located(By.xpath("//*[@data-qa='signup-button']"));

    // Formulario de registro completo
    public static final Target RADIO_GENDER_MALE = Target.the("radio button género masculino")
            .located(By.xpath("//*[@id='id_gender1']"));

    public static final Target RADIO_GENDER_FEMALE = Target.the("radio button género femenino")
            .located(By.xpath("//*[@id='id_gender2']"));

    public static final Target INPUT_NAME = Target.the("campo name en formulario")
            .located(By.xpath("//*[@data-qa='name']"));

    public static final Target INPUT_EMAIL = Target.the("campo email en formulario")
            .located(By.xpath("//*[@data-qa='email']"));

    public static final Target INPUT_PASSWORD = Target.the("campo password")
            .located(By.xpath("//*[@data-qa='password']"));

    public static final Target SELECT_DAY = Target.the("select día de nacimiento")
            .located(By.xpath("//*[@data-qa='days']"));

    public static final Target SELECT_MONTH = Target.the("select mes de nacimiento")
            .located(By.xpath("//*[@data-qa='months']"));

    public static final Target SELECT_YEAR = Target.the("select año de nacimiento")
            .located(By.xpath("//*[@data-qa='years']"));

    public static final Target CHECK_NEWSLETTER = Target.the("checkbox newsletter")
            .located(By.xpath("//*[@name='newsletter']"));

    public static final Target CHECK_OFFERS = Target.the("checkbox receive offers")
            .located(By.xpath("//*[@name='optin']"));

    public static final Target INPUT_FIRST_NAME = Target.the("campo first name")
            .located(By.xpath("//*[@data-qa='first_name']"));

    public static final Target INPUT_LAST_NAME = Target.the("campo last name")
            .located(By.xpath("//*[@data-qa='last_name']"));

    public static final Target INPUT_COMPANY = Target.the("campo company")
            .located(By.xpath("//*[@data-qa='company']"));

    public static final Target INPUT_ADDRESS = Target.the("campo address")
            .located(By.xpath("//*[@data-qa='address']"));

    public static final Target SELECT_COUNTRY = Target.the("select country")
            .located(By.xpath("//*[@data-qa='country']"));

    public static final Target INPUT_STATE = Target.the("campo state")
            .located(By.xpath("//*[@data-qa='state']"));

    public static final Target INPUT_CITY = Target.the("campo city")
            .located(By.xpath("//*[@data-qa='city']"));

    public static final Target INPUT_ZIPCODE = Target.the("campo zipcode")
            .located(By.xpath("//*[@data-qa='zipcode']"));

    public static final Target INPUT_MOBILE = Target.the("campo mobile number")
            .located(By.xpath("//*[@data-qa='mobile_number']"));

    public static final Target BTN_CREATE_ACCOUNT = Target.the("botón crear cuenta")
            .located(By.xpath("//*[@data-qa='create-account']"));
}
