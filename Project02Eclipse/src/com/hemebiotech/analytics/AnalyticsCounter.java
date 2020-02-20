package com.hemebiotech.analytics;

import com.hemebiotech.analytics.constant.Config;
import com.hemebiotech.analytics.service.SymptomService;

/**
 * Counts the symptoms of patients.
 *
 */
public final class AnalyticsCounter {
    /**
     * Service for process symptom calcul.
     */
    private static SymptomService symptomService = new SymptomService(
            Config.PATH_INPUT_DATA,
            Config.PATH_OUTPUT
            );;
    /**
     * Launch method of the program.
     * @param args
     */
    public static void main(final String[] args) {
        symptomService.countSymptoms();
    }

    private AnalyticsCounter() { }
}
