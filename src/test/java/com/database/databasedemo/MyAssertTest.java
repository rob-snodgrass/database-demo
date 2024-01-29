package com.database.databasedemo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.util.AssertionErrors.assertEquals;

public class MyAssertTest {

    List<String> todos = Arrays.asList("AWS","Azure","DevOps");

    @Test
    void Test1(){
        boolean test = true;
        assertTrue(test);
    }

    @Test
    void Test2(){
        boolean test = todos.contains("AWS");
        assertTrue(test);
    }

    @Test
    void SizeTest(){
        assertEquals(3, todos.size());
    }
}
