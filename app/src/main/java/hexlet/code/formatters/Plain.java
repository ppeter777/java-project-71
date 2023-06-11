package hexlet.code.formatters;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Plain {
    public static String formatPlain(Map<String, List<Object>> diff) throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, List<Object>> item : diff.entrySet()) {
            String key = item.getKey();
            Object value1Obj = item.getValue().get(1);
            String value1 = transform(value1Obj);
            Object value2Obj = item.getValue().get(2);
            String value2 = transform(value2Obj);
            String tag = item.getValue().get(0).toString();

            switch (tag) {
                case "changed" -> {
                    stringBuilder.append("Property '").append(key).append("' was updated. From ")
                            .append(value1).append(" to ").append(value2).append("\n");
                }
                case "added" -> {
                    stringBuilder.append("Property '").append(key).append("' was added with value: ")
                            .append(value2).append("\n");
                }
                case "deleted" -> stringBuilder.append("Property '").append(key).append("' was removed").append("\n");
                case "unchanged" -> { }
                default -> throw new Exception("Format " + tag + " is not recognized");
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
