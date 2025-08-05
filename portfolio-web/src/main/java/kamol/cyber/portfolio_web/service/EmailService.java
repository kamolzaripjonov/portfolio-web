package kamol.cyber.portfolio_web.service;

import kamol.cyber.portfolio_web.entity.ContactMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String fromEmail;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendContactEmail(ContactMessage contactMessage) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail);
        message.setTo(fromEmail);
        message.setSubject("Portfolio Kontakt Xabari: " + contactMessage.getName());
        message.setText("Yuboruvchi: " + contactMessage.getName() + "\n"
                + "Email: " + contactMessage.getEmail() + "\n"
                + "Xabar: " + contactMessage.getMessage());
        mailSender.send(message);
    }
}