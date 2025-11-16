package org.com.screenplay.project.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Runner para ejecutar flujo E2E completo.
 * Configurado para ejecución paralela y reportes Serenity.
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/e2e_complete_flow.feature",
        glue = "org.com.screenplay.project.stepdefinition",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = {"pretty", "json:target/cucumber-reports/e2e-flow.json"},
        tags = "@e2e"
)
public class RunnerE2EFlow {
}
