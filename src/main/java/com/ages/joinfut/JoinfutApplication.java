package com.ages.joinfut;

import com.ages.joinfut.config.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class JoinfutApplication {

    public static void main(String[] args) {
        SpringApplication.run(JoinfutApplication.class, args);
    }
}
