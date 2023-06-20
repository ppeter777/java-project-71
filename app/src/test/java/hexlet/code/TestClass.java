package hexlet.code;

import static hexlet.code.Differ.fileToString;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestClass {

//    @Test
//    public void differUnsupportedExtension() {
//        String filepath1 = "src/test/resources/file1.yml";
//        String filepath2 = "src/test/resources/file2.ymll";
//        Throwable exception = assertThrows(Exception.class, () ->
//                Differ.generate(filepath1, filepath2, "stylish"));
//        assertEquals("File extension 'ymll' is not supported!", exception.getMessage());
//    }

//    @Test
//    public void differNoFile() {
//        String filepath1 = "src/test/resources/file1.yml";
//        String filepath2 = "src/test/resources/file22.yml";
//        Throwable exception = assertThrows(Exception.class, () ->
//                Differ.generate(filepath1, filepath2, "stylish"));
//        assertThat(exception.getMessage()
//                .contains("File '/home/ppeter777/java-project-71/app/src/test/resources/file22.yml' does not exist"))
//                .isTrue();
//    }

//    @Test
//    public void differCorruptedJson() {
//        String filepath1 = "src/test/resources/file1corrupted.json";
//        String filepath2 = "src/test/resources/file2Nested.json";
//        Throwable exception = assertThrows(Exception.class, () ->
//                Differ.generate(filepath1, filepath2, "stylish"));
//        assertThat(exception.toString().contains("Unexpected character")).isTrue();
//    }

//    @Test
//    public void differCorruptedYaml() {
//        String filepath1 = "src/test/resources/file1corrupted.yaml";
//        String filepath2 = "src/test/resources/file2Nested.yaml";
//        Throwable exception = assertThrows(Exception.class, () ->
//                Differ.generate(filepath1, filepath2, "stylish"));
//        assertThat(exception.toString().contains("MarkedYAMLException")).isTrue();
//    }

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
