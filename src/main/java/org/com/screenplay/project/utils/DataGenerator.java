package org.com.screenplay.project.utils;

import com.github.javafaker.Faker;
import java.util.Locale;

/**
 * Utilidad para generación de datos aleatorios con Faker.
 */
public class DataGenerator {

    private static final Faker FAKER = new Faker(Locale.forLanguageTag("es-CO"));

    private DataGenerator() {
        throw new IllegalStateException("Utility class");
    }

    public static String generateEmail() {
        return FAKER.internet().emailAddress();
    }

    public static String generateName() {
        return FAKER.name().firstName();
    }

    public static String generateLastName() {
        return FAKER.name().lastName();
    }

    public static String generatePhoneNumber() {
        return FAKER.phoneNumber().phoneNumber();
    }

    public static String generateCity() {
        return FAKER.address().city();
    }

    public static String generateAddress() {
        return FAKER.address().streetAddress();
    }

    public static String generateZipCode() {
        return FAKER.address().zipCode();
    }

    public static String generateCompany() {
        return FAKER.company().name();
    }
}
