package org.com.screenplay.project.stepdefinition;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.actions.Click;
import org.com.screenplay.project.questions.AccountCreated;
import org.com.screenplay.project.questions.UserIsLoggedIn;
import org.com.screenplay.project.tasks.SignUp;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.com.screenplay.project.ui.AccountCreatedUI.BTN_CONTINUE;
import static org.com.screenplay.project.ui.LoginUI.BTN_LOGIN;
import static org.hamcrest.Matchers.is;

/**
 * Step Definitions para registro de usuarios.
 */
public class RegisterUserStep {

    private String tempName;
    private String tempEmail;
    private String tempPassword;

    @Cuando("el cliente completa el formulario de registro con datos válidos")
    public void elClienteCompletaElFormularioDeRegistroConDatosValidos() {
        tempName = "TestUser";
        tempEmail = "testuser" + System.currentTimeMillis() + "@test.com";
        tempPassword = "Test123!";
        
        theActorInTheSpotlight().attemptsTo(
                Click.on(BTN_LOGIN),
                SignUp.withUserData(
                        tempName, tempEmail, tempPassword,
                        "Male", "15", "January", "1990",
                        true, true,
                        "John", "Doe", "Tech Solutions",
                        "123 Main Street", "United States", "California",
                        "Los Angeles", "90001", "3001234567"
                )
        );
    }

    @Cuando("el cliente completa el registro con nombre {string} y email {string}")
    public void elClienteCompletaElRegistroConNombreYEmail(String nombre, String email) {
        tempEmail = email.replace("@", System.currentTimeMillis() + "@");
        
        theActorInTheSpotlight().attemptsTo(
                Click.on(BTN_LOGIN),
                SignUp.withUserData(
                        nombre, tempEmail, "Test123!",
                        "Male", "15", "January", "1990",
                        true, true,
                        "John", "Doe", "Company",
                        "123 Main St", "United States", "California",
                        "New York", "10001", "1234567890"
                )
        );
    }

    @Entonces("se crea la cuenta y muestra el mensaje de confirmación")
    public void seCreaLaCuentaYMuestraElMensajeDeConfirmacion() {
        // Validar que el mensaje de cuenta creada aparece
        theActorInTheSpotlight().should(
                seeThat("la cuenta fue creada", AccountCreated.successfully(), is(true))
        );
        
        // Hacer clic en Continue después de validar el mensaje
        theActorInTheSpotlight().attemptsTo(
                Click.on(BTN_CONTINUE)
        );
    }

    @Y("debe mostrar el mensaje {string}")
    public void debeMostrarElMensaje(String mensaje) {
        // Validar que el mensaje está visible
        theActorInTheSpotlight().should(
                seeThat("el mensaje de cuenta creada está visible", 
                        AccountCreated.successfully(), is(true))
        );
        
        // Después de validar el mensaje, hacer clic en Continue
        theActorInTheSpotlight().attemptsTo(
                Click.on(BTN_CONTINUE)
        );
        
        // Finalmente validar que el usuario está logueado en el dashboard
        theActorInTheSpotlight().should(
                seeThat("el usuario está logueado", UserIsLoggedIn.successfully(), is(true))
        );
    }
}

