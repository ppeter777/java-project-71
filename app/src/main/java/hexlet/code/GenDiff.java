package hexlet.code;

import java.util.*;

public class GenDiff {
    public static List<Map<String, Object>> genDiff(Map<String, Object> parsedFile1, Map<String, Object> parsedFile2) {
        List<Map<String, Object>> diff = new ArrayList<>();
        Set<String> keys = new TreeSet<>();
        keys.addAll(parsedFile1.keySet());
        keys.addAll(parsedFile2.keySet());

        for (var key : keys) {
            Map<String, Object> diffLine = new TreeMap<>();
            var value1 = parsedFile1.get(key);
            var value2 = parsedFile2.get(key);
            if (parsedFile1.containsKey(key) && parsedFile2.containsKey(key)) {
                if (valueToString(value1).equals(valueToString(value2))) {
                    diffLine.put("type", "unchanged");
                    diffLine.put("key", key);
                    diffLine.put("value1", value1);
                } else {
                    diffLine.put("type", "changed");
                    diffLine.put("key", key);
                    diffLine.put("value1", value1);
                    diffLine.put("value2", value2);
                }
            } else if (!parsedFile2.containsKey(key)) {
                diffLine.put("type", "deleted");
                diffLine.put("key", key);
                diffLine.put("value1", value1);
            } else {
                diffLine.put("type", "added");
                diffLine.put("key", key);
                diffLine.put("value2", value2);
            }
            diff.add(diffLine);
        }
        return diff;
    }

    public static String valueToString(Object value) {
        if (value == null) {
            return "null";
        } else {
            return value.toString();
        }
    }
}
