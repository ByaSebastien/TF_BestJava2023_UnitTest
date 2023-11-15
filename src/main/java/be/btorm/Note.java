package be.btorm;

public class Note {

    public char getLetterNote(int yearResult){

        if(yearResult < 0 || yearResult > 100){
            throw new IllegalArgumentException("Year result must be between 0 and 100");
        } else if (yearResult < 50) {
            return 'F';
        } else if (yearResult < 60) {
            return 'E';
        } else if (yearResult < 70) {
            return 'D';
        } else if (yearResult < 80) {
            return 'C';
        } else if (yearResult < 90) {
            return 'B';
        }else {
            return 'A';
        }
    }
}
