package com.learnjunit.tdd;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FizzBuzzTest {
    // If no div by 3 - Fizz
    // If no div by 5 - Buzz
    // If no div by both 3,5 - FizzBuzz
    // If not div by both - print no

    @DisplayName("Divisible by 3")
    @Test
    @Order(1)
    void testForDivisibleByThree(){
        String expected = "Fizz";
        assertEquals(expected, FizzBuzz.compute(3), "Should return Fizz");
    }

    @DisplayName("Divisible by 5")
    @Test
    @Order(2)
    void testForDivisibleByFive(){
        String expected = "Buzz";
        assertEquals(expected, FizzBuzz.compute(5), "Should return Buzz");
    }

    @DisplayName("Divisible by 5 and 3")
    @Test
    @Order(3)
    void testForDivisibleByThreeAndFive(){
        String expected = "FizzBuzz";
        assertEquals(expected, FizzBuzz.compute(15), "Should return Buzz");
    }

    @DisplayName("Not Divisible by 5 and 3")
    @Test
    @Order(4)
    void testForNotDivisibleByThreeAndFive(){
        String expected = "7";
        assertEquals(expected, FizzBuzz.compute(7), "Should return Buzz");
    }

    @DisplayName("check list of fizz buzz numbers")
    @Test
    @Order(5)
    void testListOfNumbers(){
        for(int i=1; i<=100; i++){
            String expectedValue = "";
            if(i%3==0 && i%5==0){
                expectedValue = "FizzBuzz";
            }
            else if(i%5==0){
                expectedValue = "Buzz";
            }
            else if(i%3==0){
                expectedValue = "Fizz";
            }
            else{
                expectedValue = String.valueOf(i);
            }
            assertEquals(expectedValue, FizzBuzz.compute(i), "Given Number");
        }
    }

    @Order(5)
    @ParameterizedTest(name = "value={0}, expectedResult={1}")
    @DisplayName("Testing FizzBuzz with csv data file")
    @CsvFileSource(resources = "/fizzBuzzTest.csv")
    void testFizzBuzzParametrized(int value, String expectedResult){
        assertEquals(expectedResult, FizzBuzz.compute(value));
    }
}
