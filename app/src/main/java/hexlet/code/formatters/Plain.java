package hexlet.code.formatters;

import java.util.Map;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.ArrayList;

public class Plain {
    public static String formatPlain(List<Map<String, Object>> diff) throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map<String, Object> entry: diff) {
            var valueBefore = transform(entry.get("value1"));
            var valueAfter = transform(entry.get("value2"));
            var type = entry.get("type");
            var key = entry.get("key");
            switch (type.toString()) {
                case "changed" -> {
                    stringBuilder.append("Property '").append(key).append("' was updated. From ")
                            .append(valueBefore).append(" to ").append(valueAfter).append("\n");
                }
                case "added" -> {
                    stringBuilder.append("Property '").append(key).append("' was added with value: ")
                            .append(valueAfter).append("\n");
                }
                case "deleted" -> stringBuilder.append("Property '").append(key).append("' was removed").append("\n");
                case "unchanged" -> { }
                default -> throw new Exception("Format " + type + " is not recognized");
            }
        }
        return stringBuilder.toString().trim();
    }

    public static String transform(Object value) {
        if (value instanceof ArrayList<?> || value instanceof LinkedHashMap<?, ?>) {
            return  "[complex value]";
        } else if (value instanceof String) {
            return  "'" + value + "'";
        } else if (value == null) {
            return "null";
        }
        return value.toString();
    }
}
