package com.algorithm;

public class Factorial {
    public static int calculateFactorial(int value){
        if (value < 0)  throw new  IllegalArgumentException("value must be positive");
        if (value == 0) return 1;
        return value * calculateFactorial(value - 1);
    }

    static public void main(String[] args) {
        System.out.println(calculateFactorial(5));
    }
}
