package com.example.journalApp.service;

import com.example.journalApp.repository.UserRepo;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserRepo userRepo;


//
//    @BeforeEach //before running any test
//    void checkCode(){
//
//    }
//
//    @BeforeAll //Before all test cases run this test
//    void setup(){
//
//    }
//
//    @AfterAll //Before all test cases run this test
//    void setAll(){
//
//    }
//
//    @AfterEach //Before all test cases run this test
//    void setNull(){
//
//    }
    @Disabled
    @Test
    public void testFindByUsername(){
        assertNotNull(userRepo.findByUsername("Ram"));
    }

    @Disabled
    @ParameterizedTest
    @CsvSource({
            "1,1,2",
            "2,2,1",
            "5,7,12"
    })
    public void test(int a, int b, int expected){
        assertEquals(expected, a+b);
    }
}
