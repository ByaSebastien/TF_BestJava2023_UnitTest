package be.btorm;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class NoteTest {

    Note note;

    @BeforeEach
    void setUp() {
        note = new Note();
    }

    @AfterEach
    void tearDown() {
        note = null;
    }

    @Test
    void negativeNumberShouldThrowIllegalArgumentException(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,() -> note.getLetterNote(-1));
        assertEquals("Year result must be between 0 and 100",exception.getMessage()
        );
    }

    @Test
    void numberUpToOneHundredShouldThrowIllegalArgumentException(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,() -> note.getLetterNote(101));
        assertEquals("Year result must be between 0 and 100",exception.getMessage());
    }

    @Test
    void zeroShouldReturnF(){
        assertEquals('F',note.getLetterNote(0));
    }

    @Test
    void fortyNineShouldReturnF(){
        assertEquals('F',note.getLetterNote(49));
    }

    @Test
    void fiftyShouldReturnE(){
        assertEquals('E',note.getLetterNote(50));
    }

    @Test
    void fiftyNineShouldReturnE(){
        assertEquals('E',note.getLetterNote(59));
    }

    @ParameterizedTest
    @CsvSource({"60","69"})
    void sixtyToSixtyNineShouldReturnD(int a){
        assertEquals('D',note.getLetterNote(a));
    }

    @ParameterizedTest
    @CsvSource({"70","79"})
    void seventyToSeventyNineShouldReturnC(int a){
        assertEquals('C',note.getLetterNote(a));
    }

    @ParameterizedTest
    @CsvSource({"80","89"})
    void eightyToEightyNineShouldReturnB(int a){
        assertEquals('B',note.getLetterNote(a));
    }
    @ParameterizedTest
    @CsvSource({"90","100"})
    void ninetyToOneHundredShouldReturnA(int a){
        assertEquals('A',note.getLetterNote(a));
    }
}