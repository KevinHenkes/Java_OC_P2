package com.hemebiotech.analytics.service;

import java.util.Map;
import java.util.TreeMap;

import com.hemebiotech.analytics.utility.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.utility.WriteSymptomDataToFile;

public class SymptomService {
    /**
     * Path for input symptom data.
     */
    private String pathInput;
    /**
     * Path for output symptom results.
     */
    private String pathOutput;

    /**
     * Initialisation of symptom service with an path of input file and the path
     * for output results.
     *
     * @param pathI
     * @param pathO
     */
    public SymptomService(final String pathI, final String pathO) {
        super();
        this.pathInput = pathI;
        this.pathOutput = pathO;
    }

    /**
     * Count the symptoms in a input file and write results to an output file.
     */
    public void countSymptoms() {
        Map<String, Integer> result = new TreeMap<>();

        new ReadSymptomDataFromFile(pathInput)
        .getSymptoms()
        .forEach(symptom -> {
            int count = result.containsKey(symptom) ? result.get(symptom) : 0;
            count++;
            result.put(symptom, count);
        });
        
        new WriteSymptomDataToFile(pathOutput).writeToFile(result);
    }
}
