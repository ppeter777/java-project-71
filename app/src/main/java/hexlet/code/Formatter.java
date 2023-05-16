package hexlet.code;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String formatStylish(Map<String, List<Object>> diff) {
        StringBuilder stringBuilder = new StringBuilder().append("{\n");
        for (Map.Entry<String, List<Object>> item: diff.entrySet()) {
            var key = item.getKey();
            var value1 = item.getValue().get(0);
            var value2 = item.getValue().get(1);
            if ((item.getValue().get(0) != null) && (item.getValue().get(1) != null)) {
                keyInBothFiles(stringBuilder, key, value1, value2);
            } else if (item.getValue().get(1) == null) {
                keyInOneFile(stringBuilder, " - ", key, value1);
            } else {
                keyInOneFile(stringBuilder, " + ", key, value2);
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
    public static void keyInBothFiles(StringBuilder stringBuilder, String key, Object value1, Object value2) {
        if (value1.equals(value2)) {
            addLine(stringBuilder, "   ", key, valueToString(value1));
        } else {
            addLine(stringBuilder, " - ", key, valueToString(value1));
            addLine(stringBuilder, " + ", key, valueToString(value2));
        }
    }
    public static void keyInOneFile(StringBuilder stringBuilder, String tag, String key, Object value) {
        addLine(stringBuilder, tag, key, valueToString(value));
    }
    public static void addLine(StringBuilder stringBuilder, String tag, String key, Object value) {
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
