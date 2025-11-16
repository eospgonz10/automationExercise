package org.com.screenplay.project.utils;

/**
 * Utilidad para manejo de tiempos de espera.
 */
public class Time {

    private Time() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Espera un tiempo determinado en segundos.
     * @param seconds segundos a esperar
     */
    public static void waiting(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new AssertionError("Thread interrupted during wait", e);
        }
    }
}
