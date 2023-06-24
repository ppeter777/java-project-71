package hexlet.code;

import static hexlet.code.Differ.fileToString;
import static hexlet.code.Differ.pathFromString;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;

public class TestClass {
    private static String resultJsonFormat;
    private static String resultPlainFormat;
    private static String resultStylishFormat;

    public static String fileToString(String filepath) throws Exception {
        return Files.readString(pathFromString(filepath)).trim();
    }

    @BeforeAll
    public static void beforeAll() throws Exception {
        resultJsonFormat = fileToString(getFilePath("resultJsonFormat.txt"));
        resultPlainFormat = fileToString(getFilePath("resultPlainFormat.txt"));
        resultStylishFormat = fileToString(getFilePath("resultStylishFormat.txt"));
    }

    @Test
    public void differJsonInputJsonOutput() throws Exception {
        String filepath1 = getFilePath("file1.yaml");
        String filepath2 = getFilePath("file2.yaml");
        var actual = Differ.generate(filepath1, filepath2, "json");
        assertEquals(resultJsonFormat, actual);
    }

    @Test
    public void differYamlInputJsonOutput() throws Exception {
        String filepath1 = getFilePath("file1.yaml");
        String filepath2 = getFilePath("file2.yaml");
        var actual = Differ.generate(filepath1, filepath2, "json");
        assertEquals(resultJsonFormat, actual);
    }

    @Test
    public void differJsonInputPlainOutput() throws Exception {
        String filepath1 = getFilePath("file1.json");
        String filepath2 = getFilePath("file2.json");
        var actual = Differ.generate(filepath1, filepath2, "plain");
        assertEquals(resultPlainFormat, actual);
    }

    @Test
    public void differYamlInputPlainOutput() throws Exception {
        String filepath1 = getFilePath("file1.yaml");
        String filepath2 = getFilePath("file2.yaml");
        var actual = Differ.generate(filepath1, filepath2, "plain");
        assertEquals(resultPlainFormat, actual);
    }

    @Test
    public void differJsonInputStylishOutput() throws Exception {
        String filepath1 = getFilePath("file1.json");
        String filepath2 = getFilePath("file2.json");
        var actual = Differ.generate(filepath1, filepath2, "stylish");
        assertEquals(resultStylishFormat, actual);
    }

    @Test
    public void differYamlInputStylishOutput() throws Exception {
        String filepath1 = getFilePath("file1.yaml");
        String filepath2 = getFilePath("file2.yaml");
        var actual = Differ.generate(filepath1, filepath2, "stylish");
        assertEquals(resultStylishFormat, actual);
    }

    public static String getFilePath(String filename) {
       return "src/test/resources/" + filename;
    }
}
