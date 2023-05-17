package hexlet.code;

import hexlet.code.Utils;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Differ {
    public static String generate(File file1, File file2, String format) throws IOException {
        var mapFile1 = Parser.parse(file1);
        var mapFile2 = Parser.parse(file2);
        assert mapFile1 != null;
        assert mapFile2 != null;
        var diff = genDiff(mapFile1, mapFile2);
        if (format.equals("stylish")) {
            return Stylish.formatStylish(diff);
        }
        if (format.equals("plain")) {
            return Plain.formatPlain(diff);
        }
        return null;
    }
    public static Map<String, List<Object>> genDiff(Map<String, Object> mapFile1, Map<String, Object> mapFile2) {
        Set<String> keys = new TreeSet<>();
        keys.addAll(mapFile1.keySet());
        keys.addAll(mapFile2.keySet());
        Map<String, List<Object>> diff = new TreeMap<>();
        for (var key: keys) {
            var value1 = mapFile1.get(key);
            var value2 = mapFile2.get(key);
            List<Object> diffLine = new ArrayList<>();
            if (mapFile1.containsKey(key) && mapFile2.containsKey(key)) {
                if (Utils.valueToString(value1).equals(Utils.valueToString(value2))) {
                    diffLine.add("unchanged");
                    diffLine.add(value1);
                    diffLine.add(value2);
                } else {
                    diffLine.add("changed");
                    diffLine.add(value1);
                    diffLine.add(value2);
                }
            } else if (!mapFile2.containsKey(key)) {
                diffLine.add("deleted");
                diffLine.add(value1);
                diffLine.add(null);
            } else {
                diffLine.add("added");
                diffLine.add(null);
                diffLine.add(value2);
            }
            diff.put(key, diffLine);
        }
        return diff;
    }
}
