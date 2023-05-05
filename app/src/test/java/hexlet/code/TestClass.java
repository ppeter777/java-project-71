package hexlet.code;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestClass {
    @Test
    public void parserJSONTest() throws IOException {
        File file = new File("src/test/resources/file3.json");
        Map<String, Object> expected = new HashMap<>();
        expected.put("key1", "1");
        expected.put("key2", "2");
        expected.put("key3", "3");
        var actual = Parser.parse(file);
        assertEquals(expected, actual);
    }
    @Test
    public void parserYAMLTest() throws IOException {
        File file = new File("src/test/resources/file1.yaml");
        Map<String, Object> expected = new HashMap<>();
        expected.put("name", "project2");
        expected.put("host", "hexlet.io");
        expected.put("timeout", 50);
        var actual = Parser.parse(file);
        assertEquals(expected, actual);
    }
    @Test
    public void unchangedTest() {
        Map<String, Object> input1 = new HashMap<>();
        input1.put("key1", "1");
        Map<String, Object> input2 = new HashMap<>();
        input2.put("key1", "1");
        String actual = Differ.genDiff(input1, input2);
        String expected = "{\n   key1: 1\n}";
        assertEquals(expected, actual);
    }
    @Test
    void modificationTest() {
        Map<String, Object> input1 = new HashMap<>();
        input1.put("key1", "1");
        Map<String, Object> input2 = new HashMap<>();
        input2.put("key1", "11");
        String actual = Differ.genDiff(input1, input2);
        String expected = "{\n - key1: 1\n + key1: 11\n}";
        assertEquals(actual, expected);
    }
    @Test
    void additionTest() {
        Map<String, Object> input1 = new HashMap<>();
        input1.put("key1", "1");
        Map<String, Object> input2 = new HashMap<>();
        input2.put("key1", "1");
        input2.put("key3", "3");
        String actual = Differ.genDiff(input1, input2);
        String expected = "{\n   key1: 1\n + key3: 3\n}";
        assertEquals(expected, actual);
    }

    @Test
    void removalTest() {
        Map<String, Object> input1 = new HashMap<>();
        input1.put("key1", "1");
        input1.put("key2", "2");
        Map<String, Object> input2 = new HashMap<>();
        input2.put("key2", "2");
        String actual = Differ.genDiff(input1, input2);
        String expected = "{\n - key1: 1\n   key2: 2\n}";
        assertEquals(expected, actual);
    }

}
