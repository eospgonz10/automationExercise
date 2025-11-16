package org.com.screenplay.project.stepdefinition;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class RegisterUserStep {

    @Before
    public void setTheStage() { OnStage.setTheStage(new OnlineCast()); }
}
