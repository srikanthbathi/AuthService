package com.nai.services;


import com.sendgrid.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Notification {


    @Value("${SENDGRID_API_KEY}")
    private String key;

    public void sendEmail(String emailAdd){
        Email email = new Email("naistore@example.com");
        String subject = "Received your request to register with nai ";
        Email to = new Email(emailAdd);
        Content content = new Content("text/plain", "You are amost there");
        Mail mail = new Mail(email, subject, to, content);
        SendGrid sg = new SendGrid(key);
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex) {
        }

    }
}
