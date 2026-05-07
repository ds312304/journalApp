package com.example.journalApp.service;

import com.example.journalApp.scheduler.UserScheduler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserSchedulerTest {

    @Autowired
    private UserScheduler userScheduler;

    @Test
    void testFetchUseranSendSaMail(){
        userScheduler.fetchUsersAndSendSAMail();
    }
}
