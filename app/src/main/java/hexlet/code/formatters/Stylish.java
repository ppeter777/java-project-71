package hexlet.code.formatters;

import hexlet.code.Utils;
import java.util.List;
import java.util.Map;

public class Stylish {
    public static String formatStylish(Map<String, List<Object>> diff) {

        StringBuilder stringBuilder = new StringBuilder().append("{\n");
        for (Map.Entry<String, List<Object>> item: diff.entrySet()) {
            var key = item.getKey();
            var value1 = item.getValue().get(1);
            var value2 = item.getValue().get(2);
            var tag = Utils.valueToString(item.getValue().get(0));
            switch (tag) {
                case "changed" -> {
                    addLine(stringBuilder, "  - ", key, Utils.valueToString(value1));
                    addLine(stringBuilder, "  + ", key, Utils.valueToString(value2));
                }
                case "unchanged" -> addLine(stringBuilder, "    ", key, Utils.valueToString(value1));
                case "added" -> addLine(stringBuilder, "  + ", key, Utils.valueToString(value2));
                case "deleted" -> addLine(stringBuilder, "  - ", key, Utils.valueToString(value1));
                default -> { }
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public static void addLine(StringBuilder stringBuilder, String tag, String key, Object value) {
        stringBuilder.append(tag).append(key).append(": ").append(value).append("\n");
    }
}
