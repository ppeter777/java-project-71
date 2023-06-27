package hexlet.code.formatters;

import java.util.Map;
import java.util.List;

public class Plain {
    public static String formatPlain(List<Map<String, Object>> diff) throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map<String, Object> entry: diff) {
            var value1 = transform(entry.get("value1"));
            var value2 = transform(entry.get("value2"));
            var value = transform(entry.get("value"));
            var type = entry.get("type");
            var key = entry.get("key");
            switch (type.toString()) {
                case "changed" -> {
                    stringBuilder.append("Property '").append(key).append("' was updated. From ")
                            .append(value1).append(" to ").append(value2).append("\n");
                }
                case "added" -> {
                    stringBuilder.append("Property '").append(key).append("' was added with value: ")
                            .append(value).append("\n");
                }
                case "deleted" -> stringBuilder.append("Property '").append(key).append("' was removed").append("\n");
                case "unchanged" -> { }
                default -> throw new Exception("Format " + type + " is not recognized");
            }
        }
        return stringBuilder.toString().trim();
    }

    private static String transform(Object value) {
        if (value instanceof List<?> || value instanceof Map<?, ?>) {
            return  "[complex value]";
        } else if (value instanceof String) {
            return  "'" + value + "'";
        } else if (value == null) {
            return "null";
        }
        return value.toString();
    }
}
