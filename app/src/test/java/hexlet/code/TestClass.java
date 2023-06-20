package hexlet.code;

import static hexlet.code.Differ.fileToString;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestClass {

    @Test
    public void differJsonInputJsonOutput() throws Exception {
        String filepath1 = "src/test/resources/file1.json";
        String filepath2 = "src/test/resources/file2.json";
        String filepathResult = "src/test/resources/resultJsonFormat.txt";
        String expected = fileToString(filepathResult).trim();
        var actual = Differ.generate(filepath1, filepath2, "json");
        assertEquals(expected, actual);
    }

    @Test
    public void differYamlInputJsonOutput() throws Exception {
        String filepath1 = "src/test/resources/file1.yaml";
        String filepath2 = "src/test/resources/file2.yaml";
        String filepathResult = "src/test/resources/resultJsonFormat.txt";
        String expected = fileToString(filepathResult).trim();
        var actual = Differ.generate(filepath1, filepath2, "json");
        assertEquals(expected, actual);
    }

    @Test
    public void differJsonInputPlainOutput() throws Exception {
        String filepath1 = "src/test/resources/file1.json";
        String filepath2 = "src/test/resources/file2.json";
        String filepathResult = "src/test/resources/resultPlainFormat.txt";
        String expected = fileToString(filepathResult).trim();
        var actual = Differ.generate(filepath1, filepath2, "plain");
        assertEquals(expected, actual);
    }

    @Test
    public void differYamlInputPlainOutput() throws Exception {
        String filepath1 = "src/test/resources/file1.yaml";
        String filepath2 = "src/test/resources/file2.yaml";
        String filepathResult = "src/test/resources/resultPlainFormat.txt";
        String expected = fileToString(filepathResult).trim();
        var actual = Differ.generate(filepath1, filepath2, "plain");
        assertEquals(expected, actual);
    }

    @Test
    public void differJsonInputStylishOutput() throws Exception {
        String filepath1 = "src/test/resources/file1.json";
        String filepath2 = "src/test/resources/file2.json";
        String filepathResult = "src/test/resources/resultStylishFormat.txt";
        String expected = fileToString(filepathResult).trim();
        var actual = Differ.generate(filepath1, filepath2, "stylish");
        assertEquals(expected, actual);
    }

    @Test
    public void differYamlInputStylishOutput() throws Exception {
        String filepath1 = "src/test/resources/file1.yaml";
        String filepath2 = "src/test/resources/file2.yaml";
        String filepathResult = "src/test/resources/resultStylishFormat.txt";
        String expected = fileToString(filepathResult).trim();
        var actual = Differ.generate(filepath1, filepath2, "stylish");
        assertEquals(expected, actual);
    }
}
