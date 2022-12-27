package pl.lsobotka.adventofcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RocketEquationTest extends BaseTest {

    private static Stream<Arguments> simpleMass() {
        return Stream.of(
                Arguments.of(12, 2),
                Arguments.of(14, 2),
                Arguments.of(1969, 654),
                Arguments.of(100756, 33583)
        );
    }

    @ParameterizedTest
    @MethodSource("simpleMass")
    public void simpleMassTest(int mass, int expected) {

        RocketEquation equation = new RocketEquation();
        int actual = equation.calcRequiredFuel(List.of(mass));
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> simpleMassFile() {
        return Stream.of(
                Arguments.of("RocketEquation", 3226488)
        );
    }

    @ParameterizedTest
    @MethodSource("simpleMassFile")
    public void simpleMassFileTest(String fileName, int expected) {
        List<Integer> input = getFileInput(fileName).stream().map(Integer::valueOf).collect(Collectors.toList());

        RocketEquation equation = new RocketEquation();
        int actual = equation.calcRequiredFuel(input);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> simpleMassWithFuel() {
        return Stream.of(
                Arguments.of(12, 2),
                Arguments.of(14, 2),
                Arguments.of(1969, 966),
                Arguments.of(100756, 50346)
        );
    }

    @ParameterizedTest
    @MethodSource("simpleMassWithFuel")
    public void simpleMassWithFuelTest(int mass, int expected) {
        RocketEquation equation = new RocketEquation();
        int actual = equation.calcRequiredFuelWithFuel(List.of(mass));
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> simpleMassWithFuelFile() {
        return Stream.of(
                Arguments.of("RocketEquation", 4836845)
        );
    }

    @ParameterizedTest
    @MethodSource("simpleMassWithFuelFile")
    public void simpleMassWithFuelFileTest(String fileName, int expected) {
        List<Integer> input = getFileInput(fileName).stream().map(Integer::valueOf).collect(Collectors.toList());

        RocketEquation equation = new RocketEquation();
        int actual = equation.calcRequiredFuelWithFuel(input);
        assertEquals(expected, actual);
    }

}
