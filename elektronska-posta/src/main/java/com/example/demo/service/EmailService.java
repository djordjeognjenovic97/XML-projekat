package com.example.demo.service;

import com.example.demo.dto.EmailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;

@Service
public class EmailService {


    @Autowired
    private JavaMailSender mailSender;

    /*
    @Async
    public void confirmRegistration() throws Exception {
        if(user.getEnabled()==true){
            throw new BadAttributeValueExpException("User has already confirmed registration");
        }
        String token = UUID.randomUUID().toString();
        service.createVerificationToken(user, token);

        String recipientAddress = user.getEmail();
        String subject = "Registration Confirmation";
        String confirmationUrl="/registrationConfirm/"+token;
        String message = "Thanks for using Cultural Content app,here is your activation link.";

        SimpleMailMessage email = new SimpleMailMessage();
        //recipientAddress, ali za provjeru za sada moj mail
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText(message + "\r\n" + "http://localhost:4200" + confirmationUrl);
        mailSender.send(email);
    }*/
    @Async
    public void send(EmailDTO emaildto) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,StandardCharsets.UTF_8.name());

        helper.setTo(emaildto.getTo());
        helper.setSubject(emaildto.getSubject());
        helper.setText(emaildto.getText());
        mailSender.send(message);
    }
}
