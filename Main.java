package com.company;
//Eric Tiancheng Gu

public class Main {
    public static int levelStart(int a){
        double logValue =  Math.log(a)/Math.log(2);
        int level = (int) logValue;

        return (int)Math.pow(2,level);
    }
}
