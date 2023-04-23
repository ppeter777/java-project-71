package hexlet.code;

//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;

//import java.io.File;
//import java.util.*;

//import picocli.CommandLine;
//import picocli.CommandLine.Command;
//import picocli.CommandLine.Option;
//import picocli.CommandLine.Parameters;



import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Differ {
    public static String generate(String filePath1, String filePath2) {
        return null;
    }
    public static String genDiff(Map mapFile1, Map mapFile2) {
        Set<String> keys = new TreeSet<>();
        keys.addAll(mapFile1.keySet());
        keys.addAll(mapFile2.keySet());

        System.out.println("keys:\n" + keys + "\n");
        StringBuilder stringBuilder = new StringBuilder().append("{\n");
        for (var key: keys) {
            if (mapFile1.containsKey(key) && mapFile2.containsKey(key)) {
                if (mapFile1.get(key).equals(mapFile2.get(key))) {
                    stringBuilder.append("   ").append(key).append(": ").append(mapFile1.get(key)).append("\n");
                } else {
                    stringBuilder.append(" - ").append(key).append(": ").append(mapFile1.get(key)).append("\n");
                    stringBuilder.append(" + ").append(key).append(": ").append(mapFile2.get(key)).append("\n");
                }
            } else if (mapFile1.containsKey(key)) {
                stringBuilder.append(" - ").append(key).append(": ").append(mapFile1.get(key)).append("\n");
            } else {
                stringBuilder.append(" + ").append(key).append(": ").append(mapFile2.get(key)).append("\n");
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
