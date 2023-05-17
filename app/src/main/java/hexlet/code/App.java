package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import java.io.File;
import java.util.concurrent.Callable;

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

        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
    @Override
    public Object call() throws Exception {
        var diff = Differ.generate(file1, file2, format);
        System.out.println(diff);
        return null;
    }
}


