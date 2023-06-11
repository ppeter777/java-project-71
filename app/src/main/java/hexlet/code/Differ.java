package hexlet.code;

import org.apache.commons.io.FilenameUtils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Differ {
    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        String file1Content = fileToString(filepath1);
        String file2Content = fileToString(filepath2);
        String file1Extension = FilenameUtils.getExtension(filepath1);
        String file2Extension = FilenameUtils.getExtension(filepath2);
        var parsedFile1 = Parser.parse(file1Content, file1Extension);
        var parsedFile2 = Parser.parse(file2Content, file2Extension);
        assert parsedFile1 != null;
        assert parsedFile2 != null;
        var diff = GenDiff.genDiff(parsedFile1, parsedFile2);
        return Formatter.format(diff, format);
    }

    public static String fileToString(String filepath) throws Exception {
        Path path = Paths.get(filepath);
        if (!Files.exists(path)) {
            throw new Exception("File '" + path + "' does not exist");
        }
        return Files.readString(path);
    }
}
