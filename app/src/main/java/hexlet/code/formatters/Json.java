package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;
import java.util.TreeMap;
import java.util.List;


public class Json {

    public static String formatJson(List<Map<String, Object>> diff) throws JsonProcessingException {

        StringBuilder str = new StringBuilder().append("{\n");
        ObjectMapper objectMapper = new ObjectMapper();
        for (Map<String, Object> entry: diff) {
            Map<String, String> line = new TreeMap<>();
            line.put("type", entry.get("type").toString());
            var type = entry.get("type").toString();
            if (type.equals("added")) {
                line.put("value2", valueToString(entry.get("value2")));
            } else if (type.equals("changed")) {
                line.put("value1", valueToString(entry.get("value1")));
                line.put("value2", valueToString(entry.get("value2")));
            } else if (type.equals("unchanged") || type.equals("deleted")) {
                line.put("value1", valueToString(entry.get("value1")));
            }
            str.append("\"").append(entry.get("key").toString()).append("\": ")
                    .append(objectMapper.writeValueAsString(line)).append(",\n");
        }
        str.setLength(str.length() - 2);
        str.append("\n}");
        return str.toString();
    }

    public static String valueToString(Object value) {
        if (value == null) {
            return "null";
        } else {
            return value.toString();
        }
    }
}
