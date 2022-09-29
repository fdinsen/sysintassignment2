package com.fdinsen.emaillistenerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import services.EmailListenerService;

@SpringBootApplication
public class EmailListenerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmailListenerServiceApplication.class, args);
        EmailListenerService emailListener = new EmailListenerService();
        emailListener.listen();
    }

}
