package hexlet.code;

import static org.junit.jupiter.api.Assertions.assertEquals;

import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestClass {

    @Test
    public void differPlainJSON() throws IOException {
        File file1 = new File("src/test/resources/file1Nested.json");
        File file2 = new File("src/test/resources/file2Nested.json");
        String expected = """
        Property 'chars2' was updated. From [complex value] to false
        Property 'checked' was updated. From false to true
        Property 'default' was updated. From null to [complex value]
        Property 'id' was updated. From 45 to null
        Property 'key1' was removed
        Property 'key2' was added with value: value2
        Property 'numbers2' was updated. From [complex value] to [complex value]
        Property 'numbers3' was removed
        Property 'numbers4' was added with value: [complex value]
        Property 'obj1' was added with value: [complex value]
        Property 'setting1' was updated. From Some value to Another value
        Property 'setting2' was updated. From 200 to 300
        Property 'setting3' was updated. From true to none
        """;
        var actual = Differ.generate(file1, file2, "plain");
        assertEquals(expected, actual);
    }

    @Test
    public void differNestedJSON() throws IOException {
        File file1 = new File("src/test/resources/file1Nested.json");
        File file2 = new File("src/test/resources/file2Nested.json");
        String expected = """
                {
                   chars1: [a, b, c]
                 - chars2: [d, e, f]
                 + chars2: false
                 - checked: false
                 + checked: true
                 - default: null
                 + default: [value1, value2]
                 - id: 45
                 + id: null
                 - key1: value1
                 + key2: value2
                   numbers1: [1, 2, 3, 4]
                 - numbers2: [2, 3, 4, 5]
                 + numbers2: [22, 33, 44, 55]
                 - numbers3: [3, 4, 5]
                 + numbers4: [4, 5, 6]
                 + obj1: {nestedKey=value, isNested=true}
                 - setting1: Some value
                 + setting1: Another value
                 - setting2: 200
                 + setting2: 300
                 - setting3: true
                 + setting3: none
                }""";
        var actual = Differ.generate(file1, file2, "stylish");
        assertEquals(expected, actual);
    }

    @Test
    public void differNestedYAML() throws IOException {
        File file1 = new File("src/test/resources/file1Nested.yaml");
        File file2 = new File("src/test/resources/file2Nested.yaml");
        String expected = """
                {
                   chars1: [a, b, c]
                 - chars2: [d, e, f]
                 + chars2: false
                 - checked: false
                 + checked: true
                 - default: null
                 + default: [value1, value2]
                 - id: 45
                 + id: null
                 - key1: value1
                 + key2: value2
                   numbers1: [1, 2, 3, 4]
                 - numbers2: [2, 3, 4, 5]
                 + numbers2: [22, 33, 44, 55]
                 - numbers3: [3, 4, 5]
                 + numbers4: [4, 5, 6]
                 + obj1: {nestedKey=value, isNested=true}
                 - setting1: Some value
                 + setting1: Another value
                 - setting2: 200
                 + setting2: 300
                 - setting3: true
                 + setting3: none
                }""";
        var actual = Differ.generate(file1, file2, "stylish");
        assertEquals(expected, actual);
    }

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
        String actual = Stylish.formatStylish(Differ.genDiff(input1, input2));
        String expected = "{\n   key1: 1\n}";
        assertEquals(expected, actual);
    }
    @Test
    void modificationTest() {
        Map<String, Object> input1 = new HashMap<>();
        input1.put("key1", "1");
        Map<String, Object> input2 = new HashMap<>();
        input2.put("key1", "11");
        String actual = Stylish.formatStylish(Differ.genDiff(input1, input2));
        String expected = "{\n - key1: 1\n + key1: 11\n}";
        assertEquals(expected, actual);
    }
    @Test
    void additionTest() {
        Map<String, Object> input1 = new HashMap<>();
        input1.put("key1", "1");
        Map<String, Object> input2 = new HashMap<>();
        input2.put("key1", "1");
        input2.put("key3", "3");
        String actual = Stylish.formatStylish(Differ.genDiff(input1, input2));
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
        String actual = Stylish.formatStylish(Differ.genDiff(input1, input2));
        String expected = "{\n - key1: 1\n   key2: 2\n}";
        assertEquals(expected, actual);
    }

}
