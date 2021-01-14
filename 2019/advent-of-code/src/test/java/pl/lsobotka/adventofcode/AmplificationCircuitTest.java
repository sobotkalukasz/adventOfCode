package pl.lsobotka.adventofcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AmplificationCircuitTest extends BaseTest {

    private static Stream<Arguments> maxSignal() {
        return Stream.of(
                Arguments.of(new int[]{3, 15, 3, 16, 1002, 16, 10, 16, 1, 16, 15, 15, 4, 15, 99, 0, 0}, IntStream.rangeClosed(0, 4).toArray(), 43210), //4,3,2,1,0
                Arguments.of(new int[]{3, 23, 3, 24, 1002, 24, 10, 24, 1002, 23, -1, 23,
                        101, 5, 23, 23, 1, 24, 23, 23, 4, 23, 99, 0, 0}, IntStream.rangeClosed(0, 4).toArray(), 54321), //0,1,2,3,4
                Arguments.of(new int[]{3, 31, 3, 32, 1002, 32, 10, 32, 1001, 31, -2, 31, 1007, 31, 0, 33,
                        1002, 33, 7, 33, 1, 33, 31, 31, 1, 32, 31, 31, 4, 31, 99, 0, 0, 0}, IntStream.rangeClosed(0, 4).toArray(), 65210) //1,0,4,3,2
        );
    }

    @ParameterizedTest
    @MethodSource("maxSignal")
    public void maxSignalTest(int[] program, int[] range, int expected) {
        AmplificationCircuit circuit = new AmplificationCircuit(program);
        int actual = circuit.calculateMaxSignal(range);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> maxSignalFile() {
        return Stream.of(
                Arguments.of("AmplificationCircuit", IntStream.rangeClosed(0, 4).toArray(), 75228)
        );
    }

    @ParameterizedTest
    @MethodSource("maxSignalFile")
    public void maxSignalTest(String fileName, int[] range, int expected) throws Exception {
        int[] program = getFileInput(fileName).stream().map(s -> s.split(",")).flatMap(Stream::of).mapToInt(Integer::valueOf).toArray();
        AmplificationCircuit circuit = new AmplificationCircuit(program);
        int actual = circuit.calculateMaxSignal(range);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> maxSignalLoop() {
        return Stream.of(
                Arguments.of(new int[]{3, 26, 1001, 26, -4, 26, 3, 27, 1002, 27, 2, 27, 1, 27, 26,
                        27, 4, 27, 1001, 28, -1, 28, 1005, 28, 6, 99, 0, 0, 5}, IntStream.rangeClosed(5, 9).toArray(), 139629729), //9,8,7,6,5
                Arguments.of(new int[]{3, 52, 1001, 52, -5, 52, 3, 53, 1, 52, 56, 54, 1007, 54, 5, 55, 1005, 55, 26, 1001, 54,
                        -5, 54, 1105, 1, 12, 1, 53, 54, 53, 1008, 54, 0, 55, 1001, 55, 1, 55, 2, 53, 55, 53, 4,
                        53, 1001, 56, -1, 56, 1005, 56, 6, 99, 0, 0, 0, 0, 10}, IntStream.rangeClosed(5, 9).toArray(), 18216) //9,7,8,5,6
        );
    }

    @ParameterizedTest
    @MethodSource("maxSignalLoop")
    public void maxSignalLoopTest(int[] program, int[] range, int expected) {
        AmplificationCircuit circuit = new AmplificationCircuit(program);
        int actual = circuit.calculateMaxSignalLoop(range);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> maxSignalLoopFile() {
        return Stream.of(
                Arguments.of("AmplificationCircuit", IntStream.rangeClosed(5, 9).toArray(), 79846026)
        );
    }

    @ParameterizedTest
    @MethodSource("maxSignalLoopFile")
    public void maxSignalLoopFileTest(String fileName, int[] range, int expected) throws Exception {
        int[] program = getFileInput(fileName).stream().map(s -> s.split(",")).flatMap(Stream::of).mapToInt(Integer::valueOf).toArray();
        AmplificationCircuit circuit = new AmplificationCircuit(program);
        int actual = circuit.calculateMaxSignalLoop(range);
        assertEquals(expected, actual);
    }

}