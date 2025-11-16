package org.com.screenplay.project.stepdefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.actions.Click;
import org.com.screenplay.project.questions.AccountCreated;
import org.com.screenplay.project.questions.UserIsLoggedIn;
import org.com.screenplay.project.tasks.SignUp;

import java.util.Map;

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

    @Cuando("el cliente accede a la opción {string}")
    public void elClienteAccedeALaOpcion(String opcion) {
        theActorInTheSpotlight().attemptsTo(
                Click.on(BTN_LOGIN)
        );
    }

    @Y("completa el formulario inicial con nombre {string} y email único")
    public void completaElFormularioInicialConNombreYEmailUnico(String nombre) {
        tempName = nombre;
        tempEmail = nombre.toLowerCase() + System.currentTimeMillis() + "@test.com";
        tempPassword = "Test123!";
    }

    @Y("completa el formulario de registro con los siguientes datos:")
    public void completaElFormularioDeRegistroConLosSiguientesDatos(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);

        theActorInTheSpotlight().attemptsTo(
                SignUp.withUserData(
                        tempName,
                        tempEmail,
                        data.getOrDefault("Contraseña", tempPassword),
                        data.getOrDefault("Género", "Male"),
                        data.getOrDefault("Día", "15"),
                        data.getOrDefault("Mes", "January"),
                        data.getOrDefault("Año", "1990"),
                        Boolean.parseBoolean(data.getOrDefault("Newsletter", "false")),
                        Boolean.parseBoolean(data.getOrDefault("Ofertas", "false")),
                        data.getOrDefault("Nombre", "John"),
                        data.getOrDefault("Apellido", "Doe"),
                        data.getOrDefault("Compañía", ""),
                        data.getOrDefault("Dirección", "123 Main St"),
                        data.getOrDefault("País", "United States"),
                        data.getOrDefault("Estado", "California"),
                        data.getOrDefault("Ciudad", "New York"),
                        data.getOrDefault("Código postal", "10001"),
                        data.getOrDefault("Teléfono", "1234567890")
                )
        );
    }

    @Y("completa el formulario inicial con nombre {string} y email {string}")
    public void completaElFormularioInicialConNombreYEmail(String nombre, String email) {
        tempName = nombre;
        tempEmail = email + System.currentTimeMillis() + ".com";
        tempPassword = "Test123!";
    }

    @Y("completa el formulario de registro con password {string} y ciudad {string}")
    public void completaElFormularioDeRegistroConPasswordYCiudad(String password, String ciudad) {
        theActorInTheSpotlight().attemptsTo(
                SignUp.withUserData(
                        tempName,
                        tempEmail,
                        password,
                        "Male",
                        "15",
                        "January",
                        "1990",
                        true,
                        true,
                        "John",
                        "Doe",
                        "Company",
                        "123 Main St",
                        "United States",
                        "California",
                        ciudad,
                        "10001",
                        "1234567890"
                )
        );
    }

    @Entonces("el sistema debe crear la cuenta exitosamente")
    public void elSistemaDebeCrearLaCuentaExitosamente() {
        // Primero validar que el mensaje de cuenta creada aparece
        theActorInTheSpotlight().should(
                seeThat("la cuenta fue creada", AccountCreated.successfully(), is(true))
        );
    }

    @Y("debe mostrar el mensaje {string}")
    public void debeMostrarElMensaje(String mensaje) {
        // Validar que el mensaje está visible (antes de hacer clic en Continue)
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

