package org.com.screenplay.project.tasks;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.com.screenplay.project.ui.SignupUI.*;
import static org.com.screenplay.project.utils.Constants.TIME_SHORT;

/**
 * Task para registrar nuevo usuario.
 */
@AllArgsConstructor
public class SignUp implements Task {

    private final String name;
    private final String email;
    private final String password;
    private final String gender;
    private final String day;
    private final String month;
    private final String year;
    private final boolean newsletter;
    private final boolean offers;
    private final String firstName;
    private final String lastName;
    private final String company;
    private final String address;
    private final String country;
    private final String city;
    private final String zipcode;
    private final String mobile;

    @Override
    @Step("{0} completa el registro de nuevo usuario")
    public <T extends Actor> void performAs(T actor) {
        // Paso 1: Iniciar signup
        actor.attemptsTo(
                WaitUntil.the(INPUT_SIGNUP_NAME, isVisible())
                        .forNoMoreThan(TIME_SHORT).seconds(),
                Enter.theValue(name).into(INPUT_SIGNUP_NAME),
                Enter.theValue(email).into(INPUT_SIGNUP_EMAIL),
                Click.on(BTN_SIGNUP)
        );

        // Paso 2: Completar formulario de registro
        actor.attemptsTo(
                WaitUntil.the(INPUT_PASSWORD, isVisible())
                        .forNoMoreThan(TIME_SHORT).seconds()
        );

        if ("Male".equalsIgnoreCase(gender)) {
            actor.attemptsTo(Click.on(RADIO_GENDER_MALE));
        } else {
            actor.attemptsTo(Click.on(RADIO_GENDER_FEMALE));
        }

        actor.attemptsTo(
                Enter.theValue(password).into(INPUT_PASSWORD),
                SelectFromOptions.byVisibleText(day).from(SELECT_DAY),
                SelectFromOptions.byVisibleText(month).from(SELECT_MONTH),
                SelectFromOptions.byVisibleText(year).from(SELECT_YEAR)
        );

        if (newsletter) {
            actor.attemptsTo(Click.on(CHECK_NEWSLETTER));
        }

        if (offers) {
            actor.attemptsTo(Click.on(CHECK_OFFERS));
        }

        actor.attemptsTo(
                Enter.theValue(firstName).into(INPUT_FIRST_NAME),
                Enter.theValue(lastName).into(INPUT_LAST_NAME),
                Enter.theValue(company).into(INPUT_COMPANY),
                Enter.theValue(address).into(INPUT_ADDRESS),
                SelectFromOptions.byVisibleText(country).from(SELECT_COUNTRY),
                Enter.theValue(city).into(INPUT_CITY),
                Enter.theValue(zipcode).into(INPUT_ZIPCODE),
                Enter.theValue(mobile).into(INPUT_MOBILE),
                Click.on(BTN_CREATE_ACCOUNT)
        );
    }

    public static SignUp withUserData(String name, String email, String password,
                                       String gender, String day, String month, String year,
                                       boolean newsletter, boolean offers,
                                       String firstName, String lastName, String company,
                                       String address, String country, String city,
                                       String zipcode, String mobile) {
        return Tasks.instrumented(SignUp.class, name, email, password, gender,
                day, month, year, newsletter, offers, firstName, lastName,
                company, address, country, city, zipcode, mobile);
    }
}
