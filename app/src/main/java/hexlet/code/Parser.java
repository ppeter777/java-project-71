package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.TreeMap;

public class Parser {
    public static Map<String,Object> parse(File file) throws IOException {
        Path path = file.toPath();
        String fileString = Files.readString(path);
        var fileExtension = FilenameUtils.getExtension(file.getName());
        if (fileExtension.equals("json")) {
            ObjectMapper jsonObjectMapper = new ObjectMapper();
            var typeReference = new TypeReference<TreeMap<String, Object>>() { };
            return jsonObjectMapper.readValue(fileString, typeReference);
        } else if (fileExtension.equals("yaml")) {
            ObjectMapper yamlObjectMapper = new YAMLMapper();
            var typeReference = new TypeReference<TreeMap<String, Object>>() { };
            return yamlObjectMapper.readValue(fileString, typeReference);
        }
        return null;
    }
}



























