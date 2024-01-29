package com.database.databasedemo;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.util.AssertionErrors.assertNull;

public class BeforeAfterTest {

    @BeforeAll
    static void beforeAll(){
        System.out.println("Before all!");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("Maxine!");
    }
    
    @Test
    void Test1(){
        boolean test = true;
        assertTrue(test);
        System.out.println("Test 1");
    }

    @Test
    void Test2(){
        boolean test = false;
        assertFalse(test);
        System.out.println("Test 2");
    }

    @AfterEach
    void afterEach(){
        System.out.println("!enixaM");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("After all!");
    }
}
