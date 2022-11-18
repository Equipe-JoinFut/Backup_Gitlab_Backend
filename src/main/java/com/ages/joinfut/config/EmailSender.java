package com.ages.joinfut.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSender {

    private final JavaMailSender mailSender;

    public EmailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(String toEmail, String subject, String data){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("joinfut@gmail.com");
        message.setTo(toEmail);

        String[] infos = data.split(",");
        if (infos[4].equals("true")) {
            infos[4] = "Ativo";
        }else {
            infos[4] = "Inativo";
        }
        message.setText("Status da peneira " + infos[0] +
                "\n" + "Local: " + infos[1] +
                "\n" + "Data: " + infos[2] +
                "\n" + "Horário: " + infos[3] +
                "\n" + "Status: " + infos[4]);
        message.setSubject(subject);

        this.mailSender.send(message);
        System.out.println("Teste de email");
    }
}
