package pl.lsobotka.adventofcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PasswordPhilosophyTest {

    @ParameterizedTest
    @MethodSource("dataA")
    public void dayTwoAFile(String path, long expected) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        PasswordPhilosophy passwordPhilosophy = new PasswordPhilosophy();

        List<PasswordPhilosophy.TestData> testDataList = bufferedReader.lines().map(passwordPhilosophy::mapToTestData).collect(Collectors.toList());
        bufferedReader.close();

        long output = passwordPhilosophy.countValidPasswords(testDataList, PasswordPhilosophy.countPredicate);

        assertEquals(expected, output);

    }

    private static Stream<Arguments> dataA(){
        return Stream.of(
                Arguments.of("src/test/resources/PasswordPhilosophy", 439)
        );
    }

    @ParameterizedTest
    @MethodSource("dataB")
    public void dayTwoBFile(String path, long expected) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        PasswordPhilosophy passwordPhilosophy = new PasswordPhilosophy();

        List<PasswordPhilosophy.TestData> testDataList = bufferedReader.lines().map(passwordPhilosophy::mapToTestData).collect(Collectors.toList());
        bufferedReader.close();

        long output = passwordPhilosophy.countValidPasswords(testDataList, PasswordPhilosophy.indexPredicate);

        assertEquals(expected, output);

    }

    private static Stream<Arguments> dataB(){
        return Stream.of(
                Arguments.of("src/test/resources/PasswordPhilosophy", 584)
        );
    }
}
