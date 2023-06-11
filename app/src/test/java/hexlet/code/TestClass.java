package hexlet.code;

import static hexlet.code.Differ.fileToString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class TestClass {

    @Test
    public void differUnsupportedExtension() {
        String filepath1 = "src/test/resources/file1.yml";
        String filepath2 = "src/test/resources/file2.ymll";
        Throwable exception = assertThrows(Exception.class, () ->
                Differ.generate(filepath1, filepath2, "stylish"));
        assertEquals("File extension 'ymll' is not supported!", exception.getMessage());
    }

    @Test
    public void differNoFile() {
        String filepath1 = "src/test/resources/file1.yml";
        String filepath2 = "src/test/resources/file22.yml";
        Throwable exception = assertThrows(Exception.class, () ->
                Differ.generate(filepath1, filepath2, "stylish"));
        assertEquals("File 'src/test/resources/file22.yml' does not exist", exception.getMessage());
    }

    @Test
    public void differCorruptedJson() {
        String filepath1 = "src/test/resources/file1corrupted.json";
        String filepath2 = "src/test/resources/file2Nested.json";
        Throwable exception = assertThrows(Exception.class, () ->
                Differ.generate(filepath1, filepath2, "stylish"));
        assertEquals("Json processing error!", exception.getMessage());
    }

    @Test
    public void differCorruptedYaml() {
        String filepath1 = "src/test/resources/file1corrupted.yaml";
        String filepath2 = "src/test/resources/file2Nested.yaml";
        Throwable exception = assertThrows(Exception.class, () ->
                Differ.generate(filepath1, filepath2, "stylish"));
        assertEquals("Yaml processing error!", exception.getMessage());
    }

    @Test
    public void differJsonOutput() throws Exception {
        String filepath1 = "src/test/resources/file3.json";
        String filepath2 = "src/test/resources/file4.json";
        String filepathResult = "src/test/resources/differJsonOutputExpected.txt";
        String expected = fileToString(filepathResult).trim();
        var actual = Differ.generate(filepath1, filepath2, "json");
        assertEquals(expected, actual);
    }

    @Test
    public void differPlainOutput() throws Exception {
        String filepath1 = "src/test/resources/file1Nested.json";
        String filepath2 = "src/test/resources/file2Nested.json";
        String filepathResult = "src/test/resources/differPlainOutputExpected.txt";
        String expected = fileToString(filepathResult).trim();
        var actual = Differ.generate(filepath1, filepath2, "plain");
        assertEquals(expected, actual);
    }

    @Test
    public void differJsonNestedInput() throws Exception {
        String filepath1 = "src/test/resources/file1Nested.json";
        String filepath2 = "src/test/resources/file2Nested.json";
        String filepathResult = "src/test/resources/differNestedInputExpected.txt";
        String expected = fileToString(filepathResult).trim();
        var actual = Differ.generate(filepath1, filepath2, "stylish");
        assertEquals(expected, actual);
    }

    @Test
    public void differYamlNestedInput() throws Exception {
        String filepath1 = "src/test/resources/file1Nested.yaml";
        String filepath2 = "src/test/resources/file2Nested.yaml";
        String filepathResult = "src/test/resources/differNestedInputExpected.txt";
        String expected = fileToString(filepathResult).trim();
        var actual = Differ.generate(filepath1, filepath2, "stylish");
        assertEquals(expected, actual);
    }
}
