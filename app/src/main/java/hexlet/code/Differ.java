package hexlet.code;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Differ {
    public static String genDiff(Map mapFile1, Map mapFile2) {
        Set<String> keys = new TreeSet<>();
        keys.addAll(mapFile1.keySet());
        keys.addAll(mapFile2.keySet());

        StringBuilder stringBuilder = new StringBuilder().append("{\n");
        for (var key: keys) {
            Object value1 = mapFile1.get(key);
            Object value2 = mapFile2.get(key);
            String value1String = valueToString(value1);
            String value2String = valueToString(value2);
            if (mapFile1.containsKey(key) && mapFile2.containsKey(key)) {
                keyInBothFiles(stringBuilder, key, value1String, value2String);
            } else if (mapFile1.containsKey(key)) {
                keyInOneFile(stringBuilder, " - ", key, value1String);
            } else {
                keyInOneFile(stringBuilder, " + ", key, value2String);
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
    public static void keyInBothFiles(StringBuilder stringBuilder, String key, String value1String, String value2String) {
        if (value1String.equals(value2String)) {
            addLine(stringBuilder, "   ", key, value1String);
        } else {
            addLine(stringBuilder, " - ", key, value1String);
            addLine(stringBuilder, " + ", key, value2String);
        }
    }
    public static void keyInOneFile(StringBuilder stringBuilder, String tag, String key, String valueString) {
        addLine(stringBuilder, tag, key, valueString);
    }
    public static void addLine(StringBuilder stringBuilder, String tag, String key, String valueString) {
        stringBuilder.append(tag).append(key).append(": ").append(valueString).append("\n");
    }
    public static String valueToString(Object value) {
        if (value == null) {
            return "null";
        } else {
            return value.toString();
        }
    }
}
