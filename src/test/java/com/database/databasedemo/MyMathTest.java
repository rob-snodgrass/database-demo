package com.database.databasedemo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class MyMathTest {

    private MyMath math = new MyMath();
/*
    @Test
    void failTest(){
        fail("Not yet implemented");
    }
 */
    @Test
    void calculateSum_ThreeSizeArray(){
        assertEquals(6, math.sumArray(new int[]{1,2,3}));
    }

    @Test
    void calculateSum_ZeroSizeArray(){
        assertEquals(0, math.sumArray(new int[]{}));
    }

    @Test
    void calculateSum_NegativeArray(){
        assertEquals(-6, math.sumArray(new int[]{-1,-2,-3}));
    }
}
