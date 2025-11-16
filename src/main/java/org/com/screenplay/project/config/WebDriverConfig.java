package org.com.screenplay.project.config;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Configuración de WebDriverManager para descarga automática de drivers.
 * Se ejecuta antes de las pruebas.
 */
public class WebDriverConfig {

    static {
        setupDrivers();
    }

    private WebDriverConfig() {
        throw new IllegalStateException("Config class");
    }

    public static void setupDrivers() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
    }
}
