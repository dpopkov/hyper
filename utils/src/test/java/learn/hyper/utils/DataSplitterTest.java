package learn.hyper.utils;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataSplitterTest {

    @Test
    void testSplit() {
        final List<String> input = List.of("ab", "ba", "ca", "ac", "dc");
        List<List<String>> result = new DataSplitter().split(input.stream(), x -> x.startsWith("a"));
        assertLinesMatch(List.of("ba", "ca", "dc"), result.get(0));
        assertLinesMatch(List.of("ab", "ac"), result.get(1));
    }
}
