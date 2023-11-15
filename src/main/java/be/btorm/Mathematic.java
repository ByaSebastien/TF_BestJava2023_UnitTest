package be.btorm;

public class Mathematic {

    public int add(int a,int b){

        if((long)a + (long)b > Integer.MAX_VALUE){
            throw new RuntimeException();
        }
        return a + b;
    }
}
