package org.com.screenplay.project.stepdefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.com.screenplay.project.tasks.ProceedToCheckout;
import org.com.screenplay.project.tasks.ProcessPayment;

import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.com.screenplay.project.utils.Constants.*;

/**
 * Step Definitions para proceso de pago.
 */
public class PaymentStep {

    @Cuando("el cliente procede al checkout desde el carrito")
    public void elClienteProcedAlCheckoutDesdeElCarrito() {
        theActorInTheSpotlight().attemptsTo(
                ProceedToCheckout.now()
        );
    }

    @Y("procede al checkout desde el carrito")
    public void procedeAlCheckoutDesdeElCarrito() {
        elClienteProcedAlCheckoutDesdeElCarrito();
    }

    @Y("completa el pago con los siguientes datos de tarjeta:")
    public void completaElPagoConLosSiguientesDatosDeTarjeta(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        
        theActorInTheSpotlight().attemptsTo(
                ProcessPayment.withCardData(
                        data.getOrDefault("Nombre", DEFAULT_CARD_NAME),
                        data.getOrDefault("Número", DEFAULT_CARD_NUMBER),
                        data.getOrDefault("CVC", DEFAULT_CARD_CVC),
                        data.getOrDefault("Mes", DEFAULT_CARD_MONTH),
                        data.getOrDefault("Año", DEFAULT_CARD_YEAR)
                )
        );
    }

    @Y("completa el pago con nombre {string}, tarjeta {string}, CVC {string}")
    public void completaElPagoConNombreTarjetaCVC(String nombre, String tarjeta, String cvc) {
        theActorInTheSpotlight().attemptsTo(
                ProcessPayment.withCardData(
                        nombre,
                        tarjeta,
                        cvc,
                        DEFAULT_CARD_MONTH,
                        DEFAULT_CARD_YEAR
                )
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
        // Validación implementada en OrderConfirmationStep
    }

    @Y("ha procesado el pago exitosamente")
    public void haProcesadoElPagoExitosamente() {
        elClienteProcedAlCheckoutDesdeElCarrito();
        completaElPagoConTarjetaValida();
    }
}
