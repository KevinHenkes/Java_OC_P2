package com.hemebiotech.analytics.utility;

import java.util.Map;

/**
 * Anything that will write symptom data from a source.
 *
 */
public interface ISymptomWritter {
    /**
     * Write the results of symptoms occurrences into a file.
     *
     * @param results
     */
    void writeToFile(Map<String, Integer> results);
}
