package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Differ {
    public static Map<String, List<Object>> generate(String filepath1, String filepath2) throws IOException {
//        var parsedFile1 = Parser.parse(file1);
//        var parsedFile2 = Parser.parse(file2);
//        assert parsedFile1 != null;
//        assert parsedFile2 != null;
        File file1 = new File(filepath1);
        File file2 = new File(filepath2);
        var parsedFile1 = Parser.parse(file1);
        var parsedFile2 = Parser.parse(file2);
        assert parsedFile1 != null;
        assert parsedFile2 != null;
        return genDiff(parsedFile1, parsedFile2);
    }
    public static Map<String, List<Object>> genDiff(Map<String, Object> parsedFile1, Map<String, Object> parsedFile2)
            throws JsonProcessingException {
        Set<String> keys = new TreeSet<>();
        keys.addAll(parsedFile1.keySet());
        keys.addAll(parsedFile2.keySet());
        Map<String, List<Object>> diff = new TreeMap<>();
        for (var key: keys) {
            var value1 = parsedFile1.get(key);
            var value2 = parsedFile2.get(key);
            List<Object> diffLine = new ArrayList<>();
            if (parsedFile1.containsKey(key) && parsedFile2.containsKey(key)) {
                if (Utils.valueToString(value1).equals(Utils.valueToString(value2))) {
                    diffLine.add("unchanged");
                    diffLine.add(value1);
                    diffLine.add(value2);
                } else {
                    diffLine.add("changed");
                    diffLine.add(value1);
                    diffLine.add(value2);
                }
            } else if (!parsedFile2.containsKey(key)) {
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
