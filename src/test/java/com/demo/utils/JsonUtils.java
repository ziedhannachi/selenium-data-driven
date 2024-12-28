package com.demo.utils;

import java.io.FileReader;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonUtils {
    /**
     * Reads data from a JSON file and returns it as a JsonObject.
     *
     * @param filePath Path to the JSON file.
     * @return JsonObject containing parsed data.
     */
    public static JsonObject readJsonFile(String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            return JsonParser.parseReader(reader).getAsJsonObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error reading JSON file: " + filePath);
        }
    }

    /**
     * Retrieves a specific value as a string from the JSON file.
     *
     * @param jsonObject Parsed JsonObject.
     * @param key        The key to retrieve.
     * @return Value as a string.
     */
    public static String getValue(JsonObject jsonObject, String key) {
        return jsonObject.get(key).getAsString();
    }
}

