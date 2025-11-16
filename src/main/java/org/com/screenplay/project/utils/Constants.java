package org.com.screenplay.project.utils;

/**
 * Constantes centralizadas del proyecto.
 */
public class Constants {
    
    private Constants() {}

    // URLs y configuración
    public static final String WEB_URL = "environments.default.webdriver.base.url";
    public static final String TITLE_WEBSITE = "Automation Exercise";

    // Timeouts
    public static final int TIME_SHORT = 10;

    // Credenciales
    public static final String USER_EMAIL = "credentials.default.user.email";
    public static final String USER_PASSWORD = "credentials.default.user.password";

    // Mensajes de validación
    public static final String MSG_ORDER_PLACED = "ORDER PLACED!";

    // Datos de tarjeta de prueba
    public static final String DEFAULT_CARD_NAME = "John Doe";
    public static final String DEFAULT_CARD_NUMBER = "4111111111111111";
    public static final String DEFAULT_CARD_CVC = "123";
    public static final String DEFAULT_CARD_MONTH = "12";
    public static final String DEFAULT_CARD_YEAR = "2027";
}
