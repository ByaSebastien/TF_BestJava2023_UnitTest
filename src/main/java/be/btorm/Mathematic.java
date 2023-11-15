package be.btorm;

public class Mathematic {

    public int add(int a,int b){

        if((long)a + (long)b > Integer.MAX_VALUE){
            throw new RuntimeException();
        }
        return a + b;
    }

    public int division(int a, int b){

        if(b==0){
            throw new DividedByZeroException();
        }
        return a/b;
    }
}
