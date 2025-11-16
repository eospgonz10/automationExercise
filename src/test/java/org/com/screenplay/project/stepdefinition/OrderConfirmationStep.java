package org.com.screenplay.project.stepdefinition;

import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.actions.Click;
import org.com.screenplay.project.questions.OrderConfirmation;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.com.screenplay.project.ui.OrderConfirmationUI.BTN_CONTINUE;
import static org.com.screenplay.project.ui.OrderConfirmationUI.TXT_CONGRATULATIONS;
import static org.com.screenplay.project.utils.Constants.MSG_ORDER_PLACED;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

/**
 * Step Definitions para confirmación de orden.
 */
public class OrderConfirmationStep {

    @Entonces("debe ver el mensaje {string} en la confirmación")
    public void debeVerElMensajeEnLaConfirmacion(String mensaje) {
        theActorInTheSpotlight().should(
                seeThat("el mensaje de orden confirmada",
                        OrderConfirmation.message(), containsString(mensaje))
        );
    }

    @Y("debe visualizar el botón para continuar navegando")
    public void debeVisualizarElBotonParaContinuarNavegando() {
        theActorInTheSpotlight().should(
                seeThat("el botón continuar está visible",
                        actor -> BTN_CONTINUE.resolveFor(actor).isVisible(), is(true))
        );
    }

    @Y("debe ver el mensaje de felicitaciones")
    public void debeVerElMensajeDeFelicitaciones() {
        theActorInTheSpotlight().should(
                seeThat("el mensaje de felicitaciones está visible",
                        actor -> TXT_CONGRATULATIONS.resolveFor(actor).isVisible(), is(true))
        );
    }

    @Y("puede continuar navegando en el sitio")
    public void puedeContinuarNavegandoEnElSitio() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(BTN_CONTINUE)
        );
    }

    @Y("la orden debe estar confirmada exitosamente")
    public void laOrdenDebeEstarConfirmadaExitosamente() {
        theActorInTheSpotlight().should(
                seeThat("la orden está confirmada",
                        OrderConfirmation.isDisplayed(), is(true))
        );
    }
}
