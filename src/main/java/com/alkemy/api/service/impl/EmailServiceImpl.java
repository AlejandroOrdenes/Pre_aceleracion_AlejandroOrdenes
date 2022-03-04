package com.alkemy.api.service.impl;

import com.alkemy.api.ApiApplication;
import com.alkemy.api.service.EmailService;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private Environment env;

    @Value("${alkemy.api.email.sender}")
    private String emailSender;

    @Value("${alkemy.api.email.enabled}")
    private boolean enabled;

    private static final Logger logger = LogManager.getLogger(ApiApplication.class);

    public void sendWelcomeEmailTo(String to) throws IOException {
        if (!enabled) {
            return;
        }
        String apiKey = env.getProperty("API_KEY");

        Email fromEmail = new Email(emailSender);
        Email toEmail = new Email(to);
        Content content = new Content(
                "text/plain",
                "Welcome to DisneyApi"
        );
        String subject = "Alkemy Api";

        Mail mail = new Mail(fromEmail, subject, toEmail, content);
        SendGrid sg = new SendGrid(apiKey);
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);

            logger.info(response.getStatusCode());
            logger.info(response.getHeaders());
        } catch (IOException ex) {
            logger.error(ex);
        }

    }
}
