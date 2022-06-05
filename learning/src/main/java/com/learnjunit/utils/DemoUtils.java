package com.learnjunit.utils;

import lombok.*;
import org.apache.commons.collections4.MapUtils;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Generated
public class DemoUtils {
    private String originalString = "Hello";

    private int[] intArray =  {1,2,3};

    private List<Integer> testList = List.of(1,2,3);

    private List<String> stringList = List.of("Hello", "everyone");

    private Map<String, String> originalMap;

    public Map getOriginalMap(){
        if(MapUtils.isEmpty(originalMap)){
            originalMap = new HashMap<>();
            originalMap.put("sku", "1");
            originalMap.put("item", "pencil");
        }
        return originalMap;
    }

    public int addValues(int a, int b){
        return a+b;
    }

    Object checkNull(Object obj){
        return obj!=null ? obj: null;
    }

    public boolean isGreater(int a , int b){
        return a > b;
    }

    public String throwException(int a) throws Exception {
        if(a<1){
            throw new Exception("value should be equal or greater than 1");
        }
        return "value is equal or greater than 1";
    }

    public void checkTimeout() throws InterruptedException{
        System.out.println("I am gonna sleep");
        Thread.sleep(2000);
        System.out.println("Wakey wakey!");
    }
}
