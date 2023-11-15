package be.btorm;

public class Note {

    public char getLetterNote(int yearResult) {

        if (yearResult < 0 || yearResult > 100) {
            throw new IllegalArgumentException("Year result must be between 0 and 100");
        }
        if (yearResult < 50) {
            return 'F';
        }
        if (yearResult < 60) {
            return 'E';
        }
        if (yearResult < 70) {
            return 'D';
        }
        if (yearResult < 80) {
            return 'C';
        }
        if (yearResult < 90) {
            return 'B';
        }
        return 'A';
    }
}
