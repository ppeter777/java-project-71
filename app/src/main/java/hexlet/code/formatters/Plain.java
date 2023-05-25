package hexlet.code.formatters;

import hexlet.code.Utils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Plain {
    public static String formatPlain(Map<String, List<Object>> diff) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, List<Object>> item : diff.entrySet()) {
            var key = item.getKey();
            var value1 = item.getValue().get(1);
            var value2 = item.getValue().get(2);
            if (value1 instanceof ArrayList<?> || value1 instanceof LinkedHashMap<?, ?>) {
                value1 = "[complex value]";
            }
            if (value2 instanceof ArrayList<?> || value2 instanceof LinkedHashMap<?, ?>) {
                value2 = "[complex value]";
            }
            var tag = Utils.valueToString(item.getValue().get(0));
            switch (tag) {
                case "changed" -> {
                    stringBuilder.append("Property '").append(key).append("' was updated. From ");
                    stringBuilder.append(value1).append(" to ").append(value2).append("\n");
                }
                case "added" -> {
                    stringBuilder.append("Property '").append(key).append("' was added with value: ");
                    stringBuilder.append(value2).append("\n");
                }
                case "deleted" -> stringBuilder.append("Property '").append(key).append("' was removed").append("\n");
                default -> { }
            }
        }
        return stringBuilder.toString();
    }
}
