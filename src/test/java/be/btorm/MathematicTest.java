package be.btorm;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class MathematicTest {

    private Mathematic math;

    @BeforeEach
    void setUp() {
        math = new Mathematic();
    }

    @AfterEach
    void tearDown() {
        math = null;
    }

    @Test
    void twoPlusTwoShouldEqualsFour() {

        //Arrange
        int a = 2;
        int b = 2;
        int expected = 4;

        //Action
        int actual = math.add(a, b);

        //Assert
        assertEquals(expected, actual);
//        assertNotEquals();
//        assertNull();
//        assertNotNull();
//        assertTrue();
//        assertFalse();
//        assertThrows()
//        assertDoesNotThrow();
    }

    @Test
    void fivePlusSevenShouldEqualsTwelves() {

        //Arrange
        int a = 5;
        int b = 7;
        int expected = 12;

        //Action
        int actual = math.add(a, b);

        //Assert
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({"5,2,7","3,5,8"})
    void positivePlusPositiveShouldEqualsSmth(int a,int b,int expected){

        // Action
        int actual = math.add(a, b);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void maxValuePlusPositiveShouldThrowRuntimeException() {

        //Arrange
        int a = Integer.MAX_VALUE;
        int b = 10;

        //Action and Assert
        assertThrows(RuntimeException.class,() -> math.add(a,b));
    }

    @Test
    void tenDividedbyTwoShouldEqualsFive(){
        assertEquals(5,math.division(10,2));
    }

    @Test
    void dividedByZeroShouldThrowDividedByZeroException(){
        DividedByZeroException actualException = assertThrows(DividedByZeroException.class,()-> math.division(10,0));
        assertEquals("Cannot divide by zero",actualException.getMessage());
    }
}