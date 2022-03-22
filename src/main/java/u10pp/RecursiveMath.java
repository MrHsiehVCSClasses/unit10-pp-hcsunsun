package u10pp;


import java.math.BigInteger;

public class RecursiveMath{

    public static double pow(double base, int exponent){
        int currExp = exponent;
        if(exponent == 0){return 1;}
        else{
            currExp--;
            return base * pow(base, currExp);
        }
    }

    public static BigInteger getFactorial(int n){
        BigInteger result = new BigInteger("" + n);
        BigInteger one = new BigInteger("1");
        if(n <= 1){return one;}
        else{return result.multiply(getFactorial(n - 1));}
    }

    public static int getFibonacciNumber(int n){
        if(n <= 2){return 1;}
        else{return getFibonacciNumber(n - 1) + getFibonacciNumber(n - 2);}
    }
}