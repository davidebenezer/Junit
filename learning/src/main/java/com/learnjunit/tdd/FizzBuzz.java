package com.learnjunit.tdd;

public class FizzBuzz {
    public static String anotherCompute(Integer inputNo){
        boolean fizz = false, buzz = false, fizzbuzz = false;
        if(inputNo%3==0){
            fizz=true;
        }
        if(inputNo%5==0){
            buzz=true;
        }
        if(fizz && buzz){
            return "FizzBuzz";
        }
        else if(fizz){
            return "Fizz";
        }
        else if(buzz){
            return "Buzz";
        }
        else{
            return String.valueOf(inputNo);
        }
    }

    public static String compute(Integer inputNo){
        StringBuilder builder = new StringBuilder();
        if(inputNo%3==0){
            builder.append("Fizz");
        }
        if(inputNo%5==0){
            builder.append("Buzz");
        }
        if(builder.isEmpty()){
            builder.append(inputNo);
        }
        return builder.toString();
    }
}
