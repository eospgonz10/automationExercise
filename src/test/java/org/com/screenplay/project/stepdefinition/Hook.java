package org.com.screenplay.project.stepdefinition;

import io.cucumber.java.Before;
import io.cucumber.java.es.Dado;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import org.hamcrest.Matchers;
import org.com.screenplay.project.config.WebDriverConfig;
import org.com.screenplay.project.hook.OpenWeb;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.com.screenplay.project.utils.Constants.*;

/**
 * Step Definitions para el Hook inicial.
 */
public class Hook {

    @Before
    public void setTheStage() {

        WebDriverConfig.setupDrivers();
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("que {string} navega a la página de Automation Exercise")
    public void queNavegaALaPaginaDeAutomationExercise(String actor) {
        OnStage.theActorCalled(actor).attemptsTo(
                OpenWeb.browserURL(WEB_URL)
        );
        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(
                        TheWebPage.title(),
                        Matchers.containsString(TITLE_WEBSITE)
                )
        );
    }
}
