package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Stylish {

    public static String formatStylish(List<Map<String, Object>> diff) {
        StringBuilder stringBuilder = new StringBuilder().append("{\n");
        for (Map<String, Object> entry: diff) {
            var value1 = valueToString(entry.get("value1"));
            var value2 = valueToString(entry.get("value2"));
            var type = entry.get("type");
            var key = entry.get("key");
            if (type == "unchanged") {
                stringBuilder.append("    ").append(key).append(": ").append(value1).append("\n");
            } else if (type == "added") {
                stringBuilder.append("  + ").append(key).append(": ").append(value2).append("\n");
            } else if (type == "deleted") {
                stringBuilder.append("  - ").append(key).append(": ").append(value1).append("\n");
            } else {
                stringBuilder.append("  - ").append(key).append(": ").append(value1).append("\n");
                stringBuilder.append("  + ").append(key).append(": ").append(value2).append("\n");
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public static String valueToString(Object value) {
        if (value == null) {
            return "null";
        } else {
            return value.toString();
        }
    }
}
