package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.File;
//import java.math.BigInteger;
import java.nio.file.Files;
//import java.security.MessageDigest;
import java.util.concurrent.Callable;

import com.fasterxml.jackson.databind.ObjectMapper;
//import org.apache.commons.lang3.StringUtils;

//import java.nio.file.FileSystems;
//import java.nio.file.Files;
import java.nio.file.Path;
//import java.nio.file.Paths;

//import java.io.File;
import java.util.Map;
import java.util.TreeMap;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")

class App implements Callable {

    @Option(names = {"-f", "--format"}, paramLabel = "format",
            description = "output format [default: ${DEFAULT-VALUE}]", defaultValue = "stylish")
    private String format;

    @Parameters(index = "0", paramLabel = "filepath1", description = "path to first file", defaultValue = "/etc/hosts")
    private File file1 = new File("/etc/hosts");

    @Parameters(index = "1", paramLabel = "filepath2", description = "path to second file", defaultValue = "/etc/hosts")
    private File file2 = new File("/etc/hosts");

    public static void main(String... args) {
        //System.out.println("Hello World!");

        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public Object call() throws Exception {
        Path path1 = file1.toPath();
        Path path2 = file2.toPath();
        String content1 = Files.readString(path1);
        String content2 = Files.readString(path2);
        ObjectMapper myObjectMapper = new ObjectMapper();
        var typeReference1 = new TypeReference<TreeMap<String, Object>>() { };
        var typeReference2 = new TypeReference<TreeMap<String, Object>>() { };
        Map<String, Object> mapFile1 = myObjectMapper.readValue(content1, typeReference1);
        Map<String, Object> mapFile2 = myObjectMapper.readValue(content2, typeReference2);

        System.out.println("file1 \n" + mapFile1 + "\n");
        System.out.println("file2 \n" + mapFile2);
        System.out.println(Differ.genDiff(mapFile1, mapFile2));
        return null;
    }
}


