package hexlet.code;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Differ {
    public static String genDiff(Map<String, Object> mapFile1, Map<String, Object> mapFile2) {
        Set<String> keys = new TreeSet<>();
        keys.addAll(mapFile1.keySet());
        keys.addAll(mapFile2.keySet());

        StringBuilder stringBuilder = new StringBuilder().append("{\n");
        for (var key: keys) {
            var value1 = valueToString(mapFile1.get(key));
            var value2 = valueToString(mapFile2.get(key));
            if (mapFile1.containsKey(key) && mapFile2.containsKey(key)) {
                keyInBothFiles(stringBuilder, key, value1, value2);
            } else if (mapFile1.containsKey(key)) {
                keyInOneFile(stringBuilder, " - ", key, value1);
            } else {
                keyInOneFile(stringBuilder, " + ", key, value2);
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
    public static void keyInBothFiles(StringBuilder stringBuilder, String key, String value1, String value2) {
        if (value1.equals(value2)) {
            addLine(stringBuilder, "   ", key, value1);
        } else {
            addLine(stringBuilder, " - ", key, value1);
            addLine(stringBuilder, " + ", key, value2);
        }
    }
    public static void keyInOneFile(StringBuilder stringBuilder, String tag, String key, String value) {
        addLine(stringBuilder, tag, key, value);
    }
    public static void addLine(StringBuilder stringBuilder, String tag, String key, String value) {
        stringBuilder.append(tag).append(key).append(": ").append(value).append("\n");
    }
    public static String valueToString(Object value) {
        if (value == null) {
            return "null";
        } else {
            return value.toString();
        }
    }
}
