package hexlet.code;

import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.List;
import java.util.Map;

public class Formatter {

    public static String format(Map<String, List<Object>> diff, String format) {
        if (format.equals("stylish")) {
            return Stylish.formatStylish(diff);
        }
        if (format.equals("plain")) {
            return Plain.formatPlain(diff);
        }
    return null;
    }
}
