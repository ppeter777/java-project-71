package hexlet.code;

import org.apache.commons.io.FilenameUtils;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Differ {
    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        String file1Content = fileToString(filepath1);
        String file2Content = fileToString(filepath2);
        String file1Extension = FilenameUtils.getExtension(filepath1);
        String file2Extension = FilenameUtils.getExtension(filepath2);
        Map<String, Object> parsedFile1 = Parser.parse(file1Content, file1Extension);
        Map<String, Object> parsedFile2 = Parser.parse(file2Content, file2Extension);
        assert parsedFile1 != null;
        assert parsedFile2 != null;
        var diff2 = GenDiff.genDiff(parsedFile1, parsedFile2);
        return Formatter.format(diff2, format);
    }

    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }

    public static String fileToString(String filepath) throws Exception {
        return Files.readString(pathFromString(filepath));
    }

    public static Path pathFromString(String filepath) throws Exception {
        Path path = Paths.get(filepath).toAbsolutePath().normalize();
        if (!Files.exists(path)) {
            throw new Exception("File '" + path + "' does not exist");
        }
        return path;
    }
}
