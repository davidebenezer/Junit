package com.learnjunit.utils;

import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

//@DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class)
//@DisplayNameGeneration(DisplayNameGenerator.Simple.class)
//@DisplayNameGeneration(DisplayNameGenerator.Standard.class)
//@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayNameGeneration(ReplaceCamelCase.class)

class DemoUtilsTest {
    DemoUtils demoUtils;

    private int[] intArray2 =  {1,2,3};

    @BeforeAll
    static void befAllTc(){
        System.out.println("Before All called");
    }

    @AfterAll
    static void afterAllTc(){
        System.out.println("After all Tests");
    }

    @BeforeEach
    void setupBeforeTest(){
        System.out.println("BeforeTest Called");
        demoUtils = new DemoUtils();
    }

    @AfterEach
    void cleanUpAfterEachTest(){
        System.out.println("After Test Called");
        demoUtils = null;
    }
    @Test
    @DisplayName("test add +ve nos :)")
    void testAddPositiveNumbers(){
        assertEquals(6, demoUtils.addValues(4,2), "2+4 should be 6");
        assertNotEquals(6, demoUtils.addValues(1,7), "1+7 should not be 6");
    }

    @Test
    void testCheckNull(){
        String abc = "abc";
        String cde = null;
        assertNull(demoUtils.checkNull(cde), "value is not null");
        assertNotNull(demoUtils.checkNull(abc), "value is null");
    }

    @Test
    void testStringSame(){
        String stringPoolValue = "Hello";
        String duplicateString = String.valueOf("Hello");
        String newObjDuplicateString = new String("Hello");
        assertSame(demoUtils.getOriginalString(), stringPoolValue, "not the same string");
        assertSame(demoUtils.getOriginalString(), duplicateString, "not Same String");
        assertNotSame(demoUtils.getOriginalString(), newObjDuplicateString, "Same String");
    }

    @Test
    void testGreaterthan(){
        assertFalse(demoUtils.isGreater(1,2), "1 is not greater than 2");
        assertTrue(demoUtils.isGreater(3,1), "3 is greater than 1");
    }

    @Test
    void testArrayEquals(){
        assertArrayEquals(intArray2, demoUtils.getIntArray(), "Arrays Not Equal");
    }

    @Test
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
    void testTimeOut(){
        assertTimeoutPreemptively(Duration.ofSeconds(3), () -> {demoUtils.checkTimeout();});
    }
}