package org.com.screenplay.project.stepdefinition;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.util.EnvironmentVariables;
import org.com.screenplay.project.questions.CartContainsProducts;
import org.com.screenplay.project.questions.ProductAddedToCart;
import org.com.screenplay.project.tasks.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.com.screenplay.project.utils.Constants.USER_EMAIL;
import static org.com.screenplay.project.utils.Constants.USER_PASSWORD;
import static org.hamcrest.Matchers.is;

/**
 * Step Definitions para productos y carrito.
 */
public class ProductsStep {

    private static EnvironmentVariables environmentVariables;

    @Cuando("el cliente agrega el primer producto al carrito")
    public void elClienteAgregaElPrimerProductoAlCarrito() {
        theActorInTheSpotlight().attemptsTo(
                NavigateToProducts.page(),
                AddProductsToCart.firstProduct(),
                ViewCart.page()
        );
    }

    @Cuando("el cliente navega a la sección de productos")
    public void elClienteNavegaALaSeccionDeProductos() {
        theActorInTheSpotlight().attemptsTo(
                NavigateToProducts.page()
        );
    }

    @Y("agrega el primer producto al carrito")
    public void agregaElPrimerProductoAlCarrito() {
        theActorInTheSpotlight().attemptsTo(
                AddProductsToCart.firstProduct()
        );
    }

    @Y("agrega un producto y va al carrito")
    public void agregaUnProductoYVaAlCarrito() {
        theActorInTheSpotlight().attemptsTo(
                AddProductsToCart.firstProduct(),
                ViewCart.page()
        );
    }

    @Y("agrega el segundo producto al carrito")
    public void agregaElSegundoProductoAlCarrito() {
        theActorInTheSpotlight().attemptsTo(
                AddProductsToCart.secondProduct()
        );
    }

    @Y("visualiza el carrito de compras")
    public void visualizaElCarritoDeCompras() {
        theActorInTheSpotlight().attemptsTo(
                ViewCart.page()
        );
    }

    @Entonces("debe ver los productos agregados en el carrito")
    public void debeVerLosProductosAgregadosEnElCarrito() {
        theActorInTheSpotlight().should(
                seeThat("el carrito contiene productos",
                        CartContainsProducts.successfully(), is(true))
        );
    }

    @Entonces("debe ver confirmación de productos agregados")
    public void debeVerConfirmacionDeProductosAgregados() {
        theActorInTheSpotlight().should(
                seeThat("el producto fue agregado",
                        ProductAddedToCart.isDisplayed(), is(true))
        );
    }

    @Y("el cliente ha iniciado sesión con credenciales válidas")
    public void elClienteHaIniciadoSesionConCredencialesValidas() {
        String email = EnvironmentSpecificConfiguration
                .from(environmentVariables)
                .getOptionalProperty(USER_EMAIL)
                .orElse("prueba1@udea.edu.co");
        
        String password = EnvironmentSpecificConfiguration
                .from(environmentVariables)
                .getOptionalProperty(USER_PASSWORD)
                .orElse("Prueba123");

        theActorInTheSpotlight().attemptsTo(
                Login.withCredentials(email, password)
        );
    }

    @Cuando("el cliente inicia sesión con email {string} y password {string}")
    public void elClienteIniciaSesionConEmailYPassword(String email, String password) {
        theActorInTheSpotlight().attemptsTo(
                Login.withCredentials(email, password)
        );
    }

    @Cuando("el cliente inicia sesión con credenciales válidas")
    public void elClienteIniciaSesionConCredencialesValidas() {
        elClienteHaIniciadoSesionConCredencialesValidas();
    }

    @Y("tiene productos en el carrito")
    public void tieneProductosEnElCarrito() {
        theActorInTheSpotlight().attemptsTo(
                NavigateToProducts.page(),
                AddProductsToCart.firstProduct(),
                ViewCart.page()
        );
    }
}
