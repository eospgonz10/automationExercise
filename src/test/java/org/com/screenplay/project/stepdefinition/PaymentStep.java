package org.com.screenplay.project.stepdefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.com.screenplay.project.questions.OrderConfirmation;
import org.com.screenplay.project.tasks.ProceedToCheckout;
import org.com.screenplay.project.tasks.ProcessPayment;

import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.com.screenplay.project.utils.Constants.*;
import static org.hamcrest.Matchers.containsString;

/**
 * Step Definitions para proceso de pago.
 */
public class PaymentStep {

    @Cuando("el cliente completa el pago con tarjeta válida")
    public void elClienteCompletaElPagoConTarjetaValida() {
        theActorInTheSpotlight().attemptsTo(
                ProceedToCheckout.now(),
                ProcessPayment.withCardData(
                        DEFAULT_CARD_NAME,
                        DEFAULT_CARD_NUMBER,
                        DEFAULT_CARD_CVC,
                        DEFAULT_CARD_MONTH,
                        DEFAULT_CARD_YEAR
                )
        );
    }

    @Cuando("el cliente completa el pago con tarjeta {string}")
    public void elClienteCompletaElPagoConTarjeta(String tarjeta) {
        theActorInTheSpotlight().attemptsTo(
                ProceedToCheckout.now(),
                ProcessPayment.withCardData(
                        DEFAULT_CARD_NAME,
                        tarjeta,
                        DEFAULT_CARD_CVC,
                        DEFAULT_CARD_MONTH,
                        DEFAULT_CARD_YEAR
                )
        );
    }

    @Y("completa el proceso de pago")
    public void completaElProcesoDePago() {
        elClienteCompletaElPagoConTarjetaValida();
    }

    @Y("procede al checkout desde el carrito")
    public void procedeAlCheckoutDesdeElCarrito() {
        theActorInTheSpotlight().attemptsTo(
                ProceedToCheckout.now()
        );
    }

    @Y("completa el pago con tarjeta válida")
    public void completaElPagoConTarjetaValida() {
        theActorInTheSpotlight().attemptsTo(
                ProcessPayment.withCardData(
                        DEFAULT_CARD_NAME,
                        DEFAULT_CARD_NUMBER,
                        DEFAULT_CARD_CVC,
                        DEFAULT_CARD_MONTH,
                        DEFAULT_CARD_YEAR
                )
        );
    }

    @Entonces("debe ver el mensaje de confirmación de pago")
    public void debeVerElMensajeDeConfirmacionDePago() {
        theActorInTheSpotlight().should(
                seeThat("el mensaje de orden confirmada",
                        OrderConfirmation.message(), containsString(MSG_ORDER_PLACED))
        );
    }

    @Y("ha procesado el pago exitosamente")
    public void haProcesadoElPagoExitosamente() {
        elClienteCompletaElPagoConTarjetaValida();
    }
}
