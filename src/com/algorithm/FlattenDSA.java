package com.algorithm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlattenDSA {
    public static void main(String [] args){
        Map<String, Object> flatten = flatten(Map.of(
                "name", "Ismail",
                "age", 2,
                "isRetired", true,
                "category", List.of(List.of("player", Map.of("Your", "hello")), "first", "second", "third", "money", Map.of("user", "1", "frame", List.of("square", "note"))),
                "pet", Map.of("name", "ruby", "color", "white",
                        "legs", List.of("one", "two", "three", "four"))
        ));

        System.out.printf(flatten.toString());
    }

    public static Map<String, Object> flatten(Map<String, Object> obj) {
        Map<String, Object> flattened = new HashMap<>();
        flatten("", obj, flattened);
        return flattened;
    }

    private static void flatten(String prefix, Map<String, Object> source, Map<String, Object> destination) {
        for (String key : source.keySet()) {
            Object value = source.get(key);
            String prefixedKey = prefix.isEmpty() ? key : prefix + "." + key;
            if (value instanceof Map) {
                flatten(prefixedKey, (Map<String, Object>) value, destination);
            } else if (value instanceof List) {
                flatten(prefixedKey, (List<Object>) value, destination);
            }
            else {
                destination.put(prefixedKey, value.toString());
            }
        }
    }

    private static void flatten(String prefix, List<Object> source, Map<String, Object> destination) {
        for (int i = 0; i < source.size(); i++) {
            Object value = source.get(i);
            String prefixedKey = prefix + ".[" + i + "]";
            if (value instanceof Map) {
                flatten(prefixedKey, (Map<String, Object>) value, destination);
            } else if (value instanceof List) {
                flatten(prefixedKey, (List<Object>) value, destination);
            } else {
                destination.put(prefixedKey, value);
            }
        }
    }


}
