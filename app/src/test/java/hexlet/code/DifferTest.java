package hexlet.code;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DifferTest {
    private static String resultJsonFormat;
    private static String resultPlainFormat;
    private static String resultStylishFormat;

    @BeforeAll
    public static void beforeAll() throws Exception {
        resultJsonFormat = fileToString(getFilePath("resultJsonFormat.txt"));
        resultPlainFormat = fileToString(getFilePath("resultPlainFormat.txt"));
        resultStylishFormat = fileToString(getFilePath("resultStylishFormat.txt"));
    }

    @Test
    public void differJsonOutput() throws Exception {
        Path filepathJson1 = getFilePath("file1.json");
        Path filepathJson2 = getFilePath("file2.json");
        Path filepathYaml1 = getFilePath("file1.yaml");
        Path filepathYaml2 = getFilePath("file2.yaml");
        var actualJson = Differ.generate(filepathJson1.toString(), filepathJson2.toString(), "json");
        var actualJsonDefault = Differ.generate(filepathJson1.toString(), filepathJson2.toString());
        var actualYaml = Differ.generate(filepathYaml1.toString(), filepathYaml2.toString(), "json");
        var actualYamlDefault = Differ.generate(filepathYaml1.toString(), filepathYaml2.toString());
        ObjectMapper mapper = new ObjectMapper();
        assertEquals(mapper.readTree(resultJsonFormat), mapper.readTree(actualJson));
        assertEquals(resultStylishFormat, actualJsonDefault);
        assertEquals(mapper.readTree(resultJsonFormat), mapper.readTree(actualYaml));
        assertEquals(resultStylishFormat, actualYamlDefault);
    }

    @Test
    public void differPlainOutput() throws Exception {
        Path filepathJson1 = getFilePath("file1.json");
        Path filepathJson2 = getFilePath("file2.json");
        Path filepathYaml1 = getFilePath("file1.yaml");
        Path filepathYaml2 = getFilePath("file2.yaml");
        var actualJson = Differ.generate(filepathJson1.toString(), filepathJson2.toString(), "plain");
        var actualJsonDefault = Differ.generate(filepathJson1.toString(), filepathJson2.toString());
        var actualYaml = Differ.generate(filepathYaml1.toString(), filepathYaml2.toString(), "plain");
        var actualYamlDefault = Differ.generate(filepathYaml1.toString(), filepathYaml2.toString());
        assertEquals(resultPlainFormat, actualJson);
        assertEquals(resultStylishFormat, actualJsonDefault);
        assertEquals(resultPlainFormat, actualYaml);
        assertEquals(resultStylishFormat, actualYamlDefault);
    }

    @Test
    public void differStylishOutput() throws Exception {
        Path filepathJson1 = getFilePath("file1.json");
        Path filepathJson2 = getFilePath("file2.json");
        Path filepathYaml1 = getFilePath("file1.yaml");
        Path filepathYaml2 = getFilePath("file2.yaml");
        var actualJson = Differ.generate(filepathJson1.toString(), filepathJson2.toString(), "stylish");
        var actualJsonDefault = Differ.generate(filepathJson1.toString(), filepathJson2.toString());
        var actualYaml = Differ.generate(filepathYaml1.toString(), filepathYaml2.toString(), "stylish");
        var actualYamlDefault = Differ.generate(filepathYaml1.toString(), filepathYaml2.toString());
        assertEquals(resultStylishFormat, actualJson);
        assertEquals(resultStylishFormat, actualJsonDefault);
        assertEquals(resultStylishFormat, actualYaml);
        assertEquals(resultStylishFormat, actualYamlDefault);
    }

    private static Path getFilePath(String filename) {
        return Paths.get("src/test/resources/" + filename).toAbsolutePath().normalize();
    }

    private static String fileToString(Path filepath) throws Exception {
        return Files.readString(filepath).trim();
    }

}
