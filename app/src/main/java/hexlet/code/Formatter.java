package hexlet.code;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Formatter {
    public static String formatStylish(Map<String, List<Object>> diff) {
        final var unchanged = "unchanged";
        final var changed = "changed";
        final var added = "added";
        final var deleted = "deleted";

        StringBuilder stringBuilder = new StringBuilder().append("{\n");
        for (Map.Entry<String, List<Object>> item: diff.entrySet()) {
            var key = item.getKey();
            var value1 = item.getValue().get(1);
            var value2 = item.getValue().get(2);
            var tag = valueToString(item.getValue().get(0));
            switch (tag) {
                case changed -> {
                    addLine(stringBuilder, " - ", key, valueToString(value1));
                    addLine(stringBuilder, " + ", key, valueToString(value2));
                }
                case unchanged -> addLine(stringBuilder, "   ", key, valueToString(value1));
                case added -> addLine(stringBuilder, " + ", key, valueToString(value2));
                case deleted -> addLine(stringBuilder, " - ", key, valueToString(value1));
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public static String formatPlain(Map<String, List<Object>> diff) {
        final var changed = "changed";
        final var added = "added";
        final var deleted = "deleted";
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, List<Object>> item: diff.entrySet()) {
            var key = item.getKey();
            var value1 = item.getValue().get(1);
            var value2 = item.getValue().get(2);
            if (value1 instanceof ArrayList<?> || value1 instanceof LinkedHashMap<?,?>) {
                value1 = "[complex value]";
            }
            if (value2 instanceof ArrayList<?> || value2 instanceof LinkedHashMap<?,?>) {
                value2 = "[complex value]";
            }
            var tag = valueToString(item.getValue().get(0));
            switch (tag) {
                case changed -> {
                    stringBuilder.append("Property '").append(key).append("' was updated. From ").append(value1).append(" to ").append(value2).append("\n");
                }
                case added -> stringBuilder.append("Property '").append(key).append("' was added with value: ").append(value2).append("\n");
                case deleted -> stringBuilder.append("Property '").append(key).append("' was removed").append("\n");
            }
        }
        return stringBuilder.toString();
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
