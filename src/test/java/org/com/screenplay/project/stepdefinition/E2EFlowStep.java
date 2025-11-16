package org.com.screenplay.project.stepdefinition;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.actions.Click;
import org.com.screenplay.project.tasks.AddProductsToCart;
import org.com.screenplay.project.tasks.NavigateToProducts;
import org.com.screenplay.project.tasks.SignUp;
import org.com.screenplay.project.tasks.ViewCart;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.com.screenplay.project.ui.AccountCreatedUI.BTN_CONTINUE;
import static org.com.screenplay.project.ui.LoginUI.BTN_LOGIN;

/**
 * Step Definitions para flujo E2E completo.
 */
public class E2EFlowStep {

    @Cuando("el cliente se registra con datos válidos")
    public void elClienteSeRegistraConDatosValidos() {
        String timestamp = String.valueOf(System.currentTimeMillis());
        String email = "user" + timestamp + "@test.com";

        theActorInTheSpotlight().attemptsTo(
                Click.on(BTN_LOGIN),
                SignUp.withUserData(
                        "TestUser",
                        email,
                        "Test123!",
                        "Male",
                        "15",
                        "January",
                        "1990",
                        true,
                        true,
                        "John",
                        "Doe",
                        "Tech Company",
                        "123 Main Street",
                        "United States",
                        "California",
                        "New York",
                        "10001",
                        "1234567890"
                ),
                Click.on(BTN_CONTINUE)
        );
    }

    @Y("agrega el primer producto al carrito")
    public void agregaElPrimerProductoAlCarrito() {
        theActorInTheSpotlight().attemptsTo(
                NavigateToProducts.page(),
                AddProductsToCart.firstProduct(),
                ViewCart.page()
        );
    }
}
