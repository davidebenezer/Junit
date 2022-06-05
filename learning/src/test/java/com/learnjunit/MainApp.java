package com.learnjunit;

import com.learnjunit.tdd.FizzBuzz;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("FizzBuzz No's from 1 to 100");
        System.out.println("***************************************************");
        for(int i=1; i<=100; i++){
            System.out.println(FizzBuzz.compute(i));
        }
        System.out.println("***************************************************");
    }
}
