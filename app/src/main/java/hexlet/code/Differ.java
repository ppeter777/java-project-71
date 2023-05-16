package hexlet.code;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

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
            if (mapFile1.containsKey(key) && mapFile2.containsKey(key)) {
                if (valueToString(value1).equals(valueToString(value2))) {
                    diffLine.add("unchanged");
                    diffLine.add(value1);
                    diffLine.add(value2);
                } else {
                    diffLine.add("changed");
                    diffLine.add(value1);
                    diffLine.add(value2);
                }
            } else if (!mapFile2.containsKey(key)) {
                diffLine.add("deleted");
                diffLine.add(value1);
                diffLine.add(null);
            } else {
                diffLine.add("added");
                diffLine.add(null);
                diffLine.add(value2);
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
