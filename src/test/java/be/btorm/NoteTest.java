package be.btorm;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}