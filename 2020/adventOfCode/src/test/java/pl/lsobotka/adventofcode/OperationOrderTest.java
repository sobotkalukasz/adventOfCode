package pl.lsobotka.adventofcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationOrderTest {

    private static Stream<Arguments> mathData(){
        return Stream.of(
                Arguments.of("1 + 2 * 3 + 4 * 5 + 6", 71D),
                Arguments.of("2 * 3 + (4 * 5)", 26D),
                Arguments.of("1 + (2 * 3) + (4 * (5 + 6))", 51D),
                Arguments.of("5 + (8 * 3 + 9 + 3 * 4 * 3)", 437D),
                Arguments.of("5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))", 12240D),
                Arguments.of("((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2", 13632D)
        );
    }

    @ParameterizedTest
    @MethodSource("mathData")
    public void mathDataTest(String input, double expected) {

        OperationOrder oo = new OperationOrder();
        double actual = oo.calculate(input);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> mathDataFile(){
        return Stream.of(
                Arguments.of("src/test/resources/OperationOrder", 5374004645253L)
        );
    }

    @ParameterizedTest
    @MethodSource("mathDataFile")
    public void mathDataFileTest(String path, long expected) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        List<String> data = bufferedReader.lines().collect(Collectors.toList());
        bufferedReader.close();

        OperationOrder oo = new OperationOrder();
        long sum = data.stream().mapToLong(oo::calculate).sum();
        assertEquals(expected, sum);
    }

    private static Stream<Arguments> mathWeirdData(){
        return Stream.of(
                Arguments.of("1 + 2 * 3 + 4 * 5 + 6", 231),
                Arguments.of("2 * 3 + (4 * 5)", 46),
                Arguments.of("1 + (2 * 3) + (4 * (5 + 6))", 51)
                ,
                Arguments.of("5 + (8 * 3 + 9 + 3 * 4 * 3)", 1445),
                Arguments.of("5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))", 669060),
                Arguments.of("((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2", 23340)
        );
    }

    @ParameterizedTest
    @MethodSource("mathWeirdData")
    public void mathWeirdDataTest(String input, int expected) {

        OperationOrder oo = new OperationOrder();
        long actual = oo.calculateWeird(input);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> mathWeirdDataFile(){
        return Stream.of(
                Arguments.of("src/test/resources/OperationOrder", 88782789402798L)
        );
    }

    @ParameterizedTest
    @MethodSource("mathWeirdDataFile")
    public void mathWeirdDataFileTest(String path, long expected) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        List<String> data = bufferedReader.lines().collect(Collectors.toList());
        bufferedReader.close();

        OperationOrder oo = new OperationOrder();
        long sum = data.stream().mapToLong(oo::calculateWeird).sum();
        assertEquals(expected, sum);
    }
}
