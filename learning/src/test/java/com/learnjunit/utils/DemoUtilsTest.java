package com.learnjunit.utils;

import com.google.common.collect.Maps;
import com.learnjunit.tdd.FizzBuzz;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.time.Duration;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

//@DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class)
//@DisplayNameGeneration(DisplayNameGenerator.Simple.class)
//@DisplayNameGeneration(DisplayNameGenerator.Standard.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
//@DisplayNameGeneration(ReplaceCamelCase.class)
//@TestMethodOrder(MethodOrderer.MethodName.class)
//@TestMethodOrder(MethodOrderer.DisplayName.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestClassOrder(ClassOrderer.OrderAnnotation.class)
@Order(1)
class DemoUtilsTest {
    DemoUtils demoUtils;

    private int[] intArray2 =  {1,2,3};

    @BeforeAll
    static void befAllTc(){
        //System.out.println("Before All called");
    }

    @AfterAll
    static void afterAllTc(){
        //System.out.println("After all Tests");
    }

    @BeforeEach
    void setupBeforeTest(){
        //System.out.println("BeforeTest Called");
        demoUtils = new DemoUtils();
    }

    @AfterEach
    void cleanUpAfterEachTest(){
        //System.out.println("After Test Called");
        demoUtils = null;
    }
    @Test
    @Order(1)
    @DisplayName("test add +ve nos :)")
    @Disabled
    void testAddPositiveNumbers(){
        assertEquals(6, demoUtils.addValues(4,2), "2+4 should be 6");
        assertNotEquals(6, demoUtils.addValues(1,7), "1+7 should not be 6");
    }

    @Test
    @DisabledForJreRange(max = JRE.JAVA_8)
    void testCheckNull(){
        String abc = "abc";
        String cde = null;
        assertNull(demoUtils.checkNull(cde), "value is not null");
        assertNotNull(demoUtils.checkNull(abc), "value is null");
    }

    @Test
    @Order(3)
    @EnabledOnOs(OS.WINDOWS)
    void testStringSame(){
        String stringPoolValue = "Hello";
        String duplicateString = String.valueOf("Hello");
        String newObjDuplicateString = new String("Hello");
        assertSame(demoUtils.getOriginalString(), stringPoolValue, "not the same string");
        assertSame(demoUtils.getOriginalString(), duplicateString, "not Same String");
        assertNotSame(demoUtils.getOriginalString(), newObjDuplicateString, "Same String");
    }

    @Test
    @Order(-7)
    @DisabledOnOs(OS.LINUX)
    void testGreaterthan(){
        assertFalse(demoUtils.isGreater(1,2), "1 is not greater than 2");
        assertTrue(demoUtils.isGreater(3,1), "3 is greater than 1");
    }

    @Test
    @Order(-7)
    @DisabledOnOs(OS.WINDOWS)
    void testArrayEquals(){
        assertArrayEquals(intArray2, demoUtils.getIntArray(), "Arrays Not Equal");
    }

    @Test
    @EnabledOnOs({OS.LINUX, OS.MAC, OS.WINDOWS})
    void testIterable(){
//        Map newMap = new HashMap();
//        newMap.put("item", "pencil");
//        newMap.put("sku", "1");
        List<Integer> list2 = List.of(1,2,3);
        List<String> stringListTest = new ArrayList<>();
        stringListTest.add("Hello");
        stringListTest.add("everyone");
        assertIterableEquals(list2, demoUtils.getTestList(), "should be same list");
        assertLinesMatch(stringListTest, demoUtils.getStringList());
    }

    @Test
    void testThrow() throws Exception {
        assertThrows(Exception.class, () -> {demoUtils.throwException(0);}, "should throw exception");
        assertDoesNotThrow(() -> {demoUtils.throwException(40);}, "should throw exception");
    }

    @Test
    @EnabledOnJre(JRE.JAVA_17)
    void testTimeOut(){
        assertTimeoutPreemptively(Duration.ofSeconds(3), () -> {demoUtils.checkTimeout();});
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_18)
    void testMapEquals(){
        Map<String, String> mapToCompare = new HashMap<>();
        mapToCompare.put("item", "pencil");
        mapToCompare.put("sku", "1");
        assertTrue(Maps.difference(mapToCompare, demoUtils.getOriginalMap()).areEqual());
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "ENV", matches = "DEV")
    void testOnlyForDevEnv(){
        //
    }

    @Test
    @EnabledIfSystemProperty(named = "ENV1", matches = "DEV")
    void testOnlyForDevSys(){
        //
    }

}