package learn.hyper.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataSplitter {

    public static void main(String[] args) throws IOException {
        if (args.length != 6) {
            System.err.println("Usage: DataSplitter <inputPath> <outputDirPath> " +
                    "<firstFilename> <secondFilename> prefix <predicateValue>");
            System.exit(-1);
        }
        String inputPath = args[0];
        String outputDirPath = args[1];
        String firstFilename = args[2];
        String secondFilename = args[3];
        String predicateType = args[4];
        String predicateValue = args[5];
        Predicate<String> toSecond;
        if (predicateType.equals("prefix")) {
            toSecond = line -> line.startsWith(predicateValue);
            new DataSplitter().split(inputPath, outputDirPath, firstFilename, secondFilename, toSecond);
        } else {
            throw new IllegalStateException("Unknown predicate type: " + predicateType);
        }
    }

    public void split(String inputPath, String outputDirPath, String firstFilename, String secondFilename,
                      Predicate<String> toSecond) throws IOException {
        Path inPath = Paths.get(inputPath);
        Path outDir = Paths.get(outputDirPath);
        Path firstPath = outDir.resolve(firstFilename);
        Path secondPath = outDir.resolve(secondFilename);
        List<List<String>> twoOutputs = split(Files.lines(inPath), toSecond);
        Files.write(firstPath, twoOutputs.get(0));
        Files.write(secondPath, twoOutputs.get(1));
    }

    public List<List<String>> split(Stream<String> lines, Predicate<String> toSecond) {
        Map<Boolean, List<String>> splitted = lines.collect(Collectors.partitioningBy(toSecond));
        List<List<String>> result = new ArrayList<>(2);
        result.add(splitted.get(false));
        result.add(splitted.get(true));
        return result;
    }
}
