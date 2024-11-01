package com.scm;

import com.scm.services.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("dev")
class SmartContactManagerApplicationTests {

    @Test
    void contextLoads(){}

    @Autowired
    private EmailService emailService;
    @Test
    void sendEmailtest(){
        emailService.sendEmail("","Just testing email service","This is a test run for the SCM Project for testing Email service");
    }
}

