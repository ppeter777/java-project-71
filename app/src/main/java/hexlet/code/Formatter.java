package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;
import java.util.List;
import java.util.Map;

public class Formatter {

    public static String format(Map<String, List<Object>> diff, String format) throws Exception {
        if (format.equals("stylish")) {
            return Stylish.formatStylish(diff);
        }
        if (format.equals("plain")) {
            return Plain.formatPlain(diff);
        }
        if (format.equals("json")) {
            return Json.formatJson(diff);
        }
        throw new Exception("Unsupported format '" + format + "'");
    }
}
