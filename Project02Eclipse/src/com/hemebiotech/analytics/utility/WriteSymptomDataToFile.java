package com.hemebiotech.analytics.utility;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Simple file writter.
 *
 */
public class WriteSymptomDataToFile implements ISymptomWritter {
    /**
     * File path of file write.
     */
    private String filePath;

    /**
     * a full or partial path to file with symptom strings in it, one per line.
     * @param filepath
     */
    public WriteSymptomDataToFile(final String filepath) {
        this.filePath = filepath;
    }

    @Override
    public final void writeToFile(final Map<String, Integer> results) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Entry<String,Integer> symptom : results.entrySet()) {
                // Write into output file occurrences for each symptom searched
                writer.write(symptom.getKey() + ": " + symptom.getValue() + "\n");
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

}
