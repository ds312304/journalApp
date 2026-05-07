package com.example.journalApp.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailServiceTest {

    @Autowired
    private EmailService emailService;

    @Test
    void testEmailService(){
        emailService.sendEmail("diyaasingh213@gmail.com","Requestfor solving an error", "There is an error in the code file you provided");
    }
}
