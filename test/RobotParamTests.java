import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RobotParamTests {

    @ParameterizedTest
    @CsvSource({"10,Age ok", "20,Age ok", "25,Too old"})
    void testcheckageAll(int age, String expected){
        Robot buddy = new Robot("buddy", age);
        assertEquals(expected, buddy.checkAge());
    }

    @ParameterizedTest
    @CsvSource({"5,10000.00", "10,7500.00", "20,5000.00"})
    void testcheckcostAll(int age, double expected){
        Robot buddy = new Robot("buddy", age);
        assertEquals(expected, buddy.checkCost());
    }

    @ParameterizedTest
    @CsvFileSource(resources ="ParamTestFile.csv", numLinesToSkip = 1 )
    void testcheckageAll2( int age, String expected) {
        Robot buddy = new Robot("buddy", age);
        assertEquals(expected, buddy.checkAge() );
    }

    @ParameterizedTest
    @CsvFileSource(resources ="ParamTestFile2.csv", numLinesToSkip = 1 )
    void testcheckcostAll2( int age, double expected) {
        Robot buddy = new Robot("buddy", age);
        assertEquals(expected, buddy.checkCost() );
    }
}