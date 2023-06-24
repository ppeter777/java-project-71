package hexlet.code;

import java.util.*;

public class GenDiff {
    public static List<Map<String, Object>> genDiff(Map<String, Object> parsedFile1, Map<String, Object> parsedFile2) {
        List<Map<String, Object>> diff = new ArrayList<>();
        Set<String> keys = new TreeSet<>();
        keys.addAll(parsedFile1.keySet());
        keys.addAll(parsedFile2.keySet());

        for (var key : keys) {
            Map<String, Object> diffLine = new LinkedHashMap<>();
            var value1 = parsedFile1.get(key);
            var value2 = parsedFile2.get(key);
            diffLine.put("key", key);
            if (!parsedFile1.containsKey(key)) {
                diffLine.put("type", "added");
                diffLine.put("value2", value2);
            } else if (!parsedFile2.containsKey(key)) {
                diffLine.put("type", "deleted");
                diffLine.put("value1", value1);
            } else if (isEqual(value1, value2)) {
                diffLine.put("type", "unchanged");
                diffLine.put("value1", value1);
            } else {
                diffLine.put("type", "changed");
                diffLine.put("value1", value1);
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

    public static Boolean isEqual(Object value1, Object value2) {
        if (value1 != null) {
            return value1.equals(value2);
        }
        return value2 == null;
    }
}
