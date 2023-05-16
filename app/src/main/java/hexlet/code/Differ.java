package hexlet.code;

import java.util.*;

public class Differ {
    public static Map<String, List<Object>> genDiff(Map<String, Object> mapFile1, Map<String, Object> mapFile2) {
        Set<String> keys = new TreeSet<>();
        keys.addAll(mapFile1.keySet());
        keys.addAll(mapFile2.keySet());
        Map<String, List<Object>> diff = new TreeMap<>();
        for (var key: keys) {
            var value1 = mapFile1.get(key);
            var value2 = mapFile2.get(key);
            List<Object> diffLine = new ArrayList<>();
            if (!mapFile1.containsKey(key)) {
                diffLine.add(null);
            } else {
                diffLine.add(valueToString(value1));
            }
            if (!mapFile2.containsKey(key)) {
                diffLine.add(null);
            } else {
                diffLine.add(valueToString(value2));
            }
            diff.put(key, diffLine);
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
