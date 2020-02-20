package com.hemebiotech.analytics.utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple file reader.
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {
    /**
     * File path of file read.
     */
    private String filePath;

    /**
     * a full or partial path to file with symptom strings in it, one per line.
     *
     * @param path
     */
    public ReadSymptomDataFromFile(final String path) {
        this.filePath = path;
    }

    @Override
    public final List<String> getSymptoms() {
        ArrayList<String> result = new ArrayList<>();

        if (filePath != null) {
            try (FileReader fr = new FileReader(filePath);
                    BufferedReader reader = new BufferedReader(fr)) {
                String line;

                while ((line = reader.readLine()) != null) {
                    result.add(line);
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }

        return result;
    }
}
