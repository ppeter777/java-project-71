package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import java.util.Map;
import java.util.TreeMap;

public class Parser {
    public static Map<String, Object> parse(String fileContent, String fileExtension) throws Exception {
        if (fileExtension.equals("json")) {
            return parseJson(fileContent);
        } else if (fileExtension.equals("yaml") || fileExtension.equals("yml")) {
            return parseYaml(fileContent);
        }
        throw new Exception("File extension '" + fileExtension + "' is not supported!");
    }

    public static Map<String, Object> parseJson(String fileContent) throws JsonProcessingException {
        ObjectMapper jsonObjectMapper = new ObjectMapper();
        var typeReference = new TypeReference<TreeMap<String, Object>>() { };
        return jsonObjectMapper.readValue(fileContent, typeReference);
    }
    public static Map<String, Object> parseYaml(String fileContent) throws JsonProcessingException {
        ObjectMapper yamlObjectMapper = new YAMLMapper();
        var typeReference = new TypeReference<TreeMap<String, Object>>() { };
        return yamlObjectMapper.readValue(fileContent, typeReference);
    }
}
